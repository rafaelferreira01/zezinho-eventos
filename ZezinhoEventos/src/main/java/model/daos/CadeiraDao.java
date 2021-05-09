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
import model.espaco.assento.Cadeira;
import model.evento.Evento;
import model.espaco.Espaco;

/**
 *
 * @author Leonardo
 */
public class CadeiraDao extends BaseDao {
    
    public static List<Cadeira> buscarTodasCadeiras() {

        Query q = getConexao().createNamedQuery("Cadeira.findAll");
        
        return q.getResultList();        
    }
    
//    public static List<Cadeira> buscarTodasCadeirasByEvento(Evento evento) {
//
//        Query q = getConexao().createQuery("SELECT c FROM Cadeira c WHERE c.descricao = :descricao and (c.evento.idevento = evento:)");
//        
//        q.setParameter("evento", evento.getIdEvento());
//        
//        return (List<Cadeira>) q.getResultList();       
//
//    }
//     and (c.espaco.evento.idEvento = evento:)
    public static List<Cadeira> buscarTodasCadeirasByEvento(Evento evento, Espaco espaco) {

//        Query q = getConexao().createQuery("SELECT c FROM Cadeira c WHERE c.espaco.idespaco = :espaco");
        
        Query q = getConexao().createQuery("SELECT c FROM Cadeira c, Espaco e WHERE c.espaco.idespaco = :espaco and e.evento.idEvento = evento:");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }


    public static Cadeira buscarByIdCadeira(int id) {

        Query q = getConexao().createNamedQuery("Cadeira.findByIdCadeira");

        q.setParameter("idCadeira", id);
        try {
            
            return (Cadeira) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    
//    public static List<Cadeira> buscarCadeirasLivres(Evento evento) {
//
//        Query q = getConexao().createQuery("SELECT MAX(e.idEvento) FROM Evento e");
//
//        try {
//
//            return q.getResultList();
//
//        } catch (NoResultException e) {
//            return null;
//        }
//    }

}
