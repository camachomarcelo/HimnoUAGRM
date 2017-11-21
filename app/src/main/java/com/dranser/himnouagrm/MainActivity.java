package com.dranser.himnouagrm;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn, play, pause, stop;

    MediaPlayer mdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Orientación de la pantalla

        //Reproductor

        play = (Button)findViewById(R.id.btn_play);
        pause = (Button)findViewById(R.id.btn_pause);
        stop = (Button)findViewById(R.id.btn_stop);

        mdx = MediaPlayer.create(MainActivity.this,R.raw.himnouagrm);



        //Botón para compartir

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

    //Acciones del Reproductor

    public void clkplay(View view){
        mdx.start();
        Toast.makeText(MainActivity.this, "Himno iniciado", Toast.LENGTH_SHORT).show();
    }

    public void clkpause(View view){
        mdx.pause();
        Toast.makeText(MainActivity.this, "Himno pausado", Toast.LENGTH_SHORT).show();
    }

    public void clkstop(View view){
        mdx.stop();
        mdx = MediaPlayer.create(MainActivity.this,R.raw.himnouagrm); //Reproduce nuevamente
        Toast.makeText(MainActivity.this, "Himno detenido", Toast.LENGTH_SHORT).show();
    }
}
