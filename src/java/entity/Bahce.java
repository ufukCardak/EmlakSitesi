/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Ufuk
 */
public class Bahce {

    private int id;
    private Ortak ortak_id;
    private Kullanici kullanici_adi;
    private String tapu_durumu;
    private String imar_durumu;

    public Bahce() {
    }

    public Bahce(int id, Ortak ortak_id, Kullanici kullanici_adi, String tapu_durumu, String imar_durumu) {
        this.id = id;
        this.ortak_id = ortak_id;
        this.kullanici_adi = kullanici_adi;
        this.tapu_durumu = tapu_durumu;
        this.imar_durumu = imar_durumu;
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

    public String getTapu_durumu() {
        return tapu_durumu;
    }

    public void setTapu_durumu(String tapu_durumu) {
        this.tapu_durumu = tapu_durumu;
    }

    public String getImar_durumu() {
        return imar_durumu;
    }

    public void setImar_durumu(String imar_durumu) {
        this.imar_durumu = imar_durumu;
    }
    
}
