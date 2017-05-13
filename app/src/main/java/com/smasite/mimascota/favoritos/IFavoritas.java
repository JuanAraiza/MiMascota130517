package com.smasite.mimascota.favoritos;

import com.smasite.mimascota.Adapter.MascotaFavAdaptor;
import com.smasite.mimascota.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by macbookretina on 11/05/17.
 */

public interface IFavoritas {
    public void generarLinearLayoutVertical();

    public MascotaFavAdaptor crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaFavAdaptor adaptador);
}
