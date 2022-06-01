/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.AdresDAO;
import entity.Adres;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ufuk
 */
@Named(value = "adresBean")
@SessionScoped
public class AdresBean implements Serializable {

    private Adres entity;
    private AdresDAO dao;
    private List<Adres> list;

    public AdresBean() {

    }
    public boolean validateAdress(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String v = (String) value;
        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("*İl alanı boş olamaz!"));
        }
        return true;
    }
    public void create() {
        this.getDao().create(entity);
        //entity = new Adres();
    }
    
    public void update() {
        this.getDao().update(entity);
        entity = new Adres();
    }

    public void delete(Adres a) {
        this.getDao().delete(a);
        entity = new Adres();
    }

    public Adres getEntity() {
        if (entity == null) {
            entity = new Adres();
        }
        return entity;
    }

    public void setEntity(Adres entity) {
        this.entity = entity;
    }

    public AdresDAO getDao() {
        if (dao == null) {
            dao = new AdresDAO();
        }
        return dao;
    }

    public void setDao(AdresDAO dao) {
        this.dao = dao;
    }

    public List<Adres> getList() {
        this.list = this.getDao().getAdresList();
        return list;
    }

    public void setList(List<Adres> list) {
        this.list = list;
    }
    public void clear() {
        entity = new Adres();
    }
}
