package com.cidead.pmdm.piensapositivo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_salud extends AppCompatActivity  {

    Button bsaludVolver,btsalud;
    ImageView ivsalud1,ivsalud2,ivsalud3;
    TextView tvSalud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);
        bsaludVolver =  findViewById(R.id.bvolver_salud);
        ivsalud1 = findViewById(R.id.iv_salud_1);
        ivsalud2 = findViewById(R.id.iv_salud_2);
        ivsalud3 = findViewById(R.id.iv_salud_3);
        btsalud = findViewById(R.id.bt_salud);
        tvSalud=findViewById(R.id.tv_salud);



        bsaludVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Activity_salud.this, Home.class));
            }
        });
        btsalud.setOnClickListener(new View.OnClickListener() {
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
                mostrar_contadores();
            }
        }

        public void mostrar_contadores (){
             ivsalud1 =  findViewById(R.id.iv_salud_1);
            ivsalud2 =  findViewById(R.id.iv_salud_2);
            ivsalud3 =  findViewById(R.id.iv_salud_3);

            switch (contador1) {
                case 0: {
                    ivsalud1.setVisibility(View.INVISIBLE);
                    ivsalud2.setVisibility(View.INVISIBLE);
                    ivsalud3.setVisibility(View.INVISIBLE);
                }
                break;
                case 1: {
                    ivsalud1.setVisibility(View.VISIBLE);
                    ivsalud2.setVisibility(View.GONE);
                    ivsalud3.setVisibility(View.GONE);
                }
                    break;
                case 2:{
                    ivsalud1.setVisibility(View.INVISIBLE);
                    ivsalud2.setVisibility(View.VISIBLE);
                    ivsalud3.setVisibility(View.INVISIBLE);
                    break;
                }
                case 3:{
                    ivsalud1.setVisibility(View.INVISIBLE);
                    ivsalud2.setVisibility(View.INVISIBLE);
                    ivsalud3.setVisibility(View.VISIBLE);
                    break;
                }
                case 4:{
                    ivsalud1.setVisibility(View.GONE);
                    ivsalud2.setVisibility(View.GONE);
                    ivsalud3.setVisibility(View.GONE);
                    break;
                }
                case 5:{
                    tvSalud.setVisibility(View.VISIBLE);
                    break;
                }
                case 6: {
                    finish();
                    break;
                }
            }
        }












}