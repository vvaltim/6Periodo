/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author vvalt
 */
@Path("pessoa")
public class PessoaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PessoaResource
     */
    public PessoaResource() {
    }

    /**
     * Retrieves representation of an instance of ws.PessoaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //Sera imprimido uma string ao acessar a url
        return "Testando servico - ola mundo";
    }

    /**
     * PUT method for updating or creating an instance of PessoaResource
     * @param content representation for the resource
     */
    //o put e usado para capturar o que o usuario mandou
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
