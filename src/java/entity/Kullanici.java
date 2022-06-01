/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Ufuk
 */
public class Kullanici {
    
    private String kullanici_ad;
    private String isim;
    private String soyad;
    private String email;
    private String sifre;
    private String tel_no;
    private boolean adminYetki;
    
    public Kullanici() {
    }

    public Kullanici(String kullanici_ad, String isim, String soyad, String email, String sifre, String tel_no, boolean adminYetki) {
        this.kullanici_ad = kullanici_ad;
        this.isim = isim;
        this.soyad = soyad;
        this.email = email;
        this.sifre = sifre;
        this.tel_no = tel_no;
        this.adminYetki = adminYetki;
    }

    /*public Kullanici(String kullanici_ad, String isim, String soyad, String email, String sifre, String tel_no) {
        this.kullanici_ad = kullanici_ad;
        this.isim = isim;
        this.soyad = soyad;
        this.email = email;
        this.sifre = sifre;
        this.tel_no = tel_no;
    }*/

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public boolean isAdminYetki() {
        return adminYetki;
    }

    public void setAdminYetki(boolean adminYetki) {
        this.adminYetki = adminYetki;
    }
}
