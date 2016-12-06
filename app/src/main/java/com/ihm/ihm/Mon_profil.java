package com.ihm.ihm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class Mon_profil extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_profil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final SeekBar sk=(SeekBar) findViewById(R.id.seekBar);

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                final TextView seekText =(TextView) findViewById(R.id.textView21);
                seekText.setText(progress + " km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_acceuil) {
            Intent i = new Intent(this, Accueil.class);
            startActivity(i);
        } else if (id == R.id.nav_profil) {
            Intent i = new Intent(this, Mon_profil.class);
            startActivity(i);
        } else if (id == R.id.nav_panier) {
            Intent i = new Intent(this, Mon_panier.class);
            startActivity(i);
        } else if (id == R.id.nav_historique) {
            Intent i = new Intent(this, Mon_historique.class);
            startActivity(i);
        } else if (id == R.id.nav_notif) {
            Intent i = new Intent(this, Mes_notifications.class);
            startActivity(i);
        } else if (id == R.id.nav_politique) {
            Intent i = new Intent(this, Politique_securite.class);
            startActivity(i);
        } else if (id == R.id.nav_condition) {
            Intent i = new Intent(this, Conditions_generales.class);
            startActivity(i);
        } else if (id == R.id.app_bar_search) {
            Intent i = new Intent(this, Recherche.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void vers_paiement (View view) {
        Intent i = new Intent(this, Paiement.class);
        startActivity(i);
    }

    public void vers_accueil (View view) {
        Intent i = new Intent(this, Accueil.class);
        startActivity(i);
    }
    public void vers_gerer_artiste (View view) {
        Intent i = new Intent(this, Gerer_artiste.class);
        startActivity(i);
    }
}
