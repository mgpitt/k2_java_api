/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmbs.controllers;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import com.kmbs.common.DataAccess;
import com.kmbs.models.ticket;

/**
 *
 * @author morga
 */
@Path("api/v1/ticket/{id}")
public class TicketById {
    @Context
    private UriInfo context;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public String getTicket( @PathParam("id") int id )
    {
       String[] args = new String[1]; 
       
       args[0] = "test";
       
       DataAccess.main(args);
       
       Gson gson = new Gson();
        
        ticket rTicket = new ticket();
        
        rTicket.setId(id);
        
        rTicket.setTitle("Test Title");
        
        rTicket.setDesc("Test Description");
        
        //String jsonStr = gson.toJson(rTicket);
        String jsonStr = gson.toJson(DataAccess.main(args));

        return jsonStr;
    }
}
