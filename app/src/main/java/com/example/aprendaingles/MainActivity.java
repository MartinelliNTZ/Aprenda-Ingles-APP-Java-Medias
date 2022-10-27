package com.example.aprendaingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.aprendaingles.fragments.AnimalsFragment;
import com.example.aprendaingles.fragments.NumbersFragment;
import com.example.aprendaingles.fragments.VogaisFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {
    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smartTabLayout=findViewById(R.id.viewPagerTab);
        viewPager=findViewById(R.id.viewPager);
        getSupportActionBar().hide();


        criarAbas();

    }
    public void criarAbas(){
        //cria um adaptador
        //ta tudo ok
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add(R.string.animals, AnimalsFragment.class)
                        .add(R.string.numbers, NumbersFragment.class)
                        .create());


        //configura as abas
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);

        getSupportActionBar().setElevation(0);
    }


}