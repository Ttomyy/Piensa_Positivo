package com.cidead.pmdm.piensapositivo1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_entrena extends AppCompatActivity {

    Button bentrenaVolver, bplay, bpause, bstop,b_entrena;
    VideoView video;
    ImageView ivEntrena_1, ivEntrena2;
    LinearLayout lyt;
    int contador1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrena);

        bentrenaVolver= findViewById(R.id.bvolver_autoestima);
        bplay=findViewById(R.id.b_play);
        bpause=findViewById(R.id.b_pause);
        bstop=findViewById(R.id.b_stop);
        b_entrena=findViewById(R.id.bt_entrenar);
        b_entrena.setVisibility(View.INVISIBLE);
        ivEntrena_1=findViewById(R.id.iv_entrena1);
        ivEntrena2 =findViewById(R.id.iv_entrena2);
        lyt=findViewById(R.id.linear_videos);
        lyt.setVisibility(View.VISIBLE);


        video=findViewById(R.id.vv_calienta);
        String path = ("android.resource://"+getPackageName()+"/"+R.raw.v_calienta_runner);
        video.setVideoURI(Uri.parse(path));
        video.setMediaController(new MediaController(this));



        bentrenaVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_entrena.this, Home.class));
            }
        });
        bplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video.setVisibility(View.VISIBLE);
                video.start();
            }
        });
        bpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                video.setVisibility(View.VISIBLE);
                video.pause();
            }
        });
        bstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video.stopPlayback();
                video.setVisibility(View.INVISIBLE);
                b_entrena.setVisibility(View.VISIBLE);

            }
        });

        b_entrena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador_entrena();

            }
        });
    }

    private void contador_entrena() {
        if(contador1<7) {
            contador1++;
            mostrar_imagenes_entrena();
    }

}

    private void mostrar_imagenes_entrena() {
        switch (contador1) {
            case 0:

                lyt.setVisibility(View.INVISIBLE);
                ivEntrena_1.setVisibility(View.INVISIBLE);
                ivEntrena2.setVisibility(View.INVISIBLE);
                break;
            case 1:

                lyt.setVisibility(View.INVISIBLE);
                ivEntrena_1.setVisibility(View.VISIBLE);
                ivEntrena2.setVisibility(View.INVISIBLE);
                break;
            case 2:
                lyt.setVisibility(View.INVISIBLE);
                ivEntrena_1.setVisibility(View.INVISIBLE);
                ivEntrena2.setVisibility(View.VISIBLE);
                break;
            case 3:

                lyt.setVisibility(View.INVISIBLE);
                ivEntrena_1.setVisibility(View.INVISIBLE);
                ivEntrena2.setVisibility(View.GONE);
                break;
            case 4:

                finish();
                break;

        }
    }
}