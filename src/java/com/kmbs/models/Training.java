/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmbs.models;

/**
 *
 * @author MPitt
 */
public class Training {
    private String Comments;
    private String NeedsTraining;
    private String DateStamp;
    
    public void setComment(String comment){
        this.Comments = comment;
    }
    
    public void setTrain(String train) {
        this.NeedsTraining = train;
    }
    
    public void setDate(String date) {
        this.DateStamp = date;
    }
}
