/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author A10-PC102
 */
public class FactoriaConexiones {

    public static Motor getInstance(int valor) {
        switch (valor) {
            case 1:
               return new Motor("jdbc:mysql://localhost:3306/peliculas","root", "", "com.mysql.cj.jdbc.Driver");
               
            case 2:
             return new Motor("jdbc:oracle:thin:@localhost:1521:XE","ejemplo", "ejemplo", "oracle.jdbc.OracleDriver");
            default:
                return null;
        }
        
    }
}
