package com.cidead.pmdm.piensapositivo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Activity_Positivo extends AppCompatActivity  {
    Button bilusionVolver, bPensamientoPositivo;
    TextView tv_mensajepositivo;
    WebView web;
    List<String> url=new ArrayList<>();

    int posicion=0;
    @Override  //Inicializamos los botones y editText
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positivo);

        bilusionVolver= findViewById(R.id.bvolver_ilu);
        bPensamientoPositivo= findViewById(R.id.b_pensamiento_Positivo);
        tv_mensajepositivo= findViewById(R.id.VistaMensajeP);
        web=findViewById(R.id.wb_visor);
        web.setWebViewClient(new WebViewClient());
        WebSettings settings= web.getSettings();;
        settings.setJavaScriptEnabled(true);

        url.add("https://www.youtube.com/embed/OGdpckef9-E");
        url.add("https://www.youtube.com/embed/0KR8m2DqhPI");
        url.add("https://www.youtube.com/watch?v=0KR8m2DqhPI");


        bilusionVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Positivo.this, Home.class));
            }
        });

        bPensamientoPositivo.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_mensajepositivo.setVisibility(View.VISIBLE);

                tv_mensajepositivo.setVisibility(View.INVISIBLE);
                String html = "<iframe width='100%' height='100%' src=' "+url.get(posicion).replace("watch?v=", "embed/")+"' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>";
                web.setVisibility(View.VISIBLE);

                web.loadData(html , "text/html", "UTF-8");
                posicion++;
                if(posicion==url.size()){
                    web.setVisibility(View.INVISIBLE);
                    tv_mensajepositivo.setVisibility(View.VISIBLE);
                    tv_mensajepositivo.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(Activity_Positivo.this, Home.class));
                }
            }
        });
    }

}