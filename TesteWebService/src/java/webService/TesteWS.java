/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

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
 * @author Rafaela
 */
@Path("")
public class TesteWS {
    
    @GET
    @Path("ola")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld()
    {
        return "Olá mundo!";
    }
}
