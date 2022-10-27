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
 * Use the {@link NumbersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumbersFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MediaPlayer mediaPlayer;
    private ImageButton btUm, btDois, btTres, btQuatro, btCinco, btSeis;

    public NumbersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumbersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumbersFragment newInstance(String param1, String param2) {
        NumbersFragment fragment = new NumbersFragment();
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
        View view= inflater.inflate(R.layout.fragment_numbers, container, false);
        btUm =view.findViewById(R.id.btUm);
        btDois =view.findViewById(R.id.btDois);
        btTres =view.findViewById(R.id.btTres);
        btQuatro =view.findViewById(R.id.btQuatro);
        btCinco =view.findViewById(R.id.btCinco);
        btSeis =view.findViewById(R.id.btSeis);

        btUm.setOnClickListener(this);
        btDois.setOnClickListener(this);
        btTres.setOnClickListener(this);
        btQuatro.setOnClickListener(this);
        btCinco.setOnClickListener(this);
        btSeis.setOnClickListener(this);


        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btUm:
                mediaPlayer= MediaPlayer.create(getActivity(),R.raw.one);
                tocaMusica();
                break;

            case R.id.btDois:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.two);
                tocaMusica();
                break;

            case R.id.btTres:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.three);
                tocaMusica();
                break;

            case R.id.btQuatro:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.four);
                tocaMusica();
                break;

            case R.id.btCinco:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.five);
                tocaMusica();
                break;

            case R.id.btSeis:
                mediaPlayer=MediaPlayer.create(getActivity(),R.raw.six);
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