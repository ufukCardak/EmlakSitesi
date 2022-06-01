/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Ufuk
 */
public class Ortak {

    private int id;
    private Adres adres;
    private Dosya dosya;
    private int fiyat;
    private int boyut;
    private String aciklama;

    public Ortak() {
    }

    public Ortak(int id, Adres adres, Dosya dosya, int fiyat, int boyut, String aciklama) {
        this.id = id;
        this.adres = adres;
        this.dosya = dosya;
        this.fiyat = fiyat;
        this.boyut = boyut;
        this.aciklama = aciklama;
    }


    public Dosya getDosya() {
        return dosya;
    }

    public void setDosya(Dosya dosya) {
        this.dosya = dosya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
    

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getBoyut() {
        return boyut;
    }

    public void setBoyut(int boyut) {
        this.boyut = boyut;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}
