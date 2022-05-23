/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Ufuk
 */
public class Villa {

    private int id;
    private Ortak ortak_id;
    private Kullanici kullanici_adi;
    private int kat_sayisi;
    private String oda_sayisi;
    private String havuz;

    public Villa() {
    }

    public Villa(int id, Ortak ortak_id, Kullanici kullanici_adi, int kat_sayisi, String oda_sayisi, String havuz) {
        this.id = id;
        this.ortak_id = ortak_id;
        this.kullanici_adi = kullanici_adi;
        this.kat_sayisi = kat_sayisi;
        this.oda_sayisi = oda_sayisi;
        this.havuz = havuz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ortak getOrtak_id() {
        return ortak_id;
    }

    public void setOrtak_id(Ortak ortak_id) {
        this.ortak_id = ortak_id;
    }

    public Kullanici getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(Kullanici kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public int getKat_sayisi() {
        return kat_sayisi;
    }

    public void setKat_sayisi(int kat_sayisi) {
        this.kat_sayisi = kat_sayisi;
    }

    public String getOda_sayisi() {
        return oda_sayisi;
    }

    public void setOda_sayisi(String oda_sayisi) {
        this.oda_sayisi = oda_sayisi;
    }

    public String getHavuz() {
        return havuz;
    }

    public void setHavuz(String havuz) {
        this.havuz = havuz;
    }
    
}
