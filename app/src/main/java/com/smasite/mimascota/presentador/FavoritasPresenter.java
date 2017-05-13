package com.smasite.mimascota.presentador;

import android.content.Context;

import com.smasite.mimascota.favoritos.IFavoritas;
import com.smasite.mimascota.Pojo.ConstructorMascotas;
import com.smasite.mimascota.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by macbookretina on 11/05/17.
 */

public class FavoritasPresenter implements IRecylcerViewFragmentPresenter  {

    private IFavoritas iFavoritas;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FavoritasPresenter(IFavoritas iFavoritas, Context context) {
        this.iFavoritas=iFavoritas;
        this.context=context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosFav();
        mosrarMascotasRV();
    }

    @Override
    public void mosrarMascotasRV() {
        iFavoritas.inicializarAdaptadorRV(iFavoritas.crearAdaptador(mascotas));
        iFavoritas.generarLinearLayoutVertical();
    }
}
