/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Ufuk
 */
/*@FacesConverter("kullaniciConverter")
public class KullaniciConverter implements Converter {

    private KullaniciDAO kullaniciDao;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {

        Kullanici k = this.getKullaniciDao().findByString(string);
        return k;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object t) {
        Kullanici k = (Kullanici) t;
        return String.valueOf(k);
    }

    public KullaniciDAO getKullaniciDao() {
        if (kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

}*/
