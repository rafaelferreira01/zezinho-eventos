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
public class VagaEspecialDao extends BaseDao {
    
    public static List<VagaEspecialDao> buscarTodasCabines() {

        Query q = getConexao().createNamedQuery("VagaEspecial.findAll");
        
        return q.getResultList();        
    }


    public static VagaEspecialDao buscarByIdVagaEspecial(int id) {

        Query q = getConexao().createNamedQuery("VagaEspecial.findByIdVagaEspecial");

        q.setParameter("idVagaEspecial", id);
        try {
            
            return (VagaEspecialDao) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    
}
