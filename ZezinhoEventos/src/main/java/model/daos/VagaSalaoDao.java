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
import model.espaco.assento.VagaSalao;
/**
 *
 * @author Leonardo
 */
public class VagaSalaoDao extends BaseDao {
    
    public static List<VagaSalao> buscarTodasVagaSalao() {

        Query q = getConexao().createNamedQuery("VagaSalao.findAll");
        
        return q.getResultList();        
    }


    public static VagaSalao buscarByIdVagaSalaoDao(int id) {

        Query q = getConexao().createNamedQuery("VagaSalao.findByIdVagasalao");

        q.setParameter("idVagasalao", id);
        try {
            
            return (VagaSalao) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    
}
