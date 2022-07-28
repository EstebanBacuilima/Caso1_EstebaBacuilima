package com.poco.caso1_estebabacuilima.Constantes;

public class Utilidades {

    //Sirve para las constantes
    //Constantes campos tabla usuario
    public static final String Tabla_musical="musical";
    public static final String Campo_codigo="codigo";
    public static final String Campo_nombre="nombre";
    public static final String Campo_artista="artista";
    public static final String Campo_canciones="canciones";
    public static final String Campo_genero="genero";
    public static final String Campo_tipo="tipo";

    public static final String Crear_Tabla_musical = "create table "+Tabla_musical+"("+Campo_codigo+" integer, "+Campo_nombre+" text, "+Campo_artista+" text, "+Campo_canciones+" text, "+Campo_genero+" text,"+Campo_tipo+" text)";

}
