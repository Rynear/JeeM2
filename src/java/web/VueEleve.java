/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.EleveFacadeLocal;
import entity.Eleve;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author felix
 */
@Named(value = "vueEleve")
@SessionScoped
public class VueEleve implements Serializable {

    @EJB
    EleveFacadeLocal monEDAO;
    Eleve monEleve;
    private String nomEleve;
    private String prenomEleve;
    private Integer sexeEleve;
    private Integer ageEleve;
    private Integer niveauEleve;
    private String mdpEleve;

    public VueEleve() {
        monEleve = new Eleve();
    }

    public EleveFacadeLocal getMonEDAO() {
        return monEDAO;
    }

    public void setMonEDAO(EleveFacadeLocal monEDAO) {
        this.monEDAO = monEDAO;
    }

    public Eleve getMonEleve() {
        return monEleve;
    }

    public void setMonEleve(Eleve monEleve) {
        this.monEleve = monEleve;
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
    
    public void addEleve() {
        monEDAO.create(monEleve);
    }
}
