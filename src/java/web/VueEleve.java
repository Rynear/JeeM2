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
    EleveFacadeLocal eleveDAO;
    private Eleve monEleve;
    private Eleve monNouveauEleve;
    private Eleve monAncienEleve;
    private String nomE;
    private String prenomE;
    private String mdpE;
    private Integer sexeE;
    private Integer niveauE;
    
            
    /**
     * Creates a new instance of vueEleve
     */
    public VueEleve() {
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
    
}
