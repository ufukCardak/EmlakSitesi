/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.VillaDAO;
import entity.Villa;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ufuk
 */
@Named(value = "villaBean")
@SessionScoped
public class VillaBean implements Serializable {
    
    private Villa entity;
    private VillaDAO dao;
    private List<Villa> list;
    
    private int page = 1;
    private int pageCount = 0;
    public VillaBean() {
    }

    public void delete(Villa c) {
        this.getDao().delete(c);
        entity = new Villa();
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new Villa();
    }

    public void create(int ortak_id, String kullanici_ad) {
        this.getDao().create(entity, ortak_id, kullanici_ad);
        this.entity = new Villa();
    }

    public Villa getEntity() {
        if (this.entity == null) {
            this.entity = new Villa();
        }
        return entity;
    }

    public void setEntity(Villa entity) {
        this.entity = entity;
    }

    public VillaDAO getDao() {
        if (this.dao == null) {
            this.dao = new VillaDAO();
        }
        return dao;
    }

    public void setDao(VillaDAO dao) {
        this.dao = dao;
    }

    public List<Villa> getList() {
        this.list = this.getDao().getVillaList();
        return list;
    }

    public void setList(List<Villa> list) {
        this.list = list;
    }

    public void clear() {
        entity = new Villa();
    }
        public int getPage() {
        return page;
    }
    public List<Villa> getPagList() {
        this.list = this.getDao().getVillaList(page);
        return list;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<Villa> gList = this.getDao().getVillaList();
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
