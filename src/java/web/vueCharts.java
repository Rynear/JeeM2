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
import java.util.List;
import javax.ejb.EJB;
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

    public Integer sizeListProf() {
        return listProf.size();
    }

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


    public void graph(){
        model = new PieChartModel();
        model.set("Nb cours", 12);
        model.set("Nb Profs", 48);
        model.set("Nb Eleve",12 );
        model.setTitle("Simple Pie");
        model.setLegendPosition("w");
    }
    /**
     * Creates a new instance of vueCharts
     */
    public vueCharts() {
    }
}

