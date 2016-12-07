package com.ihm.ihm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.InputType;
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
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Recherche extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final EditText date_debut = (EditText) findViewById(R.id.recherche_date_debut);
        final EditText date_fin = (EditText) findViewById(R.id.recherche_date_fin);

// disable keyboard from showing
        date_debut.setInputType(InputType.TYPE_NULL);
        date_fin.setInputType(InputType.TYPE_NULL);

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date_deb = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRENCH);
                date_debut.setText(sdf.format(myCalendar.getTime()));
            }
        };

        date_debut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(Recherche.this, date_deb, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dp.show();
            }
        });

        final DatePickerDialog.OnDateSetListener date_f = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRENCH);
                date_fin.setText(sdf.format(myCalendar.getTime()));
            }
        };

        date_fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(Recherche.this, date_f, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dp.show();
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

    public void vers_resultats (View view) {
        Intent i = new Intent(this, Resultat_recherche.class);
        startActivity(i);
    }

}
