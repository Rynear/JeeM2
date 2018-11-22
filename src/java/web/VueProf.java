/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CoursFacadeLocal;
import dao.ProfFacadeLocal;
import entity.Cours;
import entity.Prof;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
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
    @EJB
    CoursFacadeLocal coursDAO;
    private Cours newCours;
    private Prof monProf;
    private Prof monNouveauProf;
    private Prof monAncienProf;
    private Integer IdP;
    private String nomP;
    private String prenomP;
    private String mdpP;
    private Integer sexeP;
    private Integer niveauMaxP;
    private Integer recordIdProf;
    private Cours Cours1;
    private Date dateNewCours;
    private String newComment;

    /**
     * Creates a new instance of VueProf
     */
    public VueProf() {
        monNouveauProf = new Prof();
        newCours = new Cours();
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

    public void addNewProf() {
        profDAO.create(monNouveauProf);
    }

    public List<Prof> getListeProf() {
        return profDAO.findAll();
    }

    public Integer getRecordIdProf() {
        return recordIdProf;
    }

    public void setRecordIdProf(Integer recordIdProf) {
        this.recordIdProf = recordIdProf;
    }

    public Date getDateNewCours() {
        return dateNewCours;
    }

    public void setDateNewCours(Date dateNewCours) {
        this.dateNewCours = dateNewCours;
    }

    public String getNewComment() {
        return newComment;
    }

    public void setNewComment(String newComment) {
        this.newComment = newComment;
    }
    
    
    
    
    
    public String loginPropoCours() {
        List<Prof> listProfLogin = profDAO.findAll();
        FacesContext context = FacesContext.getCurrentInstance();
        if (nomP.equals("") || prenomP.equals("") || mdpP.equals("")){
            nomP="";
            prenomP="";
            mdpP="";
            return null;
        } else {
            for (Prof prof : listProfLogin){
                 if((prof.getNomP().equals(nomP)) && (prof.getPrenomP().equals(prenomP)) && (prof.getMdpP().equals(mdpP))){
                     setRecordIdProf(prof.getIdP());
                     context.addMessage(null, new FacesMessage("Authentificaiton réussi"));
                     return "ProposerUnCours.xhtml?faces-redirect=true";
                 }
            }
        context.addMessage(null, new FacesMessage("Mot de passe ou login invalide, veuillez réessayer"));    
        return null;
        }
    }
    
    public String loginModifCours() {
        List<Prof> listProfLogin = profDAO.findAll();
        FacesContext context = FacesContext.getCurrentInstance();
        if (nomP.equals("") || prenomP.equals("") || mdpP.equals("")){
            nomP="";
            prenomP="";
            mdpP="";
            return null;
        } else {
            for (Prof prof : listProfLogin){
                 if((prof.getNomP().equals(nomP)) && (prof.getPrenomP().equals(prenomP)) && (prof.getMdpP().equals(mdpP))){
                     setRecordIdProf(prof.getIdP());
                     context.addMessage(null, new FacesMessage("Authentificaiton réussi"));
                     return "ModifProf.xhtml?faces-redirect=true";
                 }
            }
        context.addMessage(null, new FacesMessage("Mot de passe ou login invalide, veuillez réessayer"));    
        return null;
        }
    }
    
    public String createNewCours(){
        Prof pf = profDAO.find(getRecordIdProf());        
        newCours.setIdP(pf);
        newCours.setDateHeureC(dateNewCours);
        newCours.setCommentaireC(newComment);
        coursDAO.create(newCours);
        return "index.xhtml?faces-redirect=true";
    }
    
    public String editProf() {
        monAncienProf = profDAO.find(getRecordIdProf());
        monAncienProf.setNiveauMaxP(monNouveauProf.getNiveauMaxP());
        profDAO.edit(monAncienProf);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful !! Modifications réalisés avec succès.  "));
        return "index.xhtml?faces-redirect=true";
    }
}
