/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Eleve;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author felix
 */
@Stateless
public class EleveFacade extends AbstractFacade<Eleve> implements EleveFacadeLocal {

    @PersistenceContext(unitName = "JeeM2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EleveFacade() {
        super(Eleve.class);
    }
    
}
