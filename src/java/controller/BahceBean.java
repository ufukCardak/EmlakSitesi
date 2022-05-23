/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.BahceDAO;
import entity.Bahce;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ufuk
 */
@Named(value = "bahceBean")
@SessionScoped
public class BahceBean implements Serializable {
private Bahce entity;
    private BahceDAO dao;
    private List<Bahce> list;

    public BahceBean() {
    }

    public void delete(Bahce c) {
        this.getDao().delete(c);
        entity = new Bahce();
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new Bahce();
    }

    public void create(int ortak_id, String kullanici_ad) {
        this.getDao().create(entity, ortak_id, kullanici_ad);
        this.entity = new Bahce();
    }

    public Bahce getEntity() {
        if (this.entity == null) {
            this.entity = new Bahce();
        }
        return entity;
    }

    public void setEntity(Bahce entity) {
        this.entity = entity;
    }

    public BahceDAO getDao() {
        if (this.dao == null) {
            this.dao = new BahceDAO();
        }
        return dao;
    }

    public void setDao(BahceDAO dao) {
        this.dao = dao;
    }

    public List<Bahce> getList() {
        this.list = this.getDao().getBahceList();
        return list;
    }

    public void setList(List<Bahce> list) {
        this.list = list;
    }

    public void clear() {
        entity = new Bahce();
    }
    
}
