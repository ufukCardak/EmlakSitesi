/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.TarlaDAO;
import entity.Tarla;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ufuk
 */
@Named(value = "tarlaBean")
@SessionScoped
public class TarlaBean implements Serializable {

private Tarla entity;
    private TarlaDAO dao;
    private List<Tarla> list;

    public TarlaBean() {
    }

    public void delete(Tarla c) {
        this.getDao().delete(c);
        entity = new Tarla();
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new Tarla();
    }

    public void create(int ortak_id, String kullanici_ad) {
        this.getDao().create(entity, ortak_id, kullanici_ad);
        this.entity = new Tarla();
    }

    public Tarla getEntity() {
        if (this.entity == null) {
            this.entity = new Tarla();
        }
        return entity;
    }

    public void setEntity(Tarla entity) {
        this.entity = entity;
    }

    public TarlaDAO getDao() {
        if (this.dao == null) {
            this.dao = new TarlaDAO();
        }
        return dao;
    }

    public void setDao(TarlaDAO dao) {
        this.dao = dao;
    }

    public List<Tarla> getList() {
        this.list = this.getDao().getTarlaList();
        return list;
    }

    public void setList(List<Tarla> list) {
        this.list = list;
    }

    public void clear() {
        entity = new Tarla();
    }
    
}
