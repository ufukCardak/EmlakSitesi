/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Adres;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Ufuk
 */
public class AdresDAO extends DBConnection {

    public Adres findByID(int id) {
        Adres a = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from adres where adres_id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                a = new Adres(rs.getInt("adres_id"), rs.getString("il"), rs.getString("ilce"),
                        rs.getString("mahalle"), rs.getString("sokak"), rs.getInt("no"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public void create(Adres c) {
        String query = null;
        try {
            Statement st = this.getConnection().createStatement();
            query = "insert into adres (il,ilce,mahalle,sokak,no) values ('" + c.getIl() + "','" + c.getIlce() + "','" + c.getMahalle() + "','" + c.getSokak() + "','" + c.getNo() + "')RETURNING adres_id";
            
            System.out.println("Adres query " + query);

            ResultSet rs = st.executeQuery(query);
            rs.next();
            int id = rs.getInt(1);
            //System.out.println("Adres id " + id);
            c.setId(id);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Adres c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from adres where adres_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Adres c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update adres set "
                    + "il='" + c.getIl() + "',ilce='" + c.getIlce() + "',"
                    + "mahalle='" + c.getMahalle() + "', sokak='" + c.getSokak() + "', no='" + c.getNo() + "' where adres_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public List<Adres> getAdresList() {
        List<Adres> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from adres";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Adres(rs.getInt("adres_id"), rs.getString("il"),
                        rs.getString("ilce"), rs.getString("mahalle"),
                        rs.getString("sokak"), rs.getInt("no")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}
