package com.aaav.asesoragricola.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaav.asesoragricola.AboutAdapter;
import com.aaav.asesoragricola.R;

/**
 * Created by Armando Acevedo on 23/8/2017.
 */

public class NuestraEmpresa extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.nuestra_empresa, container, false);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_about);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AboutAdapter(getActivity(), getFragmentManager()));

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        return view;
    }

}
