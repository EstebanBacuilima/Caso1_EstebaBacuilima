package com.poco.caso1_estebabacuilima.Modelo;

public class musica {

    private Integer codigo;
    private String nombre;
    private String artista;
    private String canciones;
    private String genero;
    private String tipo;

    public musica() {
    }

    public musica(Integer codigo, String nombre, String artista, String canciones, String genero, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = canciones;
        this.genero = genero;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCanciones() {
        return canciones;
    }

    public void setCanciones(String canciones) {
        this.canciones = canciones;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
