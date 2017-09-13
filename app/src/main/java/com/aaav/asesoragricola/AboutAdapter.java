package com.aaav.asesoragricola;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aaav.asesoragricola.Fragments.ImagenCorporativa;
import com.aaav.asesoragricola.Fragments.ObjetivosCortoP;
import com.aaav.asesoragricola.Fragments.ObjetivosMedianoP;

/**
 * Created by aaace_000 on 18/5/2017.
 */

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.AboutHolder> {

    private Activity activity;
    private String[] array;
    private FragmentManager fm;

    public AboutAdapter(Activity activity, FragmentManager fm) {
        this.activity = activity;
        this.fm = fm;
        this.array = activity.getResources().getStringArray(R.array.n_empresa_array);
    }

    protected class AboutHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private CardView cardView;

        public AboutHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.recycler_text);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }

    @Override
    public AboutHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = activity.getLayoutInflater().inflate(R.layout.recycler_item, parent, false);
        AboutHolder holder = new AboutHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(AboutHolder holder, final int position) {
        holder.textView.setText(array[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elegirVista(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.length;
    }



    private void elegirVista(int adapterPosition) {
        Fragment fragment = null;
        switch (adapterPosition){
            case 0:
                fragment= new ImagenCorporativa();
                break;
            case 1:
                fragment = new ObjetivosCortoP();
                break;
            case 2:
                fragment = new ObjetivosMedianoP();
                break;
        }

        actualizarFragment(fragment);

    }

    private void actualizarFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        if (activity.findViewById(R.id.contenedor) != null)
            fragmentTransaction.replace(R.id.contenedor, fragment).addToBackStack(fragment.getTag()).commit();

        else
            fragmentTransaction.add(R.id.contenedor, fragment).addToBackStack(fragment.getTag()).commit();
    }
}
