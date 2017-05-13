package com.smasite.mimascota.Fragments;

import com.smasite.mimascota.Adapter.MascotaAdaptor;
import com.smasite.mimascota.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by macbookretina on 11/05/17.
 */

public interface IRecycleViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptor crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptor adaptador);
}
