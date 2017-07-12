/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import classebo.CVCM_VendaBO;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import objetos.CVCM_Venda;

/**
 * REST Web Service
 *
 * @author D E L L
 */
@Path("venda")
public class VendaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VendaResource
     */
    public VendaResource() {
    }

    /**
     * Retrieves representation of an instance of ws.VendaResource
     * @return an instance of java.lang.String
     */
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List <CVCM_Venda> getJson() {
        //TODO return proper representation object
        
         return new CVCM_VendaBO().getVenda();
    }

    /**
     * PUT method for updating or creating an instance of VendaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        
        Gson g = new Gson();
        
        CVCM_Venda e = g.fromJson(content, CVCM_Venda.class);
        
        new CVCM_VendaBO().salvar(e);
    }
}
