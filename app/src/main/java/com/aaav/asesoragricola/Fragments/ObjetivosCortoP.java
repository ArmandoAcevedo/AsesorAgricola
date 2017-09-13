package com.aaav.asesoragricola.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class ObjetivosCortoP extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.objetivos_corto_p, container, false);
    }

}
