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
import model.espaco.Espaco;
import model.espaco.TipoEspaco;

/**
 *
 * @author Leonardo
 */
public class TipoEspacoDao extends BaseDao {
    
    public static List<TipoEspaco> buscarTodosTiposEspacos() {

        Query q = getConexao().createNamedQuery("TipoEspaco.findAll");
        
        return q.getResultList();        
    }


    public static TipoEspaco buscarByIdTipoEspaco(int id) {

        Query q = getConexao().createNamedQuery("TipoEspaco.findByIdTipoEspaco");

        q.setParameter("idTipoEspaco", id);
        try {
            
            return (TipoEspaco) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    
}
