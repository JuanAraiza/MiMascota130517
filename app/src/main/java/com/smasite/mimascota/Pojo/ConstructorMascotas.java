package com.smasite.mimascota.Pojo;

import android.content.ContentValues;
import android.content.Context;

import com.smasite.mimascota.Pojo.Mascota;
import com.smasite.mimascota.R;
import com.smasite.mimascota.db.BaseDatos;
import com.smasite.mimascota.db.ConstantesBaseDatos;

import java.util.ArrayList;

/**
 * Created by macbookretina on 11/05/17.
 */

public class ConstructorMascotas {

    private static final Integer RAICK = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerTodasLasMascotas();

    }
    public ArrayList<Mascota> obtenerDatosFav(){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerTodasLasMascotasFav();

    }
    public void insertarCincoMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Alam");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog1);
        db.insertarMascota(contentValues);

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Hercules");
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog2);
        db.insertarMascota(contentValues2);

        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Hachiko");
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog3);
        db.insertarMascota(contentValues3);

        ContentValues contentValues4 = new ContentValues();
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Terry");
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog4);
        db.insertarMascota(contentValues4);

        ContentValues contentValues5 = new ContentValues();
        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Canela");
        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog5);
        db.insertarMascota(contentValues5);

    }

    public void darRaickMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RAIK_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RAIK_MASCOTA_NUMERO_RAIK, RAICK);
        db.insertarRaickMascota(contentValues);

    }

    public int obtenerRaickMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRaicks(mascota);
    }
}
