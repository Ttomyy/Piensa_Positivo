package com.cidead.pmdm.piensapositivo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.cidead.pmdm.piensapositivo1.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    FirebaseAuth auth;
    Button btn_entrar;
    //ActionBar ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializamos el boton para que entre en el menu home
        btn_entrar = findViewById(R.id.entrar);
        btn_entrar.setOnClickListener(this);
        //ab.setTitle("Piensa +");

    }
    //Este metodo lo que hace es generar el cambio de actividad cuando se pulsa el click.
    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, Home.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_navegar,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // We are using switch case because multiple icons can be kept
        switch (item.getItemId()) {
            case R.id.m_compartir:{

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Te gusta lo que ves?";
                String shareSubject = "No dudes en compartir tu experiencia con otros usuarios";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share "));
            }break;
            case R.id.m_logout:{
                auth.signOut();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                //finish();
            }
            break;
            case R.id.m_atras: {
                onBackPressed();
            }
            break;


        }
        return super.onOptionsItemSelected(item);
    }
}

