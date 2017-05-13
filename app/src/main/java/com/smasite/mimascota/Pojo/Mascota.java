package com.smasite.mimascota.Pojo;

/**
 * Created by macbookretina on 30/04/17.
 */

public class Mascota {
    private int id;
    private String nombre;
    private int foto;
    private int raick=0;

    public Mascota(int foto, String nombre, int raick) {
        this.nombre = nombre;
        this.raick = raick;
        this.foto = foto;

    }

    public Mascota() {


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaick() {
        return raick;
    }

    public void setRaick(int raick) {
        this.raick = raick;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
