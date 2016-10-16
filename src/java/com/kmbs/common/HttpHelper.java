/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmbs.common;

import com.google.gson.Gson;

/**
 *
 * @author morga
 */
public class HttpHelper {
    
    public static String toJson(Object pojo){
        
         Gson gson = new Gson();
         
         String jsonStr = gson.toJson(pojo);

        return jsonStr;
    }
}
