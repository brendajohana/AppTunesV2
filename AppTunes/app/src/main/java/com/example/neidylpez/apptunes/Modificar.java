package com.example.neidylpez.apptunes;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modificar extends AppCompatActivity {
    EditText txtnombre, txtclave;
    Button btnmodificar, BtnBorrar;
    int id;
    String nombre;
    String clave;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        Bundle b= getIntent().getExtras();
        if (b!=null){
            id=b.getInt("Id");
            nombre=b.getString("Nombre");
            clave=b.getString("Clave");

        }


        txtnombre=(EditText)findViewById(R.id.txtnombre);
        txtclave=(EditText)findViewById(R.id.txtclave);


        txtnombre.setText(nombre);
        txtclave.setText(clave);


        btnmodificar=(Button) findViewById(R.id.btnguardar);
        BtnBorrar=(Button) findViewById(R.id.BtnBorrar);

                BtnBorrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Eliminar(id);
                onBackPressed();

            }
        });



        btnmodificar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //CUEK!!!
                Modificar(id,txtnombre.getText().toString(),txtclave.getText().toString());
                onBackPressed();

            }
        });


    }
    private void Modificar (int Id, String Nombre, String Clave){
        BaseHelper helper= new BaseHelper(this,"Demo", null, 1);
        SQLiteDatabase db= helper.getWritableDatabase();

        String sql="update Personas set Nombres'"+ Nombre + "', Clave'"+ Clave+"'Correo'" + "' where Id ="+Id;
        db.execSQL(sql);
        db.close();
    }
    private void Eliminar (int Id){
        BaseHelper helper= new BaseHelper(this,"Demo", null, 1);
        SQLiteDatabase db= helper.getWritableDatabase();

        String sql="delete Personas from where Id ="+Id;
        db.execSQL(sql);
        db.close();
    }
}
