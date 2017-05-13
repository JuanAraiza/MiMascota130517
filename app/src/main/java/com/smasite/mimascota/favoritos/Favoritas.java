package com.smasite.mimascota.favoritos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.smasite.mimascota.Adapter.MascotaFavAdaptor;
import com.smasite.mimascota.Pojo.Mascota;
import com.smasite.mimascota.R;
import com.smasite.mimascota.favoritos.IFavoritas;
import com.smasite.mimascota.presentador.FavoritasPresenter;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity implements IFavoritas {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private FavoritasPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setNavigationIcon(R.drawable.back_26);
        setSupportActionBar(miActionBar);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        presenter = new FavoritasPresenter(this, getApplicationContext());

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaFavAdaptor crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaFavAdaptor adaptador = new MascotaFavAdaptor(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaFavAdaptor adaptador) {
        rvMascotas.setAdapter(adaptador);

    }


}
