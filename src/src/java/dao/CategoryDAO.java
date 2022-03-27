/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import util.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ufuk
 */
public class CategoryDAO extends DBConnection {

    private Connection db;

    public void createCategory(Category c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "insert into category (title,created,fiyat,aciklama) values ('" + c.getTitle() + "','" + c.getCreated() + 
                    "','" + c.getFiyat() + "','" + c.getAciklama()+ "')";
            int r = st.executeUpdate(query);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Category c) {
        try {
            Statement st = this.getDb().createStatement();

            String query = "delete from category where id="+c.getId();
            int r = st.executeUpdate(query);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Category> getCaregoryList() {
        List<Category> categoryList = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();

            String query = "select * from category";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                categoryList.add(new Category(rs.getLong("id"), rs.getString("title"),rs.getInt("fiyat"),rs.getString("aciklama"), rs.getTimestamp("created"), rs.getTimestamp("updated")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categoryList;
    }

    public Connection getDb() {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

}
