/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmbs.controllers;
import com.kmbs.common.HttpHelper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import com.kmbs.models.ResponseMessage;
import javax.ws.rs.Path;
/**
 *
 * @author morga
 */
@Path("api")
public class ApiController {
    @Context
    private UriInfo context;
    public ApiController () {
        
    }
    
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public String GetResponse () {
         ResponseMessage m = new ResponseMessage();
         m.setMessage("Welcome to API V1");
         return HttpHelper.toJson(m);
     }
}


