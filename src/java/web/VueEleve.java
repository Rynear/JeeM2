/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.EleveFacadeLocal;
import dao.ProfFacadeLocal;
import entity.Eleve;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Julien
 */
@Named(value = "vueEleve")
@SessionScoped
public class VueEleve implements Serializable {

    @EJB
    EleveFacadeLocal eleveDAO;
    @EJB
    ProfFacadeLocal profDAO;
    private Eleve monEleve;
    private Integer idEleve;
    private String nomEleve;
    private String prenomEleve;
    private Integer sexeEleve;
    private Integer ageEleve;
    private Integer niveauEleve;
    private String mdpEleve;
    private String message;
    private String option;
    
    /**
     * Creates a new instance of VueEleve
     */
    public VueEleve() {
    }
    
    @PostConstruct
    public void init () {
        monEleve = new Eleve();
    }
    
    public List<Eleve> getListeEleve() {
        return listeEleve;
    }

    public void setListeEleve(List<Eleve> listeEleve) {
        this.listeEleve = listeEleve;
    }
    private List<Eleve> listeEleve;

    public EleveFacadeLocal getEleveDAO() {
        return eleveDAO;
    }

    public void setEleveDAO(EleveFacadeLocal eleveDAO) {
        this.eleveDAO = eleveDAO;
    }

    public ProfFacadeLocal getProfDAO() {
        return profDAO;
    }

    public void setProfDAO(ProfFacadeLocal profDAO) {
        this.profDAO = profDAO;
    }

    public Eleve getMonEleve() {
        return monEleve;
    }

    public void setMonEleve(Eleve monEleve) {
        this.monEleve = monEleve;
    }

    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public Integer getSexeEleve() {
        return sexeEleve;
    }

    public void setSexeEleve(Integer sexeEleve) {
        this.sexeEleve = sexeEleve;
    }

    public Integer getAgeEleve() {
        return ageEleve;
    }

    public void setAgeEleve(Integer ageEleve) {
        this.ageEleve = ageEleve;
    }

    public Integer getNiveauEleve() {
        return niveauEleve;
    }

    public void setNiveauEleve(Integer niveauEleve) {
        this.niveauEleve = niveauEleve;
    }

    public String getMdpEleve() {
        return mdpEleve;
    }

    public void setMdpEleve(String mdpEleve) {
        this.mdpEleve = mdpEleve;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void ajoutEleve(){
        eleveDAO.create(monEleve);
        saveMessage();
    }
        
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful") );
    }

    public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
