package com.example.neidylpez.apptunes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Descargas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descargas);
    }
    public void llamarlector (View view)
    {
        Intent lecto= new Intent( Descargas.this,Lector.class);
        startActivity(lecto);

    }
}
