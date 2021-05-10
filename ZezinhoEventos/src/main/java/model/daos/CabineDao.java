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
import model.espaco.assento.Cabine;
import model.espaco.assento.Cadeira;
import model.evento.Evento;

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
    public static List<Cabine> buscarTodasCabinesByEvento(Evento evento, Espaco espaco) {

        Query q = getConexao().createQuery("SELECT c FROM Cabine c WHERE c.espaco.idespaco = :espaco and c.espaco.evento.idEvento = :evento");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return (List<Cabine>) q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
