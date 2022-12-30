package com.cidead.pmdm.piensapositivo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_autoestima extends AppCompatActivity {
    Button bautoestimaVolver,btautoestima;
    ImageView ivautoestima1,ivautoestima2,ivautoestima3;
    TextView tvautoestima;
    View vista;
    AlertDialog titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoestima);
        bautoestimaVolver= findViewById(R.id.bvolver_autoestima);
        btautoestima=findViewById(R.id.bt_autoestima);
        ivautoestima1=findViewById(R.id.iv_autoestima_1);
        ivautoestima2=findViewById(R.id.iv_autoestima_2);
        ivautoestima3=findViewById(R.id.iv_autoestima_3);


        AlertDialog.Builder alerta = new AlertDialog.Builder(Activity_autoestima.this);
        titulo = alerta.create();
        LayoutInflater imagen_inflate= LayoutInflater.from(Activity_autoestima.this);
        vista = imagen_inflate.inflate(R.layout.imagen_autoestima,null);


        bautoestimaVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Activity_autoestima.this, Home.class));
            }
        });
        btautoestima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suma_contador1();

            }

        });


    }

    int contador1=0;
    public void suma_contador1(){
        if(contador1<7) {
            contador1++;
            mostrar_contadores_auto();
        }
    }

    public void mostrar_contadores_auto (){
        ivautoestima1 =  findViewById(R.id.iv_autoestima_1);
        ivautoestima2 =  findViewById(R.id.iv_autoestima_2);
        ivautoestima3 =  findViewById(R.id.iv_autoestima_3);

        switch (contador1) {
            case 0: {
                ivautoestima1.setVisibility(View.INVISIBLE);
                ivautoestima2.setVisibility(View.INVISIBLE);
                ivautoestima3.setVisibility(View.INVISIBLE);
            }
            break;
            case 1: {
                ivautoestima1.setVisibility(View.VISIBLE);
                ivautoestima2.setVisibility(View.GONE);
                ivautoestima3.setVisibility(View.GONE);
            }
            break;
            case 2:{
                ivautoestima1.setVisibility(View.VISIBLE);
                ivautoestima2.setVisibility(View.VISIBLE);
                ivautoestima3.setVisibility(View.INVISIBLE);

            }
            break;
            case 3:{
                ivautoestima1.setVisibility(View.INVISIBLE);
                ivautoestima2.setVisibility(View.INVISIBLE);
                ivautoestima3.setVisibility(View.VISIBLE);

            }
            break;
            case 4:{
                ivautoestima1.setVisibility(View.GONE);
                ivautoestima2.setVisibility(View.GONE);
                ivautoestima3.setVisibility(View.GONE);

                titulo.setView(ivautoestima1);
                titulo.show();

            }
            break;
            case 5:{
                tvautoestima.setVisibility(View.VISIBLE);

            }
            break;
            case 6: {
                finish();
            }
            break;
        }
    }


}