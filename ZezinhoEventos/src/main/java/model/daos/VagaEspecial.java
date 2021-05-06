/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import static model.daos.BaseDao.getConexao;

/**
 *
 * @author Leonardo
 */
public class VagaEspecial extends BaseDao {
    
    public static List<VagaEspecial> buscarTodasCabines() {

        Query q = getConexao().createNamedQuery("VagaEspecial.findAll");
        
        return q.getResultList();        
    }


    public static VagaEspecial buscarByIdVagaEspecial(int id) {

        Query q = getConexao().createNamedQuery("VagaEspecial.findByIdVagaEspecial");

        q.setParameter("idVagaEspecial", id);
        try {
            
            return (VagaEspecial) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    
}
