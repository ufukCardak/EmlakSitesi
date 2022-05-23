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
    private int fiyat;
    private int boyut;
    private String aciklama;
    private String dosya_yolu;

    public Ortak() {
    }

    public Ortak(int id, Adres adres, int fiyat, int boyut, String aciklama, String dosya_yolu) {
        this.id = id;
        this.adres = adres;
        this.fiyat = fiyat;
        this.boyut = boyut;
        this.aciklama = aciklama;
        this.dosya_yolu = dosya_yolu;
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

    public String getDosya_yolu() {
        return dosya_yolu;
    }

    public void setDosya_yolu(String dosya_yolu) {
        this.dosya_yolu = dosya_yolu;
    }

}
