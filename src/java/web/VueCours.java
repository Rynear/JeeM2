/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CoursFacadeLocal;
import entity.Cours;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author felix
 */
@Named(value = "vueCours")
@SessionScoped
public class VueCours implements Serializable {

    @EJB
    CoursFacadeLocal coursDAO;
    private Cours monCours;
    private List<Cours> listCours;
    private Integer idE;
    private Integer idP;
    private Date dateC;
    private String comC;
    private Integer recordIdCours;
    
    /**
     * Creates a new instance of VueCours
     */
    public VueCours() {
        monCours = new Cours();
    }

    public CoursFacadeLocal getCoursDAO() {
        return coursDAO;
    }

    public void setCoursDAO(CoursFacadeLocal coursDAO) {
        this.coursDAO = coursDAO;
    }

    public Cours getMonCours() {
        return monCours;
    }

    public void setMonCours(Cours monCours) {
        this.monCours = monCours;
    }

    public Integer getIdE() {
        return idE;
    }

    public void setIdE(Integer idE) {
        this.idE = idE;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public Date getDateC() {
        return dateC;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

    public String getComC() {
        return comC;
    }

    public void setComC(String comC) {
        this.comC = comC;
    }

    public Integer getRecordIdCours() {
        return recordIdCours;
    }

    public void setRecordIdCours(Integer recordIdCours) {
        this.recordIdCours = recordIdCours;
    }
    
    /**
     * Retourne la liste des héros qui sont dans la base de données_avec primefaces
     * @return 
     */    
    public List<Cours> getListCours() {
        return coursDAO.findAll();
    }

    public void setListCours(List<Cours> listCours) {
        this.listCours = listCours;
    }
}
