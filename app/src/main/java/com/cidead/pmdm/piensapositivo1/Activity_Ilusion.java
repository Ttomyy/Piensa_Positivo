package com.cidead.pmdm.piensapositivo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Ilusion extends AppCompatActivity implements View.OnClickListener {

    Button btn_imagen,bilusionVolver;
    TextView tv_vivirIlusion;
    ImageView ivIlusionate,ivAutoestima,ivCreeCrea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilusion);
        //inicializo los objetos y sus layouts
        btn_imagen= findViewById(R.id.bt_ilusion);
        btn_imagen.setOnClickListener(this);
        bilusionVolver= findViewById(R.id.Volver_inicio_ilu);
        bilusionVolver.setOnClickListener(this);
        tv_vivirIlusion=findViewById(R.id.tv_vivir_ilusion) ;

        ivAutoestima =  findViewById(R.id.iv_autestima);
        ivIlusionate = findViewById(R.id.iv_ilusionate);
        ivCreeCrea=findViewById(R.id.iv_crees_creas);

    }
    //Defino el método onclick
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.Volver_inicio_ilu):
                startActivity(new Intent(Activity_Ilusion.this, Home.class));
            break;
            case (R.id.bt_ilusion):
                mostrar_contadoresIlu();

            break;

        }
    }
    //Creamos un método que seleccionará una acción por cada click
    public void mostrar_contadoresIlu (){

        switch (View.generateViewId()) {
            case 0: {
                ivAutoestima.setVisibility(View.INVISIBLE);
                ivIlusionate.setVisibility(View.INVISIBLE);
                ivCreeCrea.setVisibility(View.INVISIBLE);
            }
            break;
            case 1:{
                ivAutoestima.setVisibility(View.VISIBLE);
                ivIlusionate.setVisibility(View.INVISIBLE);
                ivCreeCrea.setVisibility(View.INVISIBLE);
            }
            break;
            case 2:{
                ivAutoestima.setVisibility(View.INVISIBLE);
                ivIlusionate.setVisibility(View.VISIBLE);
                ivCreeCrea.setVisibility(View.INVISIBLE);
            }
            break;
            case 3:{
                ivAutoestima.setVisibility(View.INVISIBLE);
                ivIlusionate.setVisibility(View.INVISIBLE);
                ivCreeCrea.setVisibility(View.VISIBLE);
            }
            break;
            case 4:{
                ivAutoestima.setVisibility(View.INVISIBLE);
                ivIlusionate.setVisibility(View.INVISIBLE);
                ivCreeCrea.setVisibility(View.GONE);
            }
            break;
            case 5:
                tv_vivirIlusion.setVisibility(View.VISIBLE);
            break;
            case 6:
                tv_vivirIlusion.setVisibility(View.INVISIBLE);
                finish();
                break;
        }


    }

}

