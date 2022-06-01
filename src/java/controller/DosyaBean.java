/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.DosyaDAO;
import entity.Dosya;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author Ufuk
 */
@Named(value = "dosyaBean")
@SessionScoped
public class DosyaBean implements Serializable {

    private Dosya dosya;
    private List<Dosya> dosyaList;
    private DosyaDAO dosyaDao;

    private Part dos;

    private String dosyaYol = "/Users/ufuk/upload/";

    public void upload() {
        try {
            InputStream input = dos.getInputStream();
            File f = new File(dosyaYol + dos.getSubmittedFileName());
            Files.copy(input, f.toPath());
            dosya = this.getDosya();
            System.out.println("filePath " + f.getParent());
            System.out.println("fileName " + f.getName());
            dosya.setFilePath(f.getParent());
            dosya.setFileName(f.getName());
            this.getDosyaDao().create(dosya);
        } catch (Exception e) {
            System.out.println("111111");
            System.out.println(e.getMessage());
        }
    }

    public Dosya getDosya() {
        if (this.dosya == null) {
            this.dosya = new Dosya();
        }
        return dosya;
    }

    public void setDosya(Dosya dosya) {
        this.dosya = dosya;
    }

    public List<Dosya> getDosyaList() {
        this.dosyaList = this.getDosyaDao().findAll();
        return dosyaList;
    }

    public void setDosyaList(List<Dosya> dosyaList) {
        this.dosyaList = dosyaList;
    }

    public DosyaDAO getDosyaDao() {
        if (this.dosyaDao == null) {
            this.dosyaDao = new DosyaDAO();
        }
        return dosyaDao;
    }

    public void setDosyaDao(DosyaDAO dosyaDao) {
        this.dosyaDao = dosyaDao;
    }

    public Part getDos() {
        return dos;
    }

    public void setDos(Part dos) {
        this.dos = dos;
    }

    public String getDosyaYol() {
        return dosyaYol;
    }

}
