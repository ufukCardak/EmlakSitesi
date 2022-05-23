/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanici;
import entity.Ortak;
import entity.Villa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Ufuk
 */
public class VillaDAO extends DBConnection{
    private OrtakDAO ortakDao;
    private KullaniciDAO kullaniciDao;

    public void create(Villa c, int ortak_id, String kullanici_ad) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into villa (ortak_id,kullanici_adi,kat_sayisi,oda_sayisi,havuz) "
                    + "values "
                    + "('" + ortak_id + "','" + kullanici_ad + "','" + c.getKat_sayisi() + "','"
                    + c.getOda_sayisi()+ "','" + c.getHavuz()+ "')";
            //System.out.println("Villa query " + query);
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Villa c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from villa where villa_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Villa c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update villa set kat_sayisi='"+c.getKat_sayisi()+"',oda_sayisi='"+c.getOda_sayisi()+"',havuz='"+c.getHavuz()+"'  where villa_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Villa> getVillaList() {
        List<Villa> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from villa";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Ortak o = this.getOrtakDao().findByID(rs.getInt("ortak_id"));
                Kullanici k = this.getKullaniciDao().findByString(rs.getString("kullanici_adi"));
                
                list.add(new Villa(rs.getInt("villa_id"), o,k,rs.getInt("kat_sayisi"), rs.getString("oda_sayisi"), rs.getString("havuz")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public OrtakDAO getOrtakDao() {
        if (ortakDao == null) {
            this.ortakDao = new OrtakDAO();
        }
        return ortakDao;
    }

    public void setOrtakDao(OrtakDAO ortakDao) {
        this.ortakDao = ortakDao;
    }

    public KullaniciDAO getKullaniciDao() {
        if (kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }
}
