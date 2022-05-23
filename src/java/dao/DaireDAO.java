/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Daire;
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
public class DaireDAO extends DBConnection {

    private OrtakDAO ortakDao;
    private KullaniciDAO kullaniciDao;

    public void create(Daire c, int ortak_id, String kullanici_ad) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into daire (ortak_id,kullanici_adi,oda_sayisi,bina_yasi,isitma_tipi) "
                    + "values "
                    + "('" + ortak_id + "','" + kullanici_ad + "','" + c.getOda_sayisi() + "','"
                    + c.getBina_yasi() + "','" + c.getIsitma_tipi() + "')";
            //System.out.println("Daire query " + query);
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Daire c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from daire where daire_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Daire c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update daire set oda_sayisi='"+c.getOda_sayisi()+"',bina_yasi='"+c.getBina_yasi()+"',isitma_tipi='"+c.getIsitma_tipi()+"'  where daire_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Daire> getDaireList() {
        List<Daire> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from daire";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Ortak o = this.getOrtakDao().findByID(rs.getInt("ortak_id"));
                Kullanici k = this.getKullaniciDao().findByString(rs.getString("kullanici_adi"));
                
                list.add(new Daire(rs.getInt("daire_id"), o,k, rs.getString("oda_sayisi"), rs.getInt("bina_yasi"), rs.getString("isitma_tipi")));
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
