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
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author felix
 */
@Named(value = "vueChoixCoursParNiveaux")
@Dependent
public class vueChoixCoursParNiveaux {

    @EJB
    CoursFacadeLocal coursDAO;
    @EJB
    ProfFacadeLocal profDAO;
    private List<Cours> listCours;
    private List<Prof> listProf;
    
    public vueChoixCoursParNiveaux() {
    }
    
}
