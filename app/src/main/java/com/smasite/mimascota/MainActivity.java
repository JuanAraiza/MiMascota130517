package com.smasite.mimascota;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.smasite.mimascota.Adapter.PageAdapter;
import com.smasite.mimascota.Fragments.PerfilFragment;
import com.smasite.mimascota.Fragments.RecyclerviewFragment;
import com.smasite.mimascota.favoritos.Favoritas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   // private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setupViewPager();


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

/*
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.mContacto:
                Intent intent1 = new Intent(this, ContactoActivity.class);
                startActivity(intent1);
                break;
            case R.id.mAcercade:
                Intent intent2 = new Intent(this, AcercaDe.class);
                startActivity(intent2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    public void setupViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.doghouse);
        tabLayout.getTabAt(1).setIcon(R.drawable.dogface);
    }


    public void irFavoritos(View v){
        Intent intent = new Intent(this, Favoritas.class);
        startActivity(intent);
    }
}
