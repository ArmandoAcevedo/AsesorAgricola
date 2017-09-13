package com.aaav.asesoragricola;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aaav.asesoragricola.Fragments.AcercaNosotros;
import com.aaav.asesoragricola.Fragments.Contactanos;
import com.aaav.asesoragricola.Fragments.Inicio;
import com.aaav.asesoragricola.Fragments.NuestraEmpresa;
import com.aaav.asesoragricola.Fragments.NuestroEquipo;
import com.aaav.asesoragricola.Fragments.OperadoresProduccion;
import com.aaav.asesoragricola.Fragments.Servicios;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        AcercaNosotros.OnAboutListener {

    private Toolbar toolbar;
    private float rating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Inicio inicio = new Inicio();
        actualizarFragment(inicio);
        toolbar.setSubtitle(R.string.inicio);
    }

    private void actualizarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (findViewById(R.id.contenedor) != null)
            fragmentTransaction.replace(R.id.contenedor, fragment).addToBackStack(fragment.getTag()).commit();

        else
            fragmentTransaction.add(R.id.contenedor, fragment).addToBackStack(fragment.getTag()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.inicio) {
            fragment = new Inicio();
            toolbar.setSubtitle(R.string.inicio);

        } else if (id == R.id.empresa) {
            fragment = new NuestraEmpresa();
            actualizarFragment(fragment);
            toolbar.setSubtitle(R.string.nuestra_empresa);

        } else if (id == R.id.equipo) {
            fragment = new NuestroEquipo();
            toolbar.setSubtitle(R.string.nuestro_equipo);

        } else if (id == R.id.servicios) {
            fragment = new Servicios();
            toolbar.setSubtitle(R.string.servicios);

        } else if (id == R.id.produccion)        {
            fragment = new OperadoresProduccion();
            toolbar.setSubtitle(R.string.operadores_de_producci_n);

        } else if (id == R.id.contact){
            fragment = new Contactanos();
            toolbar.setSubtitle(R.string.contactanos);

        } else if (id == R.id.about){
            fragment = new AcercaNosotros();
            toolbar.setSubtitle(R.string.acerca_de_nosotros);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        actualizarFragment(fragment);

        return true;


    }

    public void enviarRating(View view) {

        Toast.makeText(this, "Calificación enviada", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setRating(float rating) {
        this.rating = rating;
    }

}
