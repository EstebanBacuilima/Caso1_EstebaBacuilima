package com.poco.caso1_estebabacuilima.Conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.poco.caso1_estebabacuilima.Constantes.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.Crear_Tabla_musical);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS musical");
        onCreate(db);
    }

    public void agregarMusica (){

    }
}
