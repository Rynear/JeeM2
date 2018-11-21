/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CoursFacadeLocal;
import dao.EleveFacadeLocal;
import entity.Cours;
import entity.Eleve;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author felix
 */
@Named(value = "vueEleve")
@SessionScoped
public class VueEleve implements Serializable {

    @EJB
    EleveFacadeLocal eleveDAO;
    @EJB
    CoursFacadeLocal coursDAO;
    private Cours monAncienCours;
    private Cours monNouveauCours;
    private List<Eleve> listEleve;
    private Eleve monEleve;
    private Eleve monNouveauEleve;
    private Eleve monAncienEleve;
    private Integer IdE;
    private String nomE;
    private String prenomE;
    private String mdpE;
    private Integer sexeE;
    private Integer niveauE;
    private String recordIdCours;
    private Integer numCours;
            
    /**
     * Creates a new instance of vueEleve
     */
    public VueEleve() {
        monEleve = new Eleve();
        monNouveauEleve = new Eleve();
        monAncienCours = new Cours();
        monNouveauCours = new Cours();
    }

    public EleveFacadeLocal getEleveDAO() {
        return eleveDAO;
    }

    public void setEleveDAO(EleveFacadeLocal eleveDAO) {
        this.eleveDAO = eleveDAO;
    }

    public Eleve getMonEleve() {
        return monEleve;
    }

    public void setMonEleve(Eleve monEleve) {
        this.monEleve = monEleve;
    }

    public Eleve getMonNouveauEleve() {
        return monNouveauEleve;
    }

    public void setMonNouveauEleve(Eleve monNouveauEleve) {
        this.monNouveauEleve = monNouveauEleve;
    }

    public Eleve getMonAncienEleve() {
        return monAncienEleve;
    }

    public void setMonAncienEleve(Eleve monAncienEleve) {
        this.monAncienEleve = monAncienEleve;
    }

    public Integer getIdE() {
        return IdE;
    }

    public void setIdE(Integer IdE) {
        this.IdE = IdE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getMdpE() {
        return mdpE;
    }

    public void setMdpE(String mdpE) {
        this.mdpE = mdpE;
    }

    public Integer getSexeE() {
        return sexeE;
    }

    public void setSexeE(Integer sexeE) {
        this.sexeE = sexeE;
    }

    public Integer getNiveauE() {
        return niveauE;
    }

    public void setNiveauE(Integer niveauE) {
        this.niveauE = niveauE;
    }

    public void addNewEleve() {
        eleveDAO.create(monNouveauEleve);
    }

    public CoursFacadeLocal getCoursDAO() {
        return coursDAO;
    }

    public void setCoursDAO(CoursFacadeLocal coursDAO) {
        this.coursDAO = coursDAO;
    }

    public Cours getMonAncienCours() {
        return monAncienCours;
    }

    public void setMonAncienCours(Cours monAncienCours) {
        this.monAncienCours = monAncienCours;
    }

    public Cours getMonNouveauCours() {
        return monNouveauCours;
    }

    public void setMonNouveauCours(Cours monNouveauCours) {
        this.monNouveauCours = monNouveauCours;
    }

    public List<Eleve> getListEleve() {
        return listEleve;
    }

    public void setListEleve(List<Eleve> listEleve) {
        this.listEleve = listEleve;
    }

    public String getRecordIdCours() {
        return recordIdCours;
    }

    public void setRecordIdCours(String recordIdCours) {
        this.recordIdCours = recordIdCours;
    }

    public Integer getNumCours() {
        return numCours;
    }

    public void setNumCours(Integer numCours) {
        this.numCours = numCours;
    }
    
    public void editEleve() {
        monAncienEleve = eleveDAO.find(IdE);
        monAncienEleve.setAgeE(monNouveauEleve.getAgeE());
        monAncienEleve.setNiveauE(monNouveauEleve.getNiveauE());
        eleveDAO.edit(monAncienEleve);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful !! Modifications réalisés avec succès.  "));
    }
    
    public String redirectionAndRecordNum(Integer cours){
        setNumCours(cours);
        return "ReserverCours.xhtml?faces-redirect=true";
    }
    
    public String login() {
        List<Eleve> listEleveLogin = eleveDAO.findAll();
        FacesContext context = FacesContext.getCurrentInstance();
        if (nomE.equals("") || prenomE.equals("") || mdpE.equals("")){
            nomE="";
            prenomE="";
            mdpE="";
            return null;
        } else {
            for (Eleve eleve : listEleveLogin){
                 if((eleve.getNomE().equals(nomE)) && (eleve.getPrenomE().equals(prenomE)) && (eleve.getMdpE().equals(mdpE))){
                     context.addMessage(null, new FacesMessage("Authentificaiton réussi"));
                     monAncienCours = coursDAO.find(numCours);
                     monAncienCours.setIdE(eleve);
                     coursDAO.edit(monAncienCours);
                     return "index.xhtml?faces-redirect=true";
                 }
            }
        context.addMessage(null, new FacesMessage("id cours" + recordIdCours));
        context.addMessage(null, new FacesMessage("Mot de passe ou login invalide, veuillez réessayer"));    
        return null;
        }
    }
}
