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

public class Registrarse extends AppCompatActivity {
    EditText txtnombre, txtclave;
    Button btnguardar, btnmostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        txtnombre = (EditText) findViewById(R.id.txtnombre);
       txtclave = (EditText) findViewById(R.id.txtclave);


        btnguardar = (Button) findViewById(R.id.btnguardar);
        btnmostrar = (Button) findViewById(R.id.btnmostrar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(txtnombre.getText().toString(), txtclave.getText().toString());
            }
        });
        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), Listado.class));
            }
        });

    }

    /*public void atras(View view)
    {
        Button atras= (Button)findViewById(R.id.btnatras);
        Intent atrass= new Intent(Registrarse.this,MainActivity.class);
        startActivity(atrass);

    }*/


    private void guardar (String Nombre, String Clave)
    {
        BaseHelper helper= new BaseHelper(this,"Demo", null, 1);
        SQLiteDatabase db= helper.getWritableDatabase();
        try
        {
            ContentValues c = new ContentValues();
            c.put("Nombre", Nombre);
            c.put("Clave", Clave);

            db.insert("PERSONAS",null, c);
            db.close();
            Toast.makeText(this, "Registro insertado", Toast.LENGTH_SHORT).show();


        }catch (Exception e)
        {
            Toast.makeText(this, "error" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    public void mostrarlista(View view )
         {
             Button mostrarlista= (Button)findViewById(R.id.btnmostrar);
             Intent llamar= new Intent(Registrarse.this,Listado.class);
             startActivity(llamar);
         }

    public void salir (View view){
        finish();
        // System.exit(0);


    }
}
