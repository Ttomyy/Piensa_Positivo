package com.cidead.pmdm.piensapositivo1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class FragmentSubscirpcion extends DialogFragment{

    EditText edtMail;
    Button btnEnviaEmail,btnVolverInicio;
    FirebaseFirestore firebaseFirestore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_subscirpcion, container, false);
        firebaseFirestore=FirebaseFirestore.getInstance();
        btnVolverInicio= v.findViewById(R.id.b_VolverDe_Formulario);
        btnEnviaEmail= v.findViewById(R.id.btn_EnviarSubscripcion);
        edtMail= v.findViewById(R.id.edt_Mail);

        btnEnviaEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correoElectronico=edtMail.getText().toString().trim();
                //Comprobamos que si selecciona un email, tenga un correo electrónico como dato
                if (TextUtils.isEmpty(correoElectronico) || !correoElectronico.contains(("@")) || !correoElectronico.contains(("."))){
                    Toast.makeText(getContext(), "Inserte un email", Toast.LENGTH_SHORT).show();
                }
                else {
                    insertaCorreoFirestore(correoElectronico);
                }
            }
        });


       return v;
    }
    private void insertaCorreoFirestore(String correoElectronico) {
        //Creo un objeto map para poder definir el nombre del campo en mi base de datos
        Map<String,Object> map=new HashMap<>();
        map.put("email",correoElectronico);
        //Aniado el objetoa la bbdd
        firebaseFirestore.collection("email").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getContext(), "Email insertado", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Error ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}