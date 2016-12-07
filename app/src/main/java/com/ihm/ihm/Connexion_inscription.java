package com.ihm.ihm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Connexion_inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_connexion_inscription);

        Button btn = (Button) findViewById(R.id.button_connexion);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Connexion_inscription.this, Accueil.class);
                i.putExtra("Connected",true);
                startActivity(i);
            }
        });
        Button btn1 = (Button) findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Connexion_inscription.this, Accueil.class);
                i.putExtra("Connected",true);
                startActivity(i);
            }
        });
    }

    public void vers_accueil (View view) {
        Intent i = new Intent(Connexion_inscription.this, Accueil.class);
        startActivity(i);
    }
}
