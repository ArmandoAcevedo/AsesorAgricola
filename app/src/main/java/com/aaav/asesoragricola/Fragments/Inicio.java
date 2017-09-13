package com.aaav.asesoragricola.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.aaav.asesoragricola.R;

/**
 * Created by aaace_000 on 11/6/2017.
 */

public class Inicio extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.inicio, container, false);

//        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View image = view.findViewById(R.id.imageAnim);
//                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.animation_image);
//                image.startAnimation(animation);
//            }
//        });

        return view;
    }
}
