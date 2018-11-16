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
import javax.ejb.EJB;

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
    /**
     * Constructor  */
    public VueIndex() {
    }
}