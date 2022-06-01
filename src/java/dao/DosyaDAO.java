/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Dosya;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.ResultSet;

/**
 *
 * @author Ufuk
 */
public class DosyaDAO extends DBConnection {

    public Dosya findByID(int id) {
        Dosya d = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from dosya where id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                d = new Dosya(rs.getInt("id"), rs.getString("name"), rs.getString("path"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return d;
    }

    public List<Dosya> findAll() {
        List<Dosya> dList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from dosya";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Dosya d = new Dosya();
                d.setId(rs.getInt("id"));
                d.setFileName(rs.getString("name"));
                d.setFilePath(rs.getString("path"));

                dList.add(d);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dList;
    }

    public void create(Dosya c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into dosya (name,path) values ('" + c.getFileName() + "','" + c.getFilePath() + "')RETURNING id";
            System.out.println("Dosya query " + query);
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int id = rs.getInt(1);
            c.setId(id);

            st.executeQuery(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
