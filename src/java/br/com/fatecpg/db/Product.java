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
public class Product {
    
    private int id;
    private String name;
    private String desc;
    private String code;
    private double purchase_cost;    
    private int quantity;
    private double markup;
    private Custumer customer;
    private Manufacturer manufacturer;
    
    public static ArrayList<Product> getList() throws Exception {
       ArrayList<Product> list = new ArrayList<>();
       
       Class.forName("org.apache.derby.jdbc.ClientDriver");
       String url = "jdbc:derby://localhost:1527/sample";
       String user = "app";
       String password = "app";
       Connection con = DriverManager.getConnection(url, user, password);
       Statement stmt = con.createStatement();
       String sql = "select PRODUCT_ID, PRODUCT_CODE, DESCRIPTION from APP.PRODUCT";
       
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
           Product c = new Product(
                 rs.getInt("PRODUCT_ID"),
                 rs.getString("PRODUCT_CODE"),
                 rs.getString("DESCRIPTION")
           );
           list.add(c);
        }
       
       rs.close();
       stmt.close();
       con.close();
       return list;
    }
    
    public static ArrayList<Product> getListProductCustomer(int id) throws Exception {
      
       ArrayList<Product> list = new ArrayList<>();
      
       Class.forName("org.apache.derby.jdbc.ClientDriver");
       String url = "jdbc:derby://localhost:1527/sample";
       String user = "app";
       String password = "app";
       Connection con = DriverManager.getConnection(url, user, password);
       Statement stmt = con.createStatement();
       String sql = "SELECT P.CUSTOMER_ID, C.\"NAME\", PRO.PRODUCT_ID, PRO.PRODUCT_CODE, PRO.DESCRIPTION \n" +
                    "FROM PURCHASE_ORDER AS P\n" +
                    "INNER JOIN CUSTOMER AS C ON P.CUSTOMER_ID = C.CUSTOMER_ID\n" +
                    "INNER JOIN PRODUCT AS PRO ON P.PRODUCT_ID = PRO.PRODUCT_ID\n" +
                    "WHERE P.CUSTOMER_ID = "+id+"";
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
           Product c = new Product(
                rs.getInt("PRODUCT_ID"),
                rs.getString("PRODUCT_CODE"),
                rs.getString("DESCRIPTION")
           );
           
           c.setCustomer(new Custumer(rs.getInt("CUSTOMER_ID"), rs.getString("NAME"), ""));
           
           list.add(c);
        }
       
       rs.close();
       stmt.close();
       con.close();
       return list;
    }
    
    
    public static ArrayList<Product> getListProductManufacturer(int id) throws Exception {
      
       ArrayList<Product> list = new ArrayList<>();
      
       Class.forName("org.apache.derby.jdbc.ClientDriver");
       String url = "jdbc:derby://localhost:1527/sample";
       String user = "app";
       String password = "app";
       Connection con = DriverManager.getConnection(url, user, password);
       Statement stmt = con.createStatement();
       String sql = "SELECT M.MANUFACTURER_ID, M.NAME, P.PRODUCT_CODE, P.PURCHASE_COST, P.QUANTITY_ON_HAND, P.MARKUP, P.DESCRIPTION " +
                    "FROM PRODUCT AS P " +
                    "INNER JOIN MANUFACTURER AS M ON P.MANUFACTURER_ID = M.MANUFACTURER_ID " +
                    "WHERE P.MANUFACTURER_ID = "+id;
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
           Product c = new Product(
                rs.getString("PRODUCT_CODE"),
                rs.getDouble("PURCHASE_COST"),
                rs.getInt("QUANTITY_ON_HAND"),
                rs.getDouble("MARKUP"),
                rs.getString("DESCRIPTION")
           );
           
           c.setManufacturer(new Manufacturer(rs.getInt("MANUFACTURER_ID"), rs.getString("NAME"), ""));
           
           list.add(c);
        }
       
       rs.close();
       stmt.close();
       con.close();
       return list;
    }
    
    

    public Product(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    
    public Product(String code, double purchase_cost, int quantity, double markup, String desc) {
        this.code = code;
        this.purchase_cost = purchase_cost;
        this.quantity = quantity;
        this.markup = markup;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
    

    public Custumer getCustomer() {
        return customer;
    }

    public void setCustomer(Custumer customer) {
        this.customer = customer;
    }
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    

    public double getPurchase_cost() {
        return purchase_cost;
    }

    public void setPurchase_cost(double purchase_cost) {
        this.purchase_cost = purchase_cost;
    }
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }
    

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    
}
