package com.poco.caso1_estebabacuilima;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.poco.caso1_estebabacuilima.Conexion.ConexionSQLiteHelper;
import com.poco.caso1_estebabacuilima.Constantes.Utilidades;
import com.poco.caso1_estebabacuilima.Modelo.musica;

import java.util.ArrayList;

public class MainActivityListar extends AppCompatActivity {

    ListView listaMusica;
    ConexionSQLiteHelper conn;
    ArrayList<String> listaInformacion;
    ArrayList<com.poco.caso1_estebabacuilima.Modelo.musica> listaMusicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listar);
        listaMusica = (ListView) findViewById(R.id.listaPersonas);
        conn = new ConexionSQLiteHelper(getApplicationContext(),"BD_musica",null,1);
        consultarListaMusicas();
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listaMusica.setAdapter(adaptador);
    }

    musica musica = null;

    private void consultarListaMusicas() {

        SQLiteDatabase db=conn.getReadableDatabase();
        listaMusicas=new ArrayList<musica>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.Tabla_musical,null);

        while (cursor.moveToNext()){

            musica = new musica();

            musica.setCodigo(cursor.getInt(0));
            musica.setNombre(cursor.getString(1));
            musica.setArtista(cursor.getString(2));
            musica.setCanciones(cursor.getString(3));
            musica.setGenero(cursor.getString(4));
            musica.setTipo(cursor.getString(5));

            listaMusicas.add(musica);
        }
        ObtenerLista();
    }


    private void ObtenerLista() {

        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaMusicas.size();i++){
            listaInformacion.add(listaMusicas.get(i).getCodigo()+" - "
                    +listaMusicas.get(i).getNombre()+ "  " + listaMusicas.get(i).getArtista());
        }
    }
}