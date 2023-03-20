package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class Motor {
    private  String URL;
    private  String USER;
    private  String PASS;
    private  String DRIVER;
   
    
    /*JDBC*/
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public Motor(String URL, String USER, String PASS, String DRIVER) {
        this.URL = URL;
        this.USER = USER;
        this.PASS = PASS;
        this.DRIVER = DRIVER;
    }

    
    public void connect(){
        try 
        {
            Class.forName(DRIVER);
            System.out.println("Estoy en el connect");
        } catch( Exception e )
        {
            System.out.println("No se pudo cargar el puente JDBC.");
            return;
        }
        try{
            connection = DriverManager.getConnection(URL,USER,PASS);
            statement = connection.createStatement();
            System.out.println("Conexion exitosa");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public int execute(String SQL){
        int filasModificadas=0;
        try{
            filasModificadas = statement.executeUpdate(SQL);
         }catch(Exception e){
             System.out.println(e.getMessage()); 
         }
        return filasModificadas;
    }
    public ResultSet executeQuery(String SQL){
        try{
            System.out.println(SQL);
            resultSet = statement.executeQuery(SQL);
            System.out.println("Exito de sql");
         }catch(Exception e){
             System.out.println("Fallo de sql");
             System.out.println(e.getMessage()); 
         }
        return resultSet;
    }
    public void disconnect(){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                resultSet.close();
            }
            if(connection!=null){
                resultSet.close();
            }
            //(resultSet!=null)?resultSet.close():null;
        }catch (SQLException ex) {
                Logger.getLogger(Motor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
