/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;

import java.util.Date;

/**
 *
 * @author ANREW25
 */
public class Logs {
    private int id;
    private String title,description;
    private String date;
  
    //default constructor
    public Logs(){}
    
    //with parameters constructor
    public Logs(int id,String date,String title,String description){
        this.id=id;
        this.date=date;
        this.title=title;
        this.description=description;
    }
    
    //setters
    public void setID(int id){
        this.id=id;
    }
    public void setDate(String date){
        this.date=date;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setDescription(String description){
        this.description=description;
    }
    
    //getters
    public int getID(){
        return id;
    }
    public String getDate(){
        return date;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    
    
}//end of logs class.
