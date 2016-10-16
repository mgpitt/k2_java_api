/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmbs.models;

/**
 *
 * @author morga
 */
public class ticket {
    private int ID;
    
    private String Title;
    
    private String Description;
    
    public void setId(int id) 
    {
        this.ID = id;
    }
    
    public void setTitle(String title)
    {
        this.Title = title;
    }
    
    public void setDesc(String desc) 
    {
        this.Description = desc;
    }
}
