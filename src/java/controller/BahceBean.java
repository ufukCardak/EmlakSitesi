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
    
    private int page = 1;
    private int pageCount = 0;

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
    public List<Bahce> getPagList() {
        this.list = this.getDao().getBahceList(page);
        return list;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<Bahce> gList = this.getDao().getBahceList();
        double size = gList.size();
        pageCount = (int) Math.ceil(size / 5);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void previous() {
        page--;
        if (page < 1) {
            page = this.getPageCount();
        }
    }

    public void next() {
        page++;
        if (page > this.getPageCount()) {
            page = 1;
        }
    }
}
