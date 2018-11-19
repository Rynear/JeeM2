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
    private Integer idE;
    private Integer idP;
    private Date dateC;
    private String comC;
    
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
    
    
}