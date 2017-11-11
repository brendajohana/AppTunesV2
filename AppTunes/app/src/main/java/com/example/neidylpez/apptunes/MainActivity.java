package com.example.neidylpez.apptunes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void llamarregistro (View view)
    {
        Button registro= (Button)findViewById(R.id.btnRegistrar);
        Intent registr= new Intent(MainActivity.this,Registrarse.class);
        startActivity(registr);

    }
    public void salir (View view){
        finish();
       // System.exit(0);


    }





    }

