package com.smasite.mimascota.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smasite.mimascota.Pojo.Mascota;
import com.smasite.mimascota.R;

import java.util.ArrayList;

/**
 * Created by macbookretina on 07/05/17.
 */

public class PerfilMascotaAdpter  extends RecyclerView.Adapter<PerfilMascotaAdpter.DMascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilMascotaAdpter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;

    }
    @Override
    public PerfilMascotaAdpter.DMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_perfil_mascota, parent, false);
        return new PerfilMascotaAdpter.DMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DMascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvRaik.setText(String.valueOf(mascota.getRaick()));
    }



    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class DMascotaViewHolder extends RecyclerView.ViewHolder{


        private TextView tvRaik;
        private ImageView imgFoto;


        public DMascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto        = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvRaik      = (TextView) itemView.findViewById(R.id.tvRaik);



        }
    }
}
