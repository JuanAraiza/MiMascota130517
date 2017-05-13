package com.smasite.mimascota.presentador;

import android.content.Context;

import com.smasite.mimascota.Fragments.IRecycleViewFragmentView;
import com.smasite.mimascota.Pojo.ConstructorMascotas;
import com.smasite.mimascota.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by macbookretina on 11/05/17.
 */

public class RecyclerViewFragmentPresenter implements IRecylcerViewFragmentPresenter {

    private IRecycleViewFragmentView iRecycleViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecycleViewFragmentView iRecycleViewFragmentView, Context context) {
        this.iRecycleViewFragmentView=iRecycleViewFragmentView;
        this.context=context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas= new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mosrarMascotasRV();
    }

    @Override
    public void mosrarMascotasRV() {
        iRecycleViewFragmentView.inicializarAdaptadorRV(iRecycleViewFragmentView.crearAdaptador(mascotas));
        iRecycleViewFragmentView.generarLinearLayoutVertical();
    }
}
