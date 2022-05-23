/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanici;
import entity.Ortak;
import entity.Tarla;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Ufuk
 */
public class TarlaDAO extends DBConnection{
    private OrtakDAO ortakDao;
    private KullaniciDAO kullaniciDao;

    public void create(Tarla c, int ortak_id, String kullanici_ad) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into tarla (ortak_id,kullanici_adi,tapu_durumu) "
                    + "values "
                    + "('" + ortak_id + "','" + kullanici_ad + "','" + c.getTapu_durumu() + "')";
            //System.out.println("Tarla query " + query);
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Tarla c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from tarla where tarla_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Tarla c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update tarla set tapu_durumu='"+c.getTapu_durumu()+"' where tarla_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Tarla> getTarlaList() {
        List<Tarla> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from tarla";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Ortak o = this.getOrtakDao().findByID(rs.getInt("ortak_id"));
                Kullanici k = this.getKullaniciDao().findByString(rs.getString("kullanici_adi"));
                
                list.add(new Tarla(rs.getInt("tarla_id"), o,k, rs.getString("tapu_durumu")));
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
