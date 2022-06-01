/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
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
@Named(value = "kullaniciBean")
@SessionScoped
public class KullaniciBean  implements Serializable {

    private Kullanici entity;
    private KullaniciDAO dao;
    private List<Kullanici> list;

    public KullaniciBean() {
    }

    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String v = (String) value;
        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Şifre alanı boş olamaz!"));
        } else if (v.length() < 4) {
            throw new ValidatorException(new FacesMessage("Şifre alanı 4 karakterden az olamaz!"));
        }
        return true;
    }

    public String login(String ad, String sifre) {

        Kullanici kullanici = this.getDao().findByString(ad, sifre);
        
        if (kullanici != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", kullanici);
            return "/index?faces-redirect=true";
        } else {
            clear();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanici adı veya Şifre yanlış!"));
            return null;
        }
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
        System.out.println("eqwdasdsa");
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

    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", null);
        entity = new Kullanici();
    }

    public void clear() {
        entity = new Kullanici();
    }
}
