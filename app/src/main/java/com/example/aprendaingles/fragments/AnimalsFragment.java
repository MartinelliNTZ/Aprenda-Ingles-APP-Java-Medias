package com.example.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalsFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //variaiveis
    private int macaco;
    private MediaPlayer mediaPlayer;
    private ImageButton btMacaco, btVaca, btLeao, btOvelha, btCachorro, btGato;

    public AnimalsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimalsFragment newInstance(String param1, String param2) {
        AnimalsFragment fragment = new AnimalsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_animals, container, false);

        macaco = R.raw.monkey;
        btCachorro=view.findViewById(R.id.btCachorro);
        btMacaco=view.findViewById(R.id.btMacaco);
        btVaca=view.findViewById(R.id.btVaca);
        btLeao=view.findViewById(R.id.btLeao);
        btOvelha=view.findViewById(R.id.btOvelha);
        btGato=view.findViewById(R.id.btGato);

        btGato.setOnClickListener(this);
        btCachorro.setOnClickListener(this);
        btMacaco.setOnClickListener(this);
        btVaca.setOnClickListener(this);
        btLeao.setOnClickListener(this);
        btOvelha.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btCachorro:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.dog);
                tocaMusica();
                break;

            case R.id.btGato:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.cat);
                tocaMusica();
                break;

            case R.id.btLeao:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.lion);
                tocaMusica();
                break;

            case R.id.btMacaco:
                mediaPlayer=MediaPlayer.create(getActivity(),macaco);
                tocaMusica();
                break;

            case R.id.btOvelha:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.sheep);
                tocaMusica();
                break;

            case R.id.btVaca:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.cow);
                tocaMusica();
                break;


        }
    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }
    private void tocaMusica(){
        if(mediaPlayer!=null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mmediaPlayer) {
                    mediaPlayer.release();

                }
            });//método executado quando a musica é encerrada
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null) {
            mediaPlayer.release();
            mediaPlayer =null;
        }
    }
}