/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Ufuk
 */
public class Daire {
    private int id;
    private Ortak ortak_id;
    private Kullanici kullanici_adi;
    private String oda_sayisi;
    private int bina_yasi;
    private String isitma_tipi;

    public Daire() {
    }

    public Daire(int id, Ortak ortak_id, Kullanici kullanici_adi, String oda_sayisi, int bina_yasi, String isitma_tipi) {
        this.id = id;
        this.ortak_id = ortak_id;
        this.kullanici_adi = kullanici_adi;
        this.oda_sayisi = oda_sayisi;
        this.bina_yasi = bina_yasi;
        this.isitma_tipi = isitma_tipi;
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

    public String getOda_sayisi() {
        return oda_sayisi;
    }

    public void setOda_sayisi(String oda_sayisi) {
        this.oda_sayisi = oda_sayisi;
    }

    public int getBina_yasi() {
        return bina_yasi;
    }

    public void setBina_yasi(int bina_yasi) {
        this.bina_yasi = bina_yasi;
    }

    public String getIsitma_tipi() {
        return isitma_tipi;
    }

    public void setIsitma_tipi(String isitma_tipi) {
        this.isitma_tipi = isitma_tipi;
    }
    
}
