/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.OrtakDAO;
import entity.Ortak;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ufuk
 */
@Named(value = "ortakBean")
@SessionScoped
public class OrtakBean implements Serializable {

    private Ortak entity;
    private OrtakDAO dao;
    private List<Ortak> list;
    
    public OrtakBean() {

    }

    public void create(int adres_id,int dosya_id) {
        this.getDao().create(entity, adres_id,dosya_id);
        //entity = new Ortak();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Ortak();
    }

    public void delete(Ortak o) {
        this.getDao().delete(o);
        entity = new Ortak();
    }

    public Ortak getEntity() {
        if (entity == null) {
            entity = new Ortak();
        }
        return entity;
    }

    public void setEntity(Ortak entity) {
        this.entity = entity;
    }

    public OrtakDAO getDao() {
        if (dao == null) {
            dao = new OrtakDAO();
        }
        return dao;
    }

    public void setDao(OrtakDAO dao) {
        this.dao = dao;
    }

    public List<Ortak> getList() {
        this.list = this.getDao().getOrtakList();
        return list;
    }

    public void setList(List<Ortak> list) {
        this.list = list;
    }

    public void clear() {
        entity = new Ortak();
    }    
}
