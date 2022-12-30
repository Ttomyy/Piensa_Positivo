package com.cidead.pmdm.piensapositivo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Button bnt_registrar;
    EditText nombre, email, password;
    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        nombre=findViewById(R.id.et_RegisterName);
        email=findViewById(R.id.et_RegisterEmail);
        password=findViewById(R.id.et_RegisterPassword);
        bnt_registrar=findViewById(R.id.btn_registrer);

        mFirestore=FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();

        bnt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreUser = nombre.getText().toString().trim();
                String emailUser = email.getText().toString().trim();
                String passwordUser = password.getText().toString().trim();

                if (nombreUser.isEmpty() && emailUser.isEmpty() && passwordUser.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Inserte datos por favor", Toast.LENGTH_SHORT).show();
                }
                else{
                    insertaDatosRegistro(nombreUser,emailUser,passwordUser);
                }
            }
        });

    }

    //Metodo para guardar datos en Firebase
    private void insertaDatosRegistro(String nombreUser, String emailUser, String passwordUser) {

        mAuth.createUserWithEmailAndPassword(emailUser,passwordUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map<String,Object> map = new HashMap<>();
                map.put("id", id);
                map.put("name", nombreUser);
                map.put("email", emailUser);
                map.put("passoword", passwordUser);

                mFirestore.collection("Usuarios").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Toast.makeText(RegisterActivity.this, "Registro realizado ", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
            }
        });

    }
}