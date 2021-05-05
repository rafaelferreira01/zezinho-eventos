/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.util.List;
import javax.persistence.Query;
import model.cliente.Cliente;
import static model.daos.BaseDao.getConexao;
import model.evento.Evento;

/**
 *
 * @author Leonardo
 */
public class EventoDao extends BaseDao {
    
    public static List<Evento> buscarTodoEventos() {

        Query q = getConexao().createNamedQuery("Evento.findAll");
        
        return q.getResultList();        
    }


    public static Evento buscarByIdEvento(int id) {

        Query q = getConexao().createNamedQuery("Evento.findByIdEvento");

        q.setParameter("idEvento", id);
        try {
            
            return (Evento) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    
}
