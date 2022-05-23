/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

/*import dao.OrtakDAO;
import entity.Ortak;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("ortakConverter")
public class OrtakConverter implements Converter {

    private OrtakDAO ortakDao;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
        int id = Integer.valueOf(string);
        Ortak o = this.getOrtakDao().findByID(id);
        return o;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object t) {
        Ortak o = (Ortak) t;
        return String.valueOf(o.getOrtak_id());
    }

    public OrtakDAO getOrtakDao() {
        if (ortakDao == null) {
            this.ortakDao = new OrtakDAO();
        }
        return ortakDao;
    }

    public void setOrtakDao(OrtakDAO ortakDao) {
        this.ortakDao = ortakDao;
    }
}*/
