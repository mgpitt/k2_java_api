/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmbs.controllers;

import com.kmbs.models.ticket;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;

/**
 * REST Web Service
 *
 * @author morga
 */
@Path("api/v1/ticket")
public class serviceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of serviceResource
     */
    public serviceResource() {
    }

    /**
     * Retrieves representation of an instance of com.kmbs.serviceResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHtml() {
        
        Gson gson = new Gson();
        
        ticket rTicket = new ticket();
        
        rTicket.setId(123);
        
        rTicket.setTitle("Test Title");
        
        rTicket.setDesc("Test Description");
        
        String jsonStr = gson.toJson(rTicket);

        return jsonStr;
    }

    /**
     * PUT method for updating or creating an instance of serviceResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}