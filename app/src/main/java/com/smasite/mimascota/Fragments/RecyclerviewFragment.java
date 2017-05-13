package com.smasite.mimascota.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smasite.mimascota.Adapter.MascotaAdaptor;
import com.smasite.mimascota.Pojo.Mascota;
import com.smasite.mimascota.R;
import com.smasite.mimascota.presentador.IRecylcerViewFragmentPresenter;
import com.smasite.mimascota.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerviewFragment extends Fragment implements IRecycleViewFragmentView {


    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecylcerViewFragmentPresenter presenter;

    public RecyclerviewFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptor crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptor adaptador = new MascotaAdaptor(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptor adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
