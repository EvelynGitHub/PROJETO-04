/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author a
 */
public class Custumer {
    
    private int id;
    private String name;
    private String email;
    
    public static ArrayList<Custumer> getList() throws Exception {
       ArrayList<Custumer> list = new ArrayList<>();
       
       Class.forName("org.apache.derby.jdbc.ClientDriver");
       String url = "jdbc:derby://localhost:1527/sample";
       String user = "app";
       String password = "app";
       Connection con = DriverManager.getConnection(url, user, password);
       Statement stmt = con.createStatement();
       String sql = "SELECT CUSTOMER_ID, NAME, EMAIL FROM APP.CUSTOMER";
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
           Custumer c = new Custumer(
                 rs.getInt("CUSTOMER_ID"),
                 rs.getString("NAME"),
                 rs.getString("EMAIL")
           );
           list.add(c);
        }
       
       rs.close();
       stmt.close();
       con.close();
       return list;
    }
    
    

    public Custumer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
