/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CoursFacadeLocal;
import entity.Cours;
import dao.ProfFacadeLocal;
import entity.Prof;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author felix
 */
@Named(value = "vueCours")
@SessionScoped
public class VueCours implements Serializable {

    @EJB
    CoursFacadeLocal coursDAO;
    @EJB
    ProfFacadeLocal profDAO;
    private Cours monCours;
    private List<Cours> listCours;
    private List<Cours> listCoursSansEleve;
    private List<Cours> listCoursFinal;
    private Integer idC;
    private Integer idE;
    private Integer idP;
    private Date dateC;
    private String comC;
    private Integer recordIdCours;
    private Cours monNouveauCours;
    private Integer newIdProf;

    
    
    /**
     * Creates a new instance of VueCours
     */
    public VueCours() {
        monCours = new Cours();
        monNouveauCours = new Cours();
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

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public Integer getNewIdProf() {
        return newIdProf;
    }

    public void setNewIdProf(Integer newIdProf) {
        this.newIdProf = newIdProf;
    }

    /**
     * Retourne la liste des héros qui sont dans la base de données_avec
     * primefaces
     *
     * @return
     */
    public List<Cours> getListCours() {
        return coursDAO.findAll();
    }

    public void setListCours(List<Cours> listCours) {
        this.listCours = listCours;
    }

    public Cours getMonNouveauCours() {
        return monNouveauCours;
    }

    public void setMonNouveauCours(Cours monNouveauCours) {
        this.monNouveauCours = monNouveauCours;
    }

    public void addNewCours() {
        Prof pf = profDAO.find(newIdProf);
        monNouveauCours.setIdP(pf);
        coursDAO.create(monNouveauCours);
        monNouveauCours = new Cours();
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

    public ProfFacadeLocal getProfDAO() {
        return profDAO;
    }

    public void setProfDAO(ProfFacadeLocal profDAO) {
        this.profDAO = profDAO;
    }

    public List<Cours> getListCoursSansEleve() {
        listCoursSansEleve = coursDAO.findAll();
        List<Cours> listCoursFinal = new ArrayList<>();
        for (int i = 0; i < listCoursSansEleve.size(); i++){
            if (listCoursSansEleve.get(i).getIdE() == null){
                listCoursFinal.add(listCoursSansEleve.get(i));
            }
        }
        return listCoursFinal;
    }

    public void setListCoursSansEleve(List<Cours> listCoursSansEleve) {
        this.listCoursSansEleve = listCoursSansEleve;
    }

    public Integer getRecordIdCours() {
        return recordIdCours;
    }

    public void setRecordIdCours(Integer recordIdCours) {
        this.recordIdCours = recordIdCours;
    }
}
