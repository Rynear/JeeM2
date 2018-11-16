/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Prof;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author felix
 */
@Local
public interface ProfFacadeLocal {

    void create(Prof prof);

    void edit(Prof prof);

    void remove(Prof prof);

    Prof find(Object id);

    List<Prof> findAll();

    List<Prof> findRange(int[] range);

    int count();
    
}
