/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import entity.Kullanici;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Ufuk
 */
public class KullaniciDAO extends DBConnection {

    public Kullanici findByString(String kullaniciAdi) {
        Kullanici k = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from kullanici where kullanici_adi='" + (String) kullaniciAdi + "'";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                k = new Kullanici(rs.getString("kullanici_adi"), rs.getString("isim"), rs.getString("soyisim"), rs.getString("email"), rs.getString("sifre"), rs.getString("tel_no"), rs.getBoolean("admin"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return k;
    }

    public Kullanici findByString(String kullaniciAdi, String sifre) {
        Kullanici k = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from kullanici where kullanici_adi='" + (String) kullaniciAdi + "' and sifre='" + (String) sifre + "'";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                k = new Kullanici(rs.getString("kullanici_adi"), rs.getString("isim"), rs.getString("soyisim"), rs.getString("email"), rs.getString("sifre"), rs.getString("tel_no"), rs.getBoolean("admin"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return k;
    }

    public void create(Kullanici c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into kullanici (kullanici_adi,isim,soyisim,email,sifre,tel_no,admin) "
                    + "values "
                    + "('" + c.getKullanici_ad() + "','" + c.getIsim() + "','" + c.getSoyad() + "','" + c.getEmail() + "','" + c.getSifre() + "','" + c.getTel_no() + "','" + c.isAdminYetki() + "')RETURNING kullanici_adi";

            System.out.println("Kullanici query " + query);

            ResultSet rs = st.executeQuery(query);
            rs.next();
            String ad = rs.getString(1);
            //System.out.println("ad " + ad);
            c.setKullanici_ad(ad);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kullanici c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from kullanici where kullanici_adi='" + c.getKullanici_ad() + "'";
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Kullanici c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update kullanici set isim='" + c.getIsim() + "',soyisim='" + c.getIsim() + "',email='" + c.getEmail() + "',sifre='" + c.getSifre() + "',tel_no='" + c.getTel_no() + "',admin='" + c.isAdminYetki() + "'  where kullanici_adi='" + c.getKullanici_ad() + "'";
            int r = st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Kullanici> getKullaniciList() {
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from kullanici";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Kullanici(rs.getString("kullanici_adi"), rs.getString("isim"), rs.getString("soyisim"), rs.getString("email"), rs.getString("sifre"), rs.getString("tel_no"), rs.getBoolean("admin")));
            }          
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}
