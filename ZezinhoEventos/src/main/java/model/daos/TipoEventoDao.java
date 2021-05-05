/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.cliente.Cliente;
import static model.daos.BaseDao.getConexao;
import model.evento.TipoEvento;

/**
 *
 * @author Leonardo
 */
public class TipoEventoDao extends BaseDao {
    
    public static List<TipoEvento> buscarTodosTipoEventos() {

        Query q = getConexao().createNamedQuery("TipoEvento.findAll");
        
        return q.getResultList();        
    }


    public static TipoEvento buscarByIdTipoEvento(int id) {

        Query q = getConexao().createNamedQuery("TipoEvento.findByIdTipoEvento");

        q.setParameter("idTipoEvento", id);
        try {
            
            return (TipoEvento) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    
}
