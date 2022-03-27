/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author Ufuk
 */
public class Category {

    private long id;
    private String title;
    private int fiyat;
    private String aciklama;
    private Timestamp created;
    private Timestamp updated;

    public Category() {
    }

    public Category(long id, String title,int fiyat,String aciklama, Timestamp created, Timestamp updated) {
        this.id = id;
        this.title = title;
        this.fiyat = fiyat;
        this.aciklama = aciklama;
        this.created = created;
        this.updated = updated;
    }

    public Category(String title,int fiyat,String aciklama, Timestamp created) {
        this.id = id;
        this.title = title;
        this.fiyat = fiyat;
        this.aciklama = aciklama;
        this.created = created;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", title=" + title + ", created=" + created + ", updated=" + updated + '}';
    }

    
}
