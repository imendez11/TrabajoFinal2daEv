/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;



import Clases.Index;
import Clases.Peliculas;
import DAO.PeliculasDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author S1-PC52
 */
@Path("api")
public class ApiPeliculas {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiPeliculas
     */
    public ApiPeliculas() {
    }

    /**
     * Retrieves representation of an instance of api.ApiPeliculas
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        
        
        
        
                 PeliculasDAO peliculaDAO = new PeliculasDAO();
                        ArrayList<Peliculas> lstPeliculas = 
                                peliculaDAO.findAll(null);
                        
                        // Transformar de ArrayList a JSON
                     
                       
                       PeliculasDAO peliculaDrama = new PeliculasDAO();
                        ArrayList<Peliculas> lstPeliculasDrama = 
                                peliculaDrama.getGeneroDrama(null);
                        
                        PeliculasDAO peliculaEpica = new PeliculasDAO();
                        ArrayList<Peliculas> lstPeliculasEpica = 
                                peliculaEpica.getGeneroEpica(null);
                        
                        // Transformar de ArrayList a JSON
                       
                       PeliculasDAO peliculaAccion = new PeliculasDAO();
                        ArrayList<Peliculas> lstPeliculasAccion = 
                                peliculaAccion.getGeneroAccion(null);
                        
                        
                       PeliculasDAO peliculaComedia = new PeliculasDAO();
                        ArrayList<Peliculas> lstPeliculasComedia = 
                                peliculaComedia.getGeneroComedia(null);
                        
                         PeliculasDAO peliculaMasvotadas = new PeliculasDAO();
                        ArrayList<Peliculas> lstPeliculasMasvotadas = 
                                peliculaMasvotadas.pelisMasvotadas(null);
                        
                        PeliculasDAO peliculaFichatecnica = new PeliculasDAO();
                        ArrayList<Peliculas> lstPeliculasFicha = 
                                peliculaFichatecnica.getFichaTecnica(null);
                        
                        
                       
              Index index = new Index();
              index.setPeliculas(lstPeliculas);
              index.setPeliculasDrama(lstPeliculasDrama);
              index.setPeliculasEpica(lstPeliculasEpica);
              index.setPeliculasAcion(lstPeliculasAccion);
              index.setPeliculasComedia(lstPeliculasComedia);
              index.setPeliculasMasvotadas(lstPeliculasMasvotadas);
              index.setFichatecnica(lstPeliculasFicha);
              
              ArrayList<Index> lstIndex = new ArrayList<Index>();
              lstIndex.add(index);
                       
                       
              return Index.toArrayJSon(lstIndex);
        
                      
    }

    /**
     * PUT method for updating or creating an instance of ApiPeliculas
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
