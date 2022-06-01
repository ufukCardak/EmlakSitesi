/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.DaireDAO;
import entity.Daire;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ufuk
 */
@Named(value = "daireBean")
@SessionScoped
public class DaireBean implements Serializable {

    private Daire entity;
    private DaireDAO dao;
    private List<Daire> list;

    private int page = 1;
    private int pageCount = 0;
    
    public DaireBean() {
    }

    public void delete(Daire c) {
        this.getDao().delete(c);
        entity = new Daire();
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new Daire();
    }

    public void create(int ortak_id,String kullanici_ad) {
        this.getDao().create(entity, ortak_id,kullanici_ad);
        this.entity = new Daire();
    }

    public Daire getEntity() {
        if (this.entity == null) {
            this.entity = new Daire();
        }
        return entity;
    }

    public void setEntity(Daire entity) {
        this.entity = entity;
    }

    public DaireDAO getDao() {
        if (this.dao == null) {
            this.dao = new DaireDAO();
        }
        return dao;
    }

    public void setDao(DaireDAO dao) {
        this.dao = dao;
    }

    public List<Daire> getList() {
        this.list = this.getDao().getDaireList();
        return list;
    }
    public List<Daire> getPagList() {
        this.list = this.getDao().getDaireList(page);
        return list;
    }
    public void setList(List<Daire> list) {
        this.list = list;
    }

    public void clear() {
        entity = new Daire();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<Daire> gList = this.getDao().getDaireList(); 
        double size = gList.size();
        pageCount = (int)Math.ceil(size/5);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public void previous(){
        page--;
        if (page < 1) {
            page = this.getPageCount();
        }
    }
    public void next(){
        page++;
        if (page > this.getPageCount()) {
            page = 1;
        }
    }
}
