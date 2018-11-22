/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import dao.CoursFacadeLocal;
import entity.Cours;
import dao.ProfFacadeLocal;
import entity.Prof;
import dao.EleveFacadeLocal;
import entity.Eleve;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Julien
 */
@Named(value = "vueCharts")
@SessionScoped
public class vueCharts implements Serializable {

    @EJB
    CoursFacadeLocal coursDAO;
    @EJB
    ProfFacadeLocal profDAO;
    @EJB
    EleveFacadeLocal eleveDAO;
    private Cours monCours;
    private Prof monProf;
    private Eleve monEleve;
    private List<Cours> listCours;
    private List<Prof> listProf;
    private List<Eleve> listEleve;
    private PieChartModel model;
    private PieChartModel pieModel1;
    private PieChartModel livePieModel;
    private PieChartModel livePModel;

    public void setListCours(List<Cours> listCours) {
        this.listCours = listCours;
    }

    public void setListProf(List<Prof> listProf) {
        this.listProf = listProf;
    }

    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }

    public void setLivePModel(PieChartModel livePModel) {
        this.livePModel = livePModel;
    }

    public void setLivePieModel(PieChartModel livePieModel) {
        this.livePieModel = livePieModel;
    }

    @PostConstruct
    public void init() {
        createPieModels();
        listEleve = new ArrayList<Eleve>();
        listEleve = eleveDAO.findAll();
        listProf = new ArrayList<Prof>();
        listProf = profDAO.findAll();
        listCours = new ArrayList<Cours>();
        listCours = coursDAO.findAll();
    }
    
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    
    public PieChartModel getModel() {
        return model;
    }

    public void setModel(PieChartModel model) {
        this.model = model;
    }

    public Cours getMonCours() {
        return monCours;
    }

    public void setMonCours(Cours monCours) {
        this.monCours = monCours;
    }

    public Prof getMonProf() {
        return monProf;
    }

    public void setMonProf(Prof monProf) {
        this.monProf = monProf;
    }

    public Eleve getMonEleve() {
        return monEleve;
    }

    public void setMonEleve(Eleve monEleve) {
        this.monEleve = monEleve;
    }

    public List<Prof> getListProf() {
        return profDAO.findAll();
    }

//    public Integer sizeListProf() {
//        return listProf.size();
//    }

    public List<Eleve> getListEleve() {
        return eleveDAO.findAll();
    }

    public void setListEleve(List<Eleve> listEleve) {
        this.listEleve = listEleve;
    }

    public CoursFacadeLocal getCoursDAO() {
        return coursDAO;
    }

    public void setCoursDAO(CoursFacadeLocal coursDAO) {
        this.coursDAO = coursDAO;
    }

    public ProfFacadeLocal getProfDAO() {
        return profDAO;
    }

    public void setProfDAO(ProfFacadeLocal profDAO) {
        this.profDAO = profDAO;
    }

    public EleveFacadeLocal getEleveDAO() {
        return eleveDAO;
    }

    public void setEleveDAO(EleveFacadeLocal eleveDAO) {
        this.eleveDAO = eleveDAO;
    }

    public List<Cours> getListCours() {
        return coursDAO.findAll();
    }

    private void createPieModels() {
        createPieModel1();
    }
    
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
 
        pieModel1.set("Nombre de profs", 250);
        pieModel1.set("Nombre d'élèves", 325);
        pieModel1.set("Nombe de cours", 702);
 
        pieModel1.setTitle("Découvrez nos chiffres impressionnants !!!");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(true);
    }
    
    public PieChartModel getLivePModel() {
        PieChartModel livePModel = new PieChartModel();
        
        listEleve = eleveDAO.findAll();
        int tailleEleve = listEleve.size();
        listProf = profDAO.findAll();
        int tailleProf = listProf.size();
        listCours = coursDAO.findAll();
        int tailleCours = listCours.size();
        
        livePModel.getData().put("Nombre d'élèves inscrits", tailleEleve);
        livePModel.getData().put("Nombre de professeurs inscrits", tailleProf);
        livePModel.getData().put("Nombre de cours dispensés", tailleCours);
 
        livePModel.setTitle("Les chiffres du site");
        livePModel.setLegendPosition("w");
        
        setLivePieModel(livePModel);
        return livePieModel;
    }
    /**
     * Creates a new instance of vueCharts
     */
    public vueCharts() {
    }
}

