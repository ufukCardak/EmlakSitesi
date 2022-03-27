/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.sql.Timestamp;

/**
 *
 * @author Ufuk
 */
@Named(value = "categoryBean")
@SessionScoped
public class CategoryBean implements Serializable {

    private Category entity;
    private CategoryDAO dao;
    private List<Category> list;
    
    public CategoryBean() {
    }

    public void delete(Category c){
        this.getDao().delete(c);
    }
    public void create(){
        this.entity.setCreated(new Timestamp(System.currentTimeMillis()));
        this.getDao().createCategory(entity);
        this.entity = new Category();
    }
    
    public Category getEntity() {
        if (this.entity == null) {
            this.entity = new Category();
        }
        return entity;
    }

    public void setEntity(Category entity) {
        this.entity = entity;
    }

    public CategoryDAO getDao() {
        if (this.dao == null) {
            this.dao = new CategoryDAO();
        }
        return dao;
    }

    public void setDao(CategoryDAO dao) {
        this.dao = dao;
    }

    public List<Category> getList() {
        this.list = this.getDao().getCaregoryList();
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }
    
}
