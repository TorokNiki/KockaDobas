package com.example.kockadobas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random rand;
    private TextView pontszam;
    private ImageView kockaJatekos,kockaGep;
    private Button dobas;
    private AlertDialog alertDialog;
    private AlertDialog.Builder alertDialogBuilder;
    private int jatekosSzam,gepSzam,jatekosPontszam,gepPontszam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        dobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekosSzam= rand.nextInt(6)+1;
                gepSzam= rand.nextInt(6)+1;
                kepvaltas(jatekosSzam,kockaJatekos);
                kepvaltas(gepSzam,kockaGep);
                pontszamKiosztas();
                nyertes();
            }
        });
    }
    private void nyertes(){
        if (jatekosPontszam==3){
            alertDialogBuilder.setTitle("Nyertél!!!");
            alertDialogBuilder.setMessage("Újra akarod kezdeni a játékot?");
            alertDialogBuilder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    reStart();
                }
            });
            alertDialogBuilder.setNegativeButton("nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setCancelable(false);
            alertDialog=alertDialogBuilder.create();
            alertDialog.show();
        }else if (gepPontszam==3){
            alertDialogBuilder.setTitle("A gép nyert!!!");
            alertDialogBuilder.setMessage("Újra akarod kezdeni a játékot?");
            alertDialogBuilder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    reStart();
                }
            });
            alertDialogBuilder.setNegativeButton("nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setCancelable(false);
            alertDialog=alertDialogBuilder.create();
            alertDialog.show();
        }

    }
    private void pontszamKiosztas(){
        if (jatekosSzam>gepSzam){
            jatekosPontszam++;
            pontszam.setText("Eredmeny: Játékos "+jatekosPontszam+" - Gép "+gepPontszam);
        }else if (gepSzam>jatekosSzam){
            gepPontszam++;
            pontszam.setText("Eredmeny: Játékos "+jatekosPontszam+" - Gép "+gepPontszam);
        }
    }
    private void reStart(){
        jatekosSzam=0;
        jatekosPontszam=0;
        gepSzam=0;
        gepPontszam=0;
        pontszam.setText("Eredmeny: Játékos "+jatekosPontszam+" - Gép "+gepPontszam);
        kockaJatekos.setImageResource(R.drawable.kocka1);
        kockaGep.setImageResource(R.drawable.kocka1);

    }
    private  void kepvaltas(int szam, ImageView kepHely){
        switch (szam){
            case 1: kepHely.setImageResource(R.drawable.kocka1); break;
            case 2: kepHely.setImageResource(R.drawable.kocka2); break;
            case 3: kepHely.setImageResource(R.drawable.kocka3); break;
            case 4: kepHely.setImageResource(R.drawable.kocka4); break;
            case 5: kepHely.setImageResource(R.drawable.kocka5); break;
            case 6: kepHely.setImageResource(R.drawable.kocka6); break;
        }
    }
    private void init(){
        pontszam= findViewById(R.id.textEredmeny);
        kockaJatekos= findViewById(R.id.kockaJatekos);
        kockaGep= findViewById(R.id.kockaGep);
        rand= new Random();
        dobas= findViewById(R.id.dobas);
        jatekosSzam=0;
        jatekosPontszam=0;
        gepSzam=0;
        gepPontszam=0;
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

    }
}
