/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.evento.EventoCliente;
import static model.daos.BaseDao.getConexao;
import model.evento.TipoEvento;

/**
 *
 * @author Leonardo
 */
public class EventoClienteDao extends BaseDao {
    
    public static List<EventoCliente> buscarTodosEventoClientes() {

        Query q = getConexao().createNamedQuery("EventoCliente.findAll");
        
        return q.getResultList();        
    }


    public static TipoEvento buscarByIdEventoCliente(int id) {

        Query q = getConexao().createNamedQuery("EventoCliente.findByIdEventoCliente");

        q.setParameter("idEventoCliente", id);
        try {
            
            return (TipoEvento) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    
}
