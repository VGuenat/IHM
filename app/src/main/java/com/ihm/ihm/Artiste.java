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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Artiste extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artiste);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listViewRegion = (ListView) findViewById(R.id.liste_resultats);
//        listViewRegion.addHeaderView(headerRegion);
        List<ConcertListeItem> itemsRegion = genererItemsRegion();
        ConcertListeItemAdapter adapterRegion = new ConcertListeItemAdapter(this, itemsRegion);
        listViewRegion.setAdapter(adapterRegion);

//        TextView headerFrance = new TextView(this);
//        headerFrance.setText(R.string.list_header_france);

        ListView listViewFrance = (ListView) findViewById(R.id.liste_resultats_france);
//        listViewFrance.addHeaderView(headerFrance);
        List<ConcertListeItem> itemsFrance = genererItemsFrance();
        ConcertListeItemAdapter adapterFrance = new ConcertListeItemAdapter(this,itemsFrance);
        listViewFrance.setAdapter(adapterFrance);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public List<ConcertListeItem> genererItemsRegion() {
        List<ConcertListeItem> liste = new ArrayList<ConcertListeItem>();
        liste.add(new ConcertListeItem(R.drawable.sevran, "Kaaris","22/01/2017","S.E.V.R.A.N"));
        liste.add(new ConcertListeItem(R.drawable.sevran, "Kaaris","23/03/2017","S.E.V.R.A.N"));
        return liste;
    }
    public List<ConcertListeItem> genererItemsFrance() {
        List<ConcertListeItem> liste = new ArrayList<ConcertListeItem>();
        liste.add(new ConcertListeItem(R.drawable.sevran, "Kaaris","22/01/2017","S.E.V.R.A.N"));
        liste.add(new ConcertListeItem(R.drawable.sevran, "Kaaris","23/03/2017","S.E.V.R.A.N"));
        liste.add(new ConcertListeItem(R.drawable.sevran, "Kaaris","24/04/2017","S.E.V.R.A.N"));
        liste.add(new ConcertListeItem(R.drawable.sevran, "Kaaris","25/06/2017","S.E.V.R.A.N"));
        return liste;
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
        getMenuInflater().inflate(R.menu.menu_connecte, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_mon_profil) {
            Intent i = new Intent(this, Mon_profil.class);
            startActivity(i);
            return true;
        }
        else if (id == R.id.action_rechercher) {
            Intent i = new Intent(this, Recherche.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
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
}
