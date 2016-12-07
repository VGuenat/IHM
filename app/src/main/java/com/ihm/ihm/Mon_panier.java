package com.ihm.ihm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Mon_panier extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_panier);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        TextView headerWeek = new TextView(this);
//        headerWeek.setText(R.string.list_header_next_week);

        ListView listViewSemaine = (ListView) findViewById(R.id.liste_panier_semaine);
//        listViewSemaine.addHeaderView(headerWeek);
        List<ConcertListeItem> itemsSemaine = genererItems();
        ConcertListeItemAdapter adapterSemaine = new ConcertListeItemAdapter(this,itemsSemaine);
        listViewSemaine.setAdapter(adapterSemaine);

//        TextView headerMonth = new TextView(this);
//        headerMonth.setText(R.string.list_header_next_month);

        ListView listViewMois = (ListView) findViewById(R.id.liste_panier_mois);
//        listViewMois.addHeaderView(headerMonth);
        List<ConcertListeItem> itemsMois = genererItems();
        ConcertListeItemAdapter adapterMois = new ConcertListeItemAdapter(this,itemsMois);
        listViewMois.setAdapter(adapterMois);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listViewMois.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Mon_panier.this, Concert.class);
                startActivity(i);
            }
        });

        listViewSemaine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Mon_panier.this, Concert.class);
                startActivity(i);
            }
        });
    }

    public List<ConcertListeItem> genererItems() {
        List<ConcertListeItem> liste = new ArrayList<ConcertListeItem>();
        liste.add(new ConcertListeItem(R.drawable.memories, "David Ghetto","11/12/2016","Toulouse"));
        liste.add(new ConcertListeItem(R.drawable.blue, "Eiffel65","12/12/2016","Rambouillet"));
        liste.add(new ConcertListeItem(R.drawable.inframan, "Dr Peacock","17/01/2017","Alzonne"));
        liste.add(new ConcertListeItem(R.drawable.sevran, "Kaaris","22/01/2017","Les Beaudottes"));
        return liste;
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
