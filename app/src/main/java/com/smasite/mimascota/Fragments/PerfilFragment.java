package com.smasite.mimascota.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.smasite.mimascota.Adapter.PerfilMascotaAdpter;
import com.smasite.mimascota.Pojo.Mascota;
import com.smasite.mimascota.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private CircularImageView circularImageView;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        circularImageView = (CircularImageView) v.findViewById(R.id.circularImageView);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascotas);


        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();

        initializerAdaptor();


        circularImageView.setBorderWidth(5 * (int) getResources().getDisplayMetrics().density);
        circularImageView.setShadowRadius(5);

        return v;


    }

    public void initializerAdaptor(){
        PerfilMascotaAdpter adaptor = new PerfilMascotaAdpter(mascotas, getActivity());
        listaMascotas.setAdapter(adaptor);

    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.dog3,"Hercules", 1));
        mascotas.add(new Mascota(R.drawable.dog3,"Hercules", 2));
        mascotas.add(new Mascota(R.drawable.dog3,"Hercules", 3));
        mascotas.add(new Mascota(R.drawable.dog3,"Hercules", 4));
        mascotas.add(new Mascota(R.drawable.dog3,"Hercules", 5));
        mascotas.add(new Mascota(R.drawable.dog3,"Hercules", 1));
    }

}
