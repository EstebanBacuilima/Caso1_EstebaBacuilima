package com.poco.caso1_estebabacuilima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poco.caso1_estebabacuilima.Conexion.ConexionSQLiteHelper;

public class MainActivityCrud extends AppCompatActivity {

    Intent miIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_crud);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "BD_musica",null,1);
        Button abrirAgregar = (Button) findViewById(R.id.BtnAgregar);
        Button abrirConsultar = (Button) findViewById(R.id.BtnConsultar);
        Button abrirlista = (Button) findViewById(R.id.Btnlistar);


        abrirAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(getApplication(),MainActivityRegistar.class);
                startActivity(intencion);
            }
        });

        abrirConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(getApplication(),MainActivityConsultar.class);
                startActivity(intencion);
            }
        });

        abrirlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(getApplication(),MainActivityListar.class);
                startActivity(intencion);
            }
        });
    }
}