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
    private List<Cours> listCoursSansElevePrimaire;
    private List<Cours> listCoursSansEleveCollege;
    private List<Cours> listCoursSansEleveLycee;
    private List<Prof> listProfInt;
    private List<Prof> listProfCollege;
    private List<Prof> listProfLycee;
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

    public List<Prof> getListProfInt() {
        return listProfInt;
    }

    public void setListProfInt(List<Prof> listProfInt) {
        this.listProfInt = listProfInt;
    }
    
    public List<Prof> getListProfPrimaire(){
        listProfInt = profDAO.findAll();
        List<Prof> listProfFinal = new ArrayList<>();
        for (int i = 0; i < listProfInt.size(); i++){
            if (listProfInt.get(i).getNiveauMaxP() < 6){
                listProfFinal.add(listProfInt.get(i));
            }
        }
        return listProfFinal;
    }
    
    public List<Prof> getListProfCollege(){
        listProfCollege = profDAO.findAll();
        List<Prof> listProfFinal = new ArrayList<>();
        for (int i = 0; i < listProfCollege.size(); i++){
            if (listProfCollege.get(i).getNiveauMaxP() > 5 && listProfCollege.get(i).getNiveauMaxP() < 10){
                listProfFinal.add(listProfCollege.get(i));
            }
        }
        return listProfFinal;
    }
    
    public List<Prof> getListProfLycee(){
        listProfLycee = profDAO.findAll();
        List<Prof> listProfFinal = new ArrayList<>();
        for (int i = 0; i < listProfLycee.size(); i++){
            if (listProfLycee.get(i).getNiveauMaxP() >= 10){
                listProfFinal.add(listProfLycee.get(i));
            }
        }
        return listProfFinal;
    }

    public List<Cours> getListCoursSansElevePrimaire() {
        listCoursSansElevePrimaire = coursDAO.findAll();
        List<Cours> listCoursFinal = new ArrayList<>();
        List<Prof> listProfPrimaire = new ArrayList<>();
        listProfPrimaire = getListProfPrimaire();
        for (int i = 0; i < listCoursSansElevePrimaire.size(); i++){
            if (listCoursSansElevePrimaire.get(i).getIdE() == null){
                for (int y = 0; y < listProfPrimaire.size(); y++){
                    if (listCoursSansElevePrimaire.get(i).getIdP().getIdP() == listProfPrimaire.get(y).getIdP()){
                        listCoursFinal.add(listCoursSansElevePrimaire.get(i));
                    }
                }
            }
        }
        return listCoursFinal;
    }
    
        public List<Cours> getListCoursSansEleveCollege() {
        listCoursSansEleveCollege = coursDAO.findAll();
        List<Cours> listCoursFinal = new ArrayList<>();
        List<Prof> listProfCollege = new ArrayList<>();
        listProfCollege = getListProfCollege();
        for (int i = 0; i < listCoursSansEleveCollege.size(); i++){
            if (listCoursSansEleveCollege.get(i).getIdE() == null){
                for (int y = 0; y < listProfCollege.size(); y++){
                    if (listCoursSansEleveCollege.get(i).getIdP().getIdP() == listProfCollege.get(y).getIdP()){
                        listCoursFinal.add(listCoursSansEleveCollege.get(i));
                    }
                }
            }
        }
        return listCoursFinal;
    }
    
    public List<Cours> getListCoursSansEleveLycee() {
        listCoursSansEleveLycee = coursDAO.findAll();
        List<Cours> listCoursFinal = new ArrayList<>();
        List<Prof> listProfLycee = new ArrayList<>();
        listProfLycee = getListProfLycee();
        for (int i = 0; i < listCoursSansEleveLycee.size(); i++){
            if (listCoursSansEleveLycee.get(i).getIdE() == null){
                for (int y = 0; y < listProfLycee.size(); y++){
                    if (listCoursSansEleveLycee.get(i).getIdP().getIdP() == listProfLycee.get(y).getIdP()){
                        listCoursFinal.add(listCoursSansEleveLycee.get(i));
                    }
                }
            }
        }
        return listCoursFinal;
    }

    public void setListCoursSansElevePrimaire(List<Cours> listCoursSansElevePrimaire) {
        this.listCoursSansElevePrimaire = listCoursSansElevePrimaire;
    }

    public Integer getRecordIdCours() {
        return recordIdCours;
    }

    public void setRecordIdCours(Integer recordIdCours) {
        this.recordIdCours = recordIdCours;
    }
}
