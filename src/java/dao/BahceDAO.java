/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Bahce;
import entity.Kullanici;
import entity.Ortak;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Ufuk
 */
public class BahceDAO extends DBConnection{
    private OrtakDAO ortakDao;
    private KullaniciDAO kullaniciDao;

    public void create(Bahce c, int ortak_id, String kullanici_ad) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into bahce (ortak_id,kullanici_adi,tapu_durumu,imar_durumu) "
                    + "values "
                    + "('" + ortak_id + "','" + kullanici_ad + "','" + c.getTapu_durumu()+ "','"
                    + c.getImar_durumu()+ "')";
            //System.out.println("Bahce query " + query);
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Bahce c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from bahce where bahce_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Bahce c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update bahce set tapu_durumu='"+c.getTapu_durumu()+"',imar_durumu='"+c.getImar_durumu()+"' where bahce_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public List<Bahce> getBahceList(int page) {
        int offset = (page-1)*5;
        List<Bahce> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from bahce limit 5 offset " + offset;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Ortak o = this.getOrtakDao().findByID(rs.getInt("ortak_id"));
                Kullanici k = this.getKullaniciDao().findByString(rs.getString("kullanici_adi"));
                
                list.add(new Bahce(rs.getInt("bahce_id"), o,k, rs.getString("tapu_durumu"), rs.getString("imar_durumu")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    public List<Bahce> getBahceList() {
        List<Bahce> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from bahce";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Ortak o = this.getOrtakDao().findByID(rs.getInt("ortak_id"));
                Kullanici k = this.getKullaniciDao().findByString(rs.getString("kullanici_adi"));
                
                list.add(new Bahce(rs.getInt("bahce_id"), o,k, rs.getString("tapu_durumu"), rs.getString("imar_durumu")));
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
