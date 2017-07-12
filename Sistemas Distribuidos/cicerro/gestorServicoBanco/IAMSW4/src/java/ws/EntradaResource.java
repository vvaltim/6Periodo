/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import classesbo.IAM_EntradaBO;
import classesdao.IAM_EntradaDAO;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import objetos.IAM_Entrada;


/**
 * REST Web Service
 *
 * @author jonh
 */
@Path("entrada")
public class EntradaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GeladeiraResource
     */
    public EntradaResource() {
    }

    /**
     * Retrieves representation of an instance of ws.EntradaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<IAM_Entrada> getJson() {
    
     
        
      return new IAM_EntradaBO().getEntrada();
    
    }
    
   
   
    /**
     * PUT method for updating or creating an instance of EntradaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        Gson g = new Gson();
        
        IAM_Entrada e = g.fromJson(content, IAM_Entrada.class);
        
        new IAM_EntradaBO().salvar(e);
        
    }

   
    
}
