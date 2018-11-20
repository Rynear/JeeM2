/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.EleveFacadeLocal;
import entity.Eleve;
import entity.Prof;
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
    private Eleve monEleve;
    private Eleve monNouveauEleve;
    private Eleve monAncienEleve;
    private Integer IdE;
    private String nomE;
    private String prenomE;
    private String mdpE;
    private Integer sexeE;
    private Integer niveauE;
    
            
    /**
     * Creates a new instance of vueEleve
     */
    public VueEleve() {
        monEleve = new Eleve();
        monNouveauEleve = new Eleve();
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
    
    public List<Eleve> getListeEleve() {
    return eleveDAO.findAll();
    }

    public void editEleve(){
      monAncienEleve = eleveDAO.find(IdE);
      monAncienEleve.setAgeE(monNouveauEleve.getAgeE());
      monAncienEleve.setNiveauE(monNouveauEleve.getNiveauE());
      eleveDAO.edit(monAncienEleve);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful !! Modifications réalisés avec succès.  "));
    }
    public String login() {
        Eleve eleve = eleveDAO.find(monEleve.getMdpE());
        FacesContext context = FacesContext.getCurrentInstance();

        if (eleve == null) {
            context.addMessage(null, new FacesMessage("Login inconnu, veuillez réessayer"));
            monEleve.setNomE("");
            monEleve.setPrenomE("");
            monEleve.setMdpE("");
            return null;
        } else {
            if (eleve.getMdpE().equals(monEleve.getMdpE())){
                context.getExternalContext().getSessionMap().put("Eleve ", eleve);
                return "index?faces-redirect=true";
            }
            else{
                context.addMessage(null, new FacesMessage("Mot de passe invalide, veuillez réessayer"));
                return null;
            }
        }
    }
    
}
