package com.smasite.mimascota.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.smasite.mimascota.Pojo.ConstructorMascotas;
import com.smasite.mimascota.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by macbookretina on 11/05/17.
 */

public class BaseDatos  extends SQLiteOpenHelper  {

    private Context context;


    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASENAME, null, ConstantesBaseDatos.DATABASEVERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "("+
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE +   " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO +     " INTEGER "
                + ")";
        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_RAIK_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_RAIK_MASCOTA_ID_MASCOTA +   " INTEGER, " +
                ConstantesBaseDatos.TABLE_RAIK_MASCOTA_NUMERO_RAIK +     " INTEGER, " +
                "FOREIGN KEY(" + ConstantesBaseDatos.TABLE_RAIK_MASCOTA_ID_MASCOTA +
                ") " + "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "("+ ConstantesBaseDatos.TABLE_MASCOTA_ID +")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryRaicks = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_RAIK_MASCOTA_NUMERO_RAIK + ") as raicks " +
                    " FROM " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryRaicks, null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setRaick(registrosLikes.getInt(0));
            }else{
                mascotaActual.setRaick(0);
            }


            contactos.add(mascotaActual);

        }
        db.close();
        return contactos;
    }

    public ArrayList<Mascota> obtenerTodasLasMascotasFav(){
        ArrayList<Mascota> contactos = new ArrayList<>();

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_RAIK_MASCOTA_NUMERO_RAIK + ") as raicks, "+ConstantesBaseDatos.TABLE_RAIK_MASCOTA_ID_MASCOTA+" FROM " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA + " GROUP BY " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA_ID_MASCOTA + " ORDER BY raicks DESC limit 5" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while(registros.moveToNext()){




        String query2 = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " WHERE  " + ConstantesBaseDatos.TABLE_MASCOTA_ID + "=" + registros.getInt(1) ;
        Cursor registros2 = db.rawQuery(query2, null);
        while(registros2.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros2.getInt(0));
            mascotaActual.setNombre(registros2.getString(1));
            mascotaActual.setFoto(registros2.getInt(2));

            String queryRaicks = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_RAIK_MASCOTA_NUMERO_RAIK + ") as raicks " +
                    " FROM " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosRaicks = db.rawQuery(queryRaicks, null);
            if(registrosRaicks.moveToNext()){
                mascotaActual.setRaick(registrosRaicks.getInt(0));
            }else{
                mascotaActual.setRaick(0);
            }


            contactos.add(mascotaActual);

        }

        }
        db.close();
        return contactos;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarRaickMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RAIK_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerRaicks(Mascota mascota){
        int raicks = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_RAIK_MASCOTA_NUMERO_RAIK +") as raicks" +
                " FROM " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_RAIK_MASCOTA_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()) {
            raicks = registros.getInt(0);
        }

        db.close();
        return raicks;
    }
}
