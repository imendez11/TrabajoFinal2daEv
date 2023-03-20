/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Cines;
import Clases.Peliculas;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Motor;

/**
 *
 * @author S1-PC52
 */
public class CinesDAO implements DAO<Cines, Integer > {
    
    private static final String SQL_SELECT = "SELECT * FROM CONDUCIR";
    private static final String SQL_UPDATE = "UPDATE CONDUCIR SET ";
    private static final String SQL_DELETE = "DELETE FROM CONDUCIR WHERE ";
    private static final String SQL_INSERT = "INSERT INTO CONDUCIR VALUES ";
    private Motor motor = null;

    @Override
    public void visualizar(Cines bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cines> findAll(Cines bean) {
         String sql_filtro = "";
        String sql_final = "";
        ArrayList<Cines> lstCines = null;
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
            sql_final = SQL_SELECT + sql_filtro;
            // SELECT * FROM PELICULA WHERE 1=! AND NOMBRE='300' AND SINOPOSIS etc!!!
            ResultSet resultset = 
                    this.motor.executeQuery(sql_final);
             
            // TRANSFORMADOR
            if(resultset!=null){
                    lstCines = new ArrayList();

                    while(resultset.next()){// 300, Braveheart
                        Cines cine = new Cines();
                        cine.setImagen(resultset.getString(1));
                        cine.setId_cine(resultset.getInt(2));
                        cine.setNombre(resultset.getString(3));
                        cine.setDireccion(resultset.getString(4));
                        cine.setHoras(resultset.getInt(5));
                        cine.setDias(resultset.getString(6));
                        lstCines.add(cine);
                    }
            }
            this.motor.disconnect();
        } catch (Exception ex) {
                
        }
        return lstCines;
    }

    @Override
    public void find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
