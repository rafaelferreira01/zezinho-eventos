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
import model.espaco.assento.VagaEspecial;
import model.evento.Evento;

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
    
    public static List<VagaEspecial> buscarTodasVagaEspecialByEvento(Evento evento, Espaco espaco) {

        Query q = getConexao().createQuery("SELECT c FROM VagaEspecial c WHERE c.espaco.idespaco = :espaco and c.espaco.evento.idEvento = :evento");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return (List<VagaEspecial>) q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    
    public static List<VagaEspecial> buscarTodasVagaEspecialGratisByEvento(Evento evento, Espaco espaco) {

        Query q = getConexao().createQuery("SELECT c FROM VagaEspecial c WHERE c.espaco.idespaco = :espaco and c.espaco.evento.idEvento = :evento and c.ehpgalimento = true");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return (List<VagaEspecial>) q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static List<VagaEspecial> buscarTodasVagaEspecialMeiaEntradaByEvento(Evento evento, Espaco espaco) {

        Query q = getConexao().createQuery("SELECT c FROM VagaEspecial c WHERE c.espaco.idespaco = :espaco and c.espaco.evento.idEvento = :evento and (c.ehpgalimento = false and c.ehmeiaentrada = true)");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return (List<VagaEspecial>) q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static List<VagaEspecial> buscarTodasVagaEspecialInteiraByEvento(Evento evento, Espaco espaco) {

        Query q = getConexao().createQuery("SELECT c FROM VagaEspecial c WHERE c.espaco.idespaco = :espaco and c.espaco.evento.idEvento = :evento and (c.ehpgalimento = false and c.ehmeiaentrada = false)");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return (List<VagaEspecial>) q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
    
    
}
