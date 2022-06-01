/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Adres;
import entity.Dosya;
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
public class OrtakDAO extends DBConnection {

    private AdresDAO adresDao;
    private DosyaDAO dosyaDao;

    public Ortak findByID(int id) {
        Ortak o = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from ortak where ortak_id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Adres a = this.getAdresDao().findByID(rs.getInt("adres_id"));
                Dosya d = this.getDosyaDao().findByID(rs.getInt("dosya_id"));

                o = new Ortak(rs.getInt("ortak_id"), a, d, rs.getInt("fiyat"), rs.getInt("boyut"),
                        rs.getString("aciklama"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return o;
    }

    public void create(Ortak c, int adres_id, int dosya_id) {

        String query = null;

        try {

            Statement st = this.getConnection().createStatement();

            query = "insert into ortak(adres_id,dosya_id,fiyat,boyut,aciklama) values ('" + adres_id + "','" + dosya_id + "','" + c.getFiyat() + "','" + c.getBoyut() + "','" + c.getAciklama() + "')RETURNING ortak_id";

            System.out.println("Ortak query " + query);

            ResultSet rs = st.executeQuery(query);
            rs.next();
            int id = rs.getInt(1);
            //System.out.println("Ortak id " + id);
            c.setId(id);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Ortak c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from ortak where ortak_id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Ortak c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update ortak set "
                    + "fiyat='" + c.getFiyat() + "',boyut='" + c.getBoyut() + "',"
                    + "aciklama='" + c.getAciklama() + "' where ortak_id=" + c.getId();

            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Ortak> getOrtakList() {
        List<Ortak> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from ortak";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Adres a = this.getAdresDao().findByID(rs.getInt("adres_id"));
                Dosya d = this.getDosyaDao().findByID(rs.getInt("dosya_id"));
                list.add(new Ortak(rs.getInt("ortak_id"), a,d, rs.getInt("fiyat"), rs.getInt("boyut"), rs.getString("aciklama")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public AdresDAO getAdresDao() {
        if (adresDao == null) {
            this.adresDao = new AdresDAO();
        }
        return adresDao;
    }

    public void setAdresDao(AdresDAO adresDao) {
        this.adresDao = adresDao;
    }

    public DosyaDAO getDosyaDao() {
        if (dosyaDao == null) {
            this.dosyaDao = new DosyaDAO();
        }
        return dosyaDao;
    }

    public void setDosyaDao(DosyaDAO dosyaDao) {
        this.dosyaDao = dosyaDao;
    }

}
