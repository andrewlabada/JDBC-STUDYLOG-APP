/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ANREW25
 */
public class LogInformation {
    Connection connection;
    
    
    
    //ADD FUNCTION
    public void addInformation(Logs log){
       connection = DatabaseHelper.ConnecrDB();
       PreparedStatement ps;
       try{
           ps = connection.prepareStatement("INSERT INTO studylog(date,title,description) VALUES(?,?,?)");
           ps.setString(1,log.getDate());
           ps.setString(2, log.getTitle());
           ps.setString(3, log.getDescription());
           ps.executeUpdate();
           
           
       }catch(SQLException e){
           System.out.print(e);
       }
    }
    
    //UPDATE FUNCTION
    public void updateInformation(Logs log){
       connection = DatabaseHelper.ConnecrDB();
       PreparedStatement ps;
       String updateQuery=null;
       
       try{
           
          
           updateQuery = "UPDATE studylog SET date=?,title=?, description=?  WHERE id="+log.getID();
           ps = connection.prepareStatement(updateQuery);
           
           ps.setString(1, log.getDate());
           ps.setString(2,log.getTitle());
           ps.setString(3,log.getDescription());
           
           ps.executeUpdate();
           
           
       }catch(SQLException e){
           System.out.print(e);
       }
       
    }
    public void deleteInformation(Logs log){
       connection = DatabaseHelper.ConnecrDB();
       PreparedStatement ps;
       String deleteQuery=null;
       
       try{
           deleteQuery="DELETE FROM studylog WHERE id="+log.getID();
           ps=connection.prepareStatement(deleteQuery);
           ps.executeUpdate();
           
           
       }catch(SQLException e){
           System.out.print(e);
       }
    
    }
    
    //list of array for display
    public ArrayList<Logs> displayInformation(){
       ArrayList<Logs> get = new ArrayList<>();
       
       connection = DatabaseHelper.ConnecrDB();
       String query = "SELECT * FROM studylog";
       Statement st;
       ResultSet rs;
       
       try{
       st = connection.createStatement();
       rs = st.executeQuery(query);
       Logs log;
       while(rs.next()){
            log = new Logs(rs.getInt("id"),rs.getString("Date"),rs.getString("Title"),rs.getString("Description"));
            get.add(log);
        }
       }catch(SQLException e){
           System.out.print(e);
       }
       return get;
    }
    
    
    
}
