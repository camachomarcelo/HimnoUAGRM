package com.dranser.himnouagrm;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Orientación de la pantalla

        btn = (Button)findViewById(R.id.btn_share);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String compartirTitulo = "Descarga gratis la app Himno UAGRM :)";
                String compartirAsunto = "Instala Himno UAGRM, es gratis :)\n https://play.google.com/store/apps/details?id=com.dranser.himnouagrm";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,compartirTitulo);
                myIntent.putExtra(Intent.EXTRA_TEXT,compartirAsunto);
                startActivity(Intent.createChooser(myIntent, "Compartir usando:"));
            }
        });

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }
}
