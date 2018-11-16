/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author felix
 */
@Named(value = "vueEleve")
@SessionScoped
public class vueEleve implements Serializable {

    /**
     * Creates a new instance of vueEleve
     */
    public vueEleve() {
    }
    
}
