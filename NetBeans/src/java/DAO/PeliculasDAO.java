/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Peliculas;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.FactoriaConexiones;
import model.Motor;

/**
 *
 * @author S1-PC52
 */
public class PeliculasDAO implements DAO<Peliculas, Integer> {
    
    private static final String SQL_SELECT_PELICULA = "SELECT DISTINCT * FROM peliculas";
    private static final String SQL_SELECT_GENERO = "SELECT DISTINCT *,genero.nombre FROM peliculas INNER JOIN genero_peliculas ON peliculas.id_Pelicula = genero_peliculas.Peliculas INNER JOIN genero ON genero_peliculas.Genero = genero.id_Genero WHERE  genero_peliculas.Genero = ";
    private static final String SQL_Peli_Votada = "SELECT * FROM `peliculas` ORDER BY valoracion DESC LIMIT 10";
    private static final String SQL_Ficha_Tecnica = "SELECT DISTINCT *,genero.nombre FROM peliculas INNER JOIN genero_peliculas ON peliculas.id_Pelicula = genero_peliculas.Peliculas INNER JOIN genero ON genero_peliculas.Genero = genero.id_Genero";
    private Motor motor = FactoriaConexiones.getInstance(1);

    @Override
    public void visualizar(Peliculas bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Peliculas> findAll(Peliculas bean) {
         String sql_filtro = "";
        String sql_final = "";
        ArrayList<Peliculas> lstPeliculas = null;
          try {
            this.motor.connect();
            /*Parametrizar la consulta para que pueda filtrar por cualquier campo*/
            /*if(bean!=null){
                /*Quieres filtrar
                if(bean.getId()>0){
                    sql_filtro+=" AND ID=" + bean.getId()+"";
                }//FALSE
                if(bean.getNombre()!= null && bean.getNombre().length()>0){
                    sql_filtro+=" AND NOMBRE='" + bean.getNombre() + "'";

                }
                 if(bean.getSinopsis()!= null && bean.getSinopsis().length()>0){
                    sql_filtro+=" AND SINOPSIS LIKE '%" + bean.getSinopsis()+ "%' ";
                }
                //SELECT * FROM `pelicula` WHERE `SINOPSIS` LIKE '%Wallace%'
            }*/
            sql_final = SQL_SELECT_PELICULA + sql_filtro;
            // SELECT * FROM PELICULA WHERE 1=! AND NOMBRE='300' AND SINOPOSIS etc!!!
            ResultSet resultset = 
                    this.motor.executeQuery(sql_final);
              System.out.println(resultset);
            // TRANSFORMADOR
            if(resultset!=null){
                    lstPeliculas = new ArrayList();
                    while(resultset.next()){// 300, Braveheart
                        Peliculas pelicula = new Peliculas();
                        pelicula.setId_Pelicula(resultset.getInt(1));
                        pelicula.setNombre(resultset.getString(2));
                        pelicula.setDuracion(resultset.getInt(3));
                        pelicula.setClasificacion(resultset.getString(4));
                        pelicula.setDirector(resultset.getString(5));
                        pelicula.setInterpretes(resultset.getString(6));
                        pelicula.setTrailer(resultset.getString(7));
                        pelicula.setMusica(resultset.getString(8));
                        pelicula.setAno(resultset.getInt((9)));
                        pelicula.setDistribuidora(resultset.getString(10));
                        pelicula.setComentarios(resultset.getString(11));
                        pelicula.setPresupuesto(resultset.getInt(12));
                        pelicula.setImagen(resultset.getString(13));
                        pelicula.setValoracion(resultset.getInt(14));
                        pelicula.setSinopsis(resultset.getString(15));
                        pelicula.setPais(resultset.getString(16));
                        lstPeliculas.add(pelicula);

                    }
            }
            this.motor.disconnect();
        } catch (Exception ex) {
                
        }
        return lstPeliculas;
    }

    @Override
    public void find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean getFilmsBySala(){
        return true;
    }
    
    public ArrayList<Peliculas> getFichaTecnica(Peliculas bean){
      String sql_filtro = "";
        String sql_final = "";
         ArrayList<Peliculas> lstPeliculas = null;
          try {
            this.motor.connect();
            /*Parametrizar la consulta para que pueda filtrar por cualquier campo*/
            /*if(bean!=null){
                /*Quieres filtrar
                if(bean.getId()>0){
                    sql_filtro+=" AND ID=" + bean.getId()+"";
                }//FALSE
                if(bean.getNombre()!= null && bean.getNombre().length()>0){
                    sql_filtro+=" AND NOMBRE='" + bean.getNombre() + "'";

                }
                 if(bean.getSinopsis()!= null && bean.getSinopsis().length()>0){
                    sql_filtro+=" AND SINOPSIS LIKE '%" + bean.getSinopsis()+ "%' ";
                }
                //SELECT * FROM `pelicula` WHERE `SINOPSIS` LIKE '%Wallace%'
            }*/
            sql_final = SQL_Ficha_Tecnica + sql_filtro;
            // SELECT * FROM PELICULA WHERE 1=! AND NOMBRE='300' AND SINOPOSIS etc!!!
            ResultSet resultset = 
                    this.motor.executeQuery(sql_final);
             
            // TRANSFORMADOR
            if(resultset!=null){
                    lstPeliculas = new ArrayList();

                    while(resultset.next()){// 300, Braveheart
                        Peliculas pelicula = new Peliculas();
                        pelicula.setId_Pelicula(resultset.getInt(1));
                        pelicula.setTitulo(resultset.getString(2));
                        pelicula.setNombre(resultset.getString(2));
                        pelicula.setDirector(resultset.getString(5));
                        pelicula.setPais(resultset.getString(16));
                        pelicula.setAno(resultset.getInt(9));
                        pelicula.setDuracion(resultset.getInt(3));
                        pelicula.setGenero(resultset.getString(21));
                        pelicula.setClasificacion(resultset.getString(4));
                        pelicula.setInterpretes(resultset.getString(6));
                        pelicula.setTrailer(resultset.getString(7));
                        pelicula.setPais(resultset.getString(16));
                        pelicula.setDistribuidora(resultset.getString(10));
                        lstPeliculas.add(pelicula);
                    }
            }
            this.motor.disconnect();
        } catch (Exception ex) {
                
        }
        return lstPeliculas;
    }
    
    public ArrayList<Peliculas> getGeneroDrama(Peliculas bean){
      String sql_filtro = "1";
        String sql_final = "";
         ArrayList<Peliculas> lstPeliculas = null;
          try {
            this.motor.connect();      
            sql_final = SQL_SELECT_GENERO + sql_filtro;
            ResultSet resultset = 
                    this.motor.executeQuery(sql_final);
             
            // TRANSFORMADOR
            if(resultset!=null){
                    lstPeliculas = new ArrayList();

                    while(resultset.next()){// 300, Braveheart
                        Peliculas pelicula = new Peliculas();
                        pelicula.setId_Pelicula(resultset.getInt(1));
                        pelicula.setImagen(resultset.getString(13));
                        pelicula.setTitulo(resultset.getString(2));
                        pelicula.setNombre(resultset.getString(2));
                        pelicula.setDirector(resultset.getString(5));
                        pelicula.setPais(resultset.getString(16));
                        pelicula.setAno(resultset.getInt(9));
                        pelicula.setDuracion(resultset.getInt(3));
                        pelicula.setGenero(resultset.getString(21));
                        pelicula.setClasificacion(resultset.getString(4));
                        pelicula.setInterpretes(resultset.getString(6));
                        pelicula.setDistribuidora(resultset.getString(10));
                        pelicula.setTrailer(resultset.getString(7));
                        lstPeliculas.add(pelicula);
                    }
            }
            this.motor.disconnect();
        } catch (Exception ex) {
                
        }
        return lstPeliculas;
    }
    
    public ArrayList<Peliculas> getGeneroComedia(Peliculas bean){
      String sql_filtro = "6";
        String sql_final = "";
         ArrayList<Peliculas> lstPeliculas = null;
          try {
            this.motor.connect();      
            sql_final = SQL_SELECT_GENERO + sql_filtro;
            ResultSet resultset = 
                    this.motor.executeQuery(sql_final);
             
            // TRANSFORMADOR
            if(resultset!=null){
                    lstPeliculas = new ArrayList();

                    while(resultset.next()){// 300, Braveheart
                        Peliculas pelicula = new Peliculas();
                        pelicula.setId_Pelicula(resultset.getInt(1));
                        pelicula.setImagen(resultset.getString(13));
                        pelicula.setTitulo(resultset.getString(2));
                        pelicula.setNombre(resultset.getString(2));
                        pelicula.setDirector(resultset.getString(5));
                        pelicula.setPais(resultset.getString(16));
                        pelicula.setAno(resultset.getInt(9));
                        pelicula.setDuracion(resultset.getInt(3));
                        pelicula.setGenero(resultset.getString(21));
                        pelicula.setClasificacion(resultset.getString(4));
                        pelicula.setInterpretes(resultset.getString(6));
                        pelicula.setDistribuidora(resultset.getString(10));
                        pelicula.setTrailer(resultset.getString(7));
                        lstPeliculas.add(pelicula);
                    }
            }
            this.motor.disconnect();
        } catch (Exception ex) {
                
        }
        return lstPeliculas;
    }
    
    
    
    public ArrayList<Peliculas> getGeneroEpica(Peliculas bean){
      String sql_filtro = "4";
        String sql_final = "";
         ArrayList<Peliculas> lstPeliculas = null;
          try {
            this.motor.connect();
            /*Parametrizar la consulta para que pueda filtrar por cualquier campo*/
            /*if(bean!=null){
                /*Quieres filtrar
                if(bean.getId()>0){
                    sql_filtro+=" AND ID=" + bean.getId()+"";
                }//FALSE
                if(bean.getNombre()!= null && bean.getNombre().length()>0){
                    sql_filtro+=" AND NOMBRE='" + bean.getNombre() + "'";

                }
                 if(bean.getSinopsis()!= null && bean.getSinopsis().length()>0){
                    sql_filtro+=" AND SINOPSIS LIKE '%" + bean.getSinopsis()+ "%' ";
                }
                //SELECT * FROM `pelicula` WHERE `SINOPSIS` LIKE '%Wallace%'
            }*/
            sql_final = SQL_SELECT_GENERO + sql_filtro;
            // SELECT * FROM PELICULA WHERE 1=! AND NOMBRE='300' AND SINOPOSIS etc!!!
            ResultSet resultset = 
                    this.motor.executeQuery(sql_final);
             
            // TRANSFORMADOR
            if(resultset!=null){
                    lstPeliculas = new ArrayList();

                    while(resultset.next()){// 300, Braveheart
                        Peliculas pelicula = new Peliculas();
                        pelicula.setId_Pelicula(resultset.getInt(1));
                        pelicula.setImagen(resultset.getString(13));
                        pelicula.setTitulo(resultset.getString(2));
                        pelicula.setNombre(resultset.getString(2));
                        pelicula.setDirector(resultset.getString(5));
                        pelicula.setPais(resultset.getString(16));
                        pelicula.setAno(resultset.getInt(9));
                        pelicula.setDuracion(resultset.getInt(3));
                        pelicula.setGenero(resultset.getString(21));
                        pelicula.setClasificacion(resultset.getString(4));
                        pelicula.setInterpretes(resultset.getString(6));
                        pelicula.setDistribuidora(resultset.getString(10));
                        pelicula.setTrailer(resultset.getString(7));
                        lstPeliculas.add(pelicula);
                    }
            }
            this.motor.disconnect();
        } catch (Exception ex) {
                
        }
        return lstPeliculas;
    }
    
    
    public ArrayList<Peliculas> getGeneroAccion(Peliculas bean){
      String sql_filtro = "7";
        String sql_final = "";
         ArrayList<Peliculas> lstPeliculas = null;
          try {
            this.motor.connect();
            /*Parametrizar la consulta para que pueda filtrar por cualquier campo*/
            /*if(bean!=null){
                /*Quieres filtrar
                if(bean.getId()>0){
                    sql_filtro+=" AND ID=" + bean.getId()+"";
                }//FALSE
                if(bean.getNombre()!= null && bean.getNombre().length()>0){
                    sql_filtro+=" AND NOMBRE='" + bean.getNombre() + "'";

                }
                 if(bean.getSinopsis()!= null && bean.getSinopsis().length()>0){
                    sql_filtro+=" AND SINOPSIS LIKE '%" + bean.getSinopsis()+ "%' ";
                }
                //SELECT * FROM `pelicula` WHERE `SINOPSIS` LIKE '%Wallace%'
            }*/
            sql_final = SQL_SELECT_GENERO + sql_filtro;
            // SELECT * FROM PELICULA WHERE 1=! AND NOMBRE='300' AND SINOPOSIS etc!!!
            ResultSet resultset = 
                    this.motor.executeQuery(sql_final);
             
            // TRANSFORMADOR
            if(resultset!=null){
                    lstPeliculas = new ArrayList();

                    while(resultset.next()){// 300, Braveheart
                        Peliculas pelicula = new Peliculas();
                        pelicula.setId_Pelicula(resultset.getInt(1));
                        pelicula.setImagen(resultset.getString(13));
                        pelicula.setTitulo(resultset.getString(2));
                        pelicula.setNombre(resultset.getString(2));
                        pelicula.setDirector(resultset.getString(5));
                        pelicula.setPais(resultset.getString(16));
                        pelicula.setAno(resultset.getInt(9));
                        pelicula.setDuracion(resultset.getInt(3));
                        pelicula.setGenero(resultset.getString(21));
                        pelicula.setClasificacion(resultset.getString(4));
                        pelicula.setInterpretes(resultset.getString(6));
                        pelicula.setDistribuidora(resultset.getString(10));
                        pelicula.setTrailer(resultset.getString(7));
                        lstPeliculas.add(pelicula);
                    }
            }
            this.motor.disconnect();
        } catch (Exception ex) {
                
        }
        return lstPeliculas;
    }
    public ArrayList<Peliculas> pelisMasvotadas(Peliculas bean) {
         String sql_filtro = "";
        String sql_final = "";
        ArrayList<Peliculas> lstPeliculas = null;
          try {
            this.motor.connect();
            /*Parametrizar la consulta para que pueda filtrar por cualquier campo*/
            /*if(bean!=null){
                /*Quieres filtrar
                if(bean.getId()>0){
                    sql_filtro+=" AND ID=" + bean.getId()+"";
                }//FALSE
                if(bean.getNombre()!= null && bean.getNombre().length()>0){
                    sql_filtro+=" AND NOMBRE='" + bean.getNombre() + "'";

                }
                 if(bean.getSinopsis()!= null && bean.getSinopsis().length()>0){
                    sql_filtro+=" AND SINOPSIS LIKE '%" + bean.getSinopsis()+ "%' ";
                }
                //SELECT * FROM `pelicula` WHERE `SINOPSIS` LIKE '%Wallace%'
            }*/
            sql_final = SQL_Peli_Votada + sql_filtro;
            // SELECT * FROM PELICULA WHERE 1=! AND NOMBRE='300' AND SINOPOSIS etc!!!
            ResultSet resultset = 
                    this.motor.executeQuery(sql_final);
              System.out.println(resultset);
            // TRANSFORMADOR
            if(resultset!=null){
                    lstPeliculas = new ArrayList();
                    while(resultset.next()){// 300, Braveheart
                        Peliculas pelicula = new Peliculas();
                        pelicula.setId_Pelicula(resultset.getInt(1));
                        pelicula.setNombre(resultset.getString(2));
                        pelicula.setDuracion(resultset.getInt(3));
                        pelicula.setClasificacion(resultset.getString(4));
                        pelicula.setDirector(resultset.getString(5));
                        pelicula.setInterpretes(resultset.getString(6));
                        pelicula.setTrailer(resultset.getString(7));
                        pelicula.setMusica(resultset.getString(8));
                        pelicula.setAno(resultset.getInt((9)));
                        pelicula.setDistribuidora(resultset.getString(10));
                        pelicula.setComentarios(resultset.getString(11));
                        pelicula.setPresupuesto(resultset.getInt(12));
                        pelicula.setImagen(resultset.getString(13));
                        pelicula.setValoracion(resultset.getInt(14));
                        pelicula.setSinopsis(resultset.getString(15));
                        pelicula.setPais(resultset.getString(16));
                        lstPeliculas.add(pelicula);

                    }
            }
            this.motor.disconnect();
        } catch (Exception ex) {
                
        }
        return lstPeliculas;
    }
}
