package com.aaav.asesoragricola.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.aaav.asesoragricola.R;

/**
 * Created by Armando Acevedo on 23/8/2017.
 */

public class AcercaNosotros extends Fragment {

    public interface OnAboutListener {
        void setRating(float rating);
    }

    OnAboutListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.acerca_nosotros, container, false);

        RatingBar rb = view.findViewById(R.id.rating_bar);

        listener.setRating(rb.getRating());

        return inflater.inflate(R.layout.acerca_nosotros, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (OnAboutListener) getActivity();
        } catch (ClassCastException ex) {
            throw new ClassCastException(getActivity().toString() + " no se implementó la interfaz OnAboutListener");
        }
    }
}
