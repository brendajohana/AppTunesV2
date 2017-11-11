package com.example.neidylpez.apptunes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {
    ListView listview;
    ArrayList<String> listado;

    @Override
    protected void onPostResume(){
        super.onPostResume();
        cargarListado();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listview = (ListView) findViewById(R.id.listview);
        cargarListado();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Listado.this,listado.get(position),Toast.LENGTH_SHORT).show();
                int idU= Integer.parseInt(listado.get(position).split(" ")[0]);
                String nombre=listado.get(position).split(" ")[1];
                String clave=listado.get(position).split(" ")[2];

                Intent intent= new Intent(Listado.this,Modificar.class);
                intent.putExtra("Id", idU);
                intent.putExtra("Nombre", nombre);
                intent.putExtra("Clave", clave);

                startActivity(intent);
            }

        });



        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home){
            finish();

        }
        return  super.onOptionsItemSelected(item);
    }



    private void cargarListado(){
        listado= ListaPersonas();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listado);
        listview.setAdapter(adapter);
    }

    private ArrayList<String> ListaPersonas() {
        ArrayList<String> datos = new ArrayList<String>();
        BaseHelper helper = new BaseHelper(this, "Demo", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select Id.Nombre, Clave from Personas";
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()){
            do {
                String linea=c.getInt(0)+""+ c.getString(1)+""+ c.getString(2)+"";
                datos.add(linea);


            }while (c.moveToNext());

        }

        db.close();
        return datos;

    }

}
