/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Prof;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author felix
 */
@Stateless
public class ProfFacade extends AbstractFacade<Prof> implements ProfFacadeLocal {

    @PersistenceContext(unitName = "JeeM2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfFacade() {
        super(Prof.class);
    }
    
}
