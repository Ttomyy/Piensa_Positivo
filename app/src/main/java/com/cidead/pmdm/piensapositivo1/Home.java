package com.cidead.pmdm.piensapositivo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.cidead.pmdm.piensapositivo1.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth auth;


    Button bilusion, bpositivo,bentrena,bsalud,bautoestima, bFormulario,btn_fragment;
    ActionBar ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //ab.setTitle("Piensa +");


        bpositivo =(Button) findViewById(R.id.b_positivo);
        bpositivo.setOnClickListener(this);
        bilusion =(Button) findViewById(R.id.bt_ilusion);
        bilusion.setOnClickListener(this);
        bentrena=(Button) findViewById(R.id.b_entrena);
        bentrena.setOnClickListener(this);
        bsalud=(Button) findViewById(R.id.b_salud);
        bsalud.setOnClickListener(this);
        bautoestima=(Button) findViewById(R.id.b_autoestima);
        bautoestima.setOnClickListener(this);
        btn_fragment=findViewById(R.id.b_formulario);
        btn_fragment.setOnClickListener(this);

        auth=FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b_positivo:
                Intent intent=(new Intent(Home.this, Activity_Positivo.class));
                startActivity(intent);
                break;
            case R.id.bt_ilusion:
                startActivity(new Intent(Home.this, Activity_Ilusion.class));
                break;
            case R.id.b_entrena:
                startActivity(new Intent(Home.this, Activity_entrena.class));
                break;
            case R.id.b_salud:
                startActivity(new Intent(Home.this, Activity_salud.class));
                break;
            case R.id.b_autoestima:
                startActivity(new Intent(Home.this, Activity_autoestima.class));
                break;

            case R.id.b_formulario:
                btn_fragment.setOnClickListener(this);
                FragmentSubscirpcion fm=new FragmentSubscirpcion();
                fm.show(getSupportFragmentManager(),"Navegar a fragmento");

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_navegar,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
                finish();
                startActivity(new Intent(Home.this, LoginActivity.class));
            }
            break;
            case R.id.m_atras: {

                startActivity(new Intent(Home.this, MainActivity.class));

            }break;


        }
        return super.onOptionsItemSelected(item);
    }


}