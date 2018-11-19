/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.ProfFacade;
import dao.ProfFacadeLocal;
import entity.Prof;
import entity.Prof_;
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
@Named(value = "vueProf")
@SessionScoped
public class VueProf implements Serializable {

    
    @EJB
    ProfFacadeLocal profDAO;
    private Prof monProf;
    private Prof monNouveauProf;
    private Prof monAncienProf;
    private Integer IdP;
    private String nomP;
    private String prenomP;
    private String mdpP;
    private Integer sexeP;
    private Integer niveauMaxP;
    
    /**
     * Creates a new instance of VueProf
     */
    public VueProf() {
        monNouveauProf = new Prof();
    }

    public ProfFacadeLocal getProfDAO() {
        return profDAO;
    }

    public void setProfDAO(ProfFacadeLocal profDAO) {
        this.profDAO = profDAO;
    }

    public Prof getMonProf() {
        return monProf;
    }

    public void setMonProf(Prof monProf) {
        this.monProf = monProf;
    }

    public Integer getIdP() {
        return IdP;
    }

    public void setIdP(Integer IdP) {
        this.IdP = IdP;
    }
    public Prof getMonNouveauProf() {
        return monNouveauProf;
    }

    public void setMonNouveauProf(Prof monNouveauProf) {
        this.monNouveauProf = monNouveauProf;
    }

    public Prof getMonAncienProf() {
        return monAncienProf;
    }

    public void setMonAncienProf(Prof monAncienProf) {
        this.monAncienProf = monAncienProf;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public String getMdpP() {
        return mdpP;
    }

    public void setMdpP(String mdpP) {
        this.mdpP = mdpP;
    }

    public Integer getSexeP() {
        return sexeP;
    }

    public void setSexeP(Integer sexeP) {
        this.sexeP = sexeP;
    }

    public Integer getNiveauMaxP() {
        return niveauMaxP;
    }

    public void setNiveauMaxP(Integer niveauMaxP) {
        this.niveauMaxP = niveauMaxP;
    }
    
    public void addNewProf(){
        profDAO.create(monNouveauProf);
    }
    
    public List<Prof> getListeProf() {
    return profDAO.findAll();
    }

    public void editProf(){
      monAncienProf = profDAO.find(IdP);
      monAncienProf.setNomP(monNouveauProf.getNomP());
      monAncienProf.setNiveauMaxP(monNouveauProf.getNiveauMaxP());
      profDAO.edit(monAncienProf);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful !! Modifications réalisés avec succès.  "));
    }
    
}