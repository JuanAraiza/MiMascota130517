package com.smasite.mimascota.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smasite.mimascota.Pojo.ConstructorMascotas;
import com.smasite.mimascota.Pojo.Mascota;
import com.smasite.mimascota.R;

import java.util.ArrayList;

/**
 * Created by macbookretina on 30/04/17.
 */

public class MascotaAdaptor extends RecyclerView.Adapter<MascotaAdaptor.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptor(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_listado_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }





    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRaik.setText(String.valueOf(mascota.getRaick()));

        mascotaViewHolder.btnRaik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Toast.makeText(activity, "Diste Ranking a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darRaickMascota(mascota);
                int raicks = constructorMascotas.obtenerRaickMascota(mascota);
                mascotaViewHolder.tvRaik.setText(String.valueOf(raicks));


            }
        });


    }

    @Override
    public int getItemCount() { return mascotas.size(); }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombre;
        private TextView tvRaik;
        private ImageView imgFoto;
        private ImageButton btnRaik;

    public MascotaViewHolder(View itemView) {
        super(itemView);
        tvNombre      = (TextView) itemView.findViewById(R.id.tvNombre);
        imgFoto        = (ImageView) itemView.findViewById(R.id.imgFoto);
        tvRaik      = (TextView) itemView.findViewById(R.id.tvRaik);
        btnRaik      = (ImageButton) itemView.findViewById(R.id.btnRaik);


    }
}




}
