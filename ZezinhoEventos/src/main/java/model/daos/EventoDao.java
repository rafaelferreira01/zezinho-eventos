/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.cliente.Cliente;
import static model.daos.BaseDao.getConexao;
import model.evento.Evento;

/**
 *
 * @author Leonardo
 */
public class EventoDao extends BaseDao {
    
    public static List<Evento> buscarTodosEventos() {

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
    
    public static Evento buscarUltimoIdEnento() {

        Query q = getConexao().createQuery("SELECT MAX(e.idEvento) FROM Evento e");
         
        return (Evento) q.getSingleResult();

    }
    
    

    public static List<Evento> buscarEventosFiltro(String nome, String dei, String def) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
         Query q = getConexao().createQuery("SELECT e FROM Evento e WHERE e.nomeEvento LIKE :nome AND"
                + "(e.dataEvento >= :dei and e.dataEvento <= :def )");
          

       
       q.setParameter("nome","%" + nome + "%");
       
       try {
            q.setParameter("dei", sdf.parse(dei));
        } catch (ParseException ex) {
            try {
                q.setParameter("dt1", sdf.parse("1500-01-01"));
            } catch (ParseException ex1) {
            }
        }

        try {
          
            q.setParameter("def", sdf.parse(def));
        } catch (ParseException ex) {
            q.setParameter("def", new Date());
        }

        return q.getResultList();

    
        
 //   }
    
    
    } 

    public static List<Evento> buscarEventosFiltro(String nome) {
        
         Query q = getConexao().createQuery("SELECT e FROM Evento e WHERE e.nomeEvento LIKE :nome");
         
         q.setParameter("nome","%" + nome + "%");
         
          return q.getResultList();
    }
}
