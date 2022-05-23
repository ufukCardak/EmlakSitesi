/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ufuk
 */
@Named(value = "kullaniciBean")
@SessionScoped
public class KullaniciBean implements Serializable {

    private Kullanici entity;
    private KullaniciDAO dao;
    private List<Kullanici> list;

    public KullaniciBean() {
    }

    public void create() {
        this.getDao().create(entity);
        //entity = new Kullanici();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kullanici();
    }

    public void delete(Kullanici o) {
        this.getDao().delete(o);
        entity = new Kullanici();
    }

    public Kullanici getEntity() {
        if (entity == null) {
            entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
        this.entity = entity;
    }

    public KullaniciDAO getDao() {
        if (dao == null) {
            dao = new KullaniciDAO();
        }
        return dao;
    }

    public void setDao(KullaniciDAO dao) {
        this.dao = dao;
    }

    public List<Kullanici> getList() {
        this.list = this.getDao().getKullaniciList();
        return list;
    }

    public void setList(List<Kullanici> list) {
        this.list = list;
    }

    public void clear() {
        entity = new Kullanici();
    }
}
