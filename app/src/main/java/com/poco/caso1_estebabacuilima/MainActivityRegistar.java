package com.poco.caso1_estebabacuilima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.poco.caso1_estebabacuilima.Conexion.ConexionSQLiteHelper;
import com.poco.caso1_estebabacuilima.Constantes.Utilidades;

public class MainActivityRegistar extends AppCompatActivity {

    EditText nombre,artista,codigo,genero,cancion,tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registar);

        codigo = (EditText) findViewById(R.id.txt_id);
        nombre = (EditText) findViewById(R.id.txt_nombre);
        artista = (EditText) findViewById(R.id.txt_artista);
        cancion = (EditText) findViewById(R.id.txt_cancion);
        genero = (EditText) findViewById(R.id.txt_genero);
        tipo = (EditText) findViewById(R.id.txt_tipo);

        Button guardar = (Button) findViewById(R.id.btnGuardarD);
        Button cancelar = (Button) findViewById(R.id.btnCancelarD);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarMusica();
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(), MainActivityCrud.class);
                startActivity(intento);
            }
        });
    }

    private void registrarMusica() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "BD_musica",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(Utilidades.Campo_codigo,codigo.getText().toString());
        values.put(Utilidades.Campo_nombre,nombre.getText().toString());
        values.put(Utilidades.Campo_artista,artista.getText().toString());
        values.put(Utilidades.Campo_canciones,cancion.getText().toString());
        values.put(Utilidades.Campo_genero,genero.getText().toString());
        values.put(Utilidades.Campo_tipo,tipo.getText().toString());

        Long idResultante = db.insert(Utilidades.Tabla_musical,Utilidades.Campo_codigo,values);
        Toast.makeText(getApplicationContext(),"Id Registro: " + idResultante ,Toast.LENGTH_SHORT).show();
        limpiar();
        db.close();
    }

    private void limpiar() {
        nombre.setText("");
        codigo.setText("");
        artista.setText("");
        genero.setText("");
        cancion.setText("");
        tipo.setText("");
    }
}