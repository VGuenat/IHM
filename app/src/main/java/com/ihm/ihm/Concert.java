package com.ihm.ihm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Concert extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.liste_commentaire);
//        listView.addHeaderView(header);
        List<AvisListeItem> items = genererItems();
        AvisListeItemAdapter adapter = new AvisListeItemAdapter(this,items);
        listView.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView img = (ImageView) findViewById(R.id.imageView4);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Concert.this, Artiste.class);
                startActivity(i);            }
        });
        Button btn = (Button) findViewById(R.id.button12);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Concert.this, Paiement.class);
                startActivity(i);
            }
        });

        Button btn1 = (Button) findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Concert.this, Avis.class);
                startActivity(i);
            }
        });
    }


    public List<AvisListeItem> genererItems() {
        List<AvisListeItem> liste = new ArrayList<AvisListeItem>();
        liste.add(new AvisListeItem(R.drawable.profil, "Jean-Jacques", "Vraiment trop bien !"));
        liste.add(new AvisListeItem(R.drawable.profil, "Marie29", "Au top !"));
        liste.add(new AvisListeItem(R.drawable.profil, "Bernardo", "Trop nul, j'ai pas aimé !"));
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
        if (getIntent().getBooleanExtra("Connected",false))
            getMenuInflater().inflate(R.menu.menu_connecte, menu);
        else
            getMenuInflater().inflate(R.menu.accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_connection_inscription) {
            Intent i = new Intent(this, Connexion_inscription.class);
            startActivity(i);
            return true;
        }
        else if (id == R.id.action_mon_profil) {
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
            if (getIntent().getBooleanExtra("Connected",false)) {
                Intent i = new Intent(this, Mon_profil.class);
                startActivity(i);
            }
        } else if (id == R.id.nav_panier) {
            if (getIntent().getBooleanExtra("Connected",false)) {
                Intent i = new Intent(this, Mon_panier.class);
                startActivity(i);
            }
        } else if (id == R.id.nav_historique) {
            if (getIntent().getBooleanExtra("Connected",false)) {
                Intent i = new Intent(this, Mon_historique.class);
                startActivity(i);
            }
        } else if (id == R.id.nav_notif) {
            if (getIntent().getBooleanExtra("Connected",false)) {
                Intent i = new Intent(this, Mes_notifications.class);
                startActivity(i);
            }
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
    public void vers_avis (View view) {
        Intent i = new Intent(this, Avis.class);
        startActivity(i);
    }

    public void vers_paiement (View view) {
        Intent i = new Intent(this, Paiement.class);
        startActivity(i);
    }
}
