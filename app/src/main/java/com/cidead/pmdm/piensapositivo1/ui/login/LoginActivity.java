package com.cidead.pmdm.piensapositivo1.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cidead.pmdm.piensapositivo1.MainActivity;
import com.cidead.pmdm.piensapositivo1.R;
import com.cidead.pmdm.piensapositivo1.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_aRegistrar, btn_login;
    EditText et_usrEmail, et_password;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth mautotentic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_usrEmail =findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        btn_login=findViewById(R.id.btn_login);
        btn_aRegistrar=findViewById(R.id.btn_cambioARegistro);
        btn_login.setOnClickListener(this);

        btn_aRegistrar.setOnClickListener(this);

        mautotentic = FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cambioARegistro:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.btn_login:

                String emailUser= et_usrEmail.getText().toString().trim();
                String password= et_password.getText().toString().trim();
                if (emailUser.isEmpty() && password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Ingrese datos", Toast.LENGTH_SHORT).show();
                }
                else{
                    loginUser(emailUser,password);

                }
                break;

        }

    }

    private void loginUser(String emailUser, String password) {
        mautotentic.signInWithEmailAndPassword(emailUser,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
            }
        });
    }


}