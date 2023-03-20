/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import DAO.DAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author S1-PC52
 */
public class Peliculas{

    private int Id_Pelicula;
    private String Nombre;
    private String Descripcion;
    private int Duracion;
    private String Clasificacion;
    private String Director;
    private String Interpretes;
    private String Trailer;
    private String Musica;
    private int Ano;
    private String Distribuidora;
    private String Comentarios;
    private int Presupuesto;
    private String Imagen;
    private int valoracion;
    private String Sinopsis;
    private int Hora;
    private String titulo;
    private String pais;
    private String genero;

     public Peliculas() {
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

     
     
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

     
     
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
     
    
    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }

    public int getId_Pelicula() {
        return Id_Pelicula;
    }

    public void setId_Pelicula(int Id_Pelicula) {
        this.Id_Pelicula = Id_Pelicula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getInterpretes() {
        return Interpretes;
    }

    public void setInterpretes(String Interpretes) {
        this.Interpretes = Interpretes;
    }

    public String getTrailer() {
        return Trailer;
    }

    public void setTrailer(String Trailer) {
        this.Trailer = Trailer;
    }

    public String getMusica() {
        return Musica;
    }

    public void setMusica(String Musica) {
        this.Musica = Musica;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public String getDistribuidora() {
        return Distribuidora;
    }

    public void setDistribuidora(String Distribuidora) {
        this.Distribuidora = Distribuidora;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String Comentarios) {
        this.Comentarios = Comentarios;
    }

    public int getPresupuesto() {
        return Presupuesto;
    }

    public void setPresupuesto(int Presupuesto) {
        this.Presupuesto = Presupuesto;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String Sinnopsis) {
        this.Sinopsis = Sinnopsis;
    }


    public static String toArrayJSon(ArrayList<Peliculas> pelicula) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(pelicula);

        return resp;
    }    
   
    
    
    public String getFilmsBySala(){
        return "";
    }
}
