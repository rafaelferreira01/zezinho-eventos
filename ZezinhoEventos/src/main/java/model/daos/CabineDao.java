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
import model.espaco.assento.Cabine;

/**
 *
 * @author Leonardo
 */
public class CabineDao extends BaseDao {
    
    public static List<Cabine> buscarTodasCabines() {

        Query q = getConexao().createNamedQuery("Cabine.findAll");
        
        return q.getResultList();        
    }


    public static Cabine buscarByIdCabine(int id) {

        Query q = getConexao().createNamedQuery("Cabine.findByIdCabine");

        q.setParameter("idCabine", id);
        try {
            
            return (Cabine) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    
}
