package com.poco.caso1_estebabacuilima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.poco.caso1_estebabacuilima.Conexion.ConexionSQLiteHelper;
import com.poco.caso1_estebabacuilima.Constantes.Utilidades;

public class MainActivityConsultar extends AppCompatActivity {

    EditText nombre,artista,codigo,genero,cancion,tipo,id_Consultar;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_consultar);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"BD_musica",null,1);

        id_Consultar = (EditText) findViewById(R.id.buscarId);
        codigo = (EditText) findViewById(R.id.txt_tipoC);
        nombre = (EditText) findViewById(R.id.txt_nombreC);
        artista = (EditText) findViewById(R.id.txt_artistaC);
        cancion = (EditText) findViewById(R.id.txt_cancionC);
        genero = (EditText) findViewById(R.id.txt_generoC);
        tipo = (EditText) findViewById(R.id.txt_tipoC);

        Button buscar = (Button) findViewById(R.id.BtnBuscar);
        Button actualizar = (Button) findViewById(R.id.btnActualizarD);
        Button eliminar = (Button) findViewById(R.id.btnEliminarD);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarUsuario();
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarPersona();
            }
        });
    }


    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={id_Consultar.getText().toString()};

        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor cursor=db.rawQuery("SELECT "+Utilidades.Campo_nombre+","+Utilidades.Campo_artista+","+Utilidades.Campo_canciones+","+Utilidades.Campo_genero +","+Utilidades.Campo_tipo + " FROM "+ Utilidades.Tabla_musical+" WHERE "+Utilidades.Campo_codigo+"=? ",parametros);

            cursor.moveToFirst();

            nombre.setText(cursor.getString(0));
            artista.setText(cursor.getString(1));
            cancion.setText(cursor.getString(2));
            genero.setText(cursor.getString(3));
            tipo.setText(cursor.getString(4));

            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    private void eliminarPersona() {

        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={id_Consultar.getText().toString()};

        db.delete(Utilidades.Tabla_musical,Utilidades.Campo_codigo+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el registro",Toast.LENGTH_LONG).show();
        id_Consultar.setText("");
        limpiar();
        db.close();
    }


    private void actualizarUsuario() {

        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros={id_Consultar.getText().toString()};

        ContentValues values=new ContentValues();

        values.put(Utilidades.Campo_nombre,nombre.getText().toString());
        values.put(Utilidades.Campo_artista,artista.getText().toString());
        values.put(Utilidades.Campo_canciones,cancion.getText().toString());
        values.put(Utilidades.Campo_genero,genero.getText().toString());
        values.put(Utilidades.Campo_tipo,tipo.getText().toString());

        db.update(Utilidades.Tabla_musical,values,Utilidades.Campo_codigo+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Registro Actualizado",Toast.LENGTH_LONG).show();
        db.close();
        limpiar();

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