/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.EleveFacadeLocal;
import dao.ProfFacadeLocal;
import entity.Eleve;
import entity.Prof;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Julien
 */
@Named(value = "vueIndex")
@SessionScoped
public class VueIndex implements Serializable {

    @EJB
    EleveFacadeLocal eleveDAO;
    @EJB
    ProfFacadeLocal profDAO;
    private Eleve student;
    private Prof teacher;
    
    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "EASTER EGG !!!", " 23 à 0 ! C'est la piquette Jack ! Tu sais pas jouer Jack ! T'es mauvais !");         
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    /**
     * Constructor  */
    public VueIndex() {
    }
}