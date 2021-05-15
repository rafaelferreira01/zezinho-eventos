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
import model.espaco.assento.VagaSalao;
import model.evento.Evento;
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
    
    public static List<VagaSalao> buscarTodasVagaSalaoByEvento(Evento evento, Espaco espaco) {

        Query q = getConexao().createQuery("SELECT c FROM VagaSalao c WHERE c.espaco.idespaco = :espaco and c.espaco.evento.idEvento = :evento");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return (List<VagaSalao>) q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
    
    
    
    
    
    
    
    public static List<VagaSalao> buscarTodasVagaSalaoGratisByEvento(Evento evento, Espaco espaco) {

        Query q = getConexao().createQuery("SELECT c FROM VagaSalao c WHERE c.espaco.idespaco = :espaco and c.espaco.evento.idEvento = :evento and c.ehpgalimento = true");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return (List<VagaSalao>) q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static List<VagaSalao> buscarTodasVagaSalaoMeiaEntradaByEvento(Evento evento, Espaco espaco) {

        Query q = getConexao().createQuery("SELECT c FROM VagaSalao c WHERE c.espaco.idespaco = :espaco and c.espaco.evento.idEvento = :evento and (c.ehpgalimento = false and c.ehmeiaentrada = true)");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return (List<VagaSalao>) q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static List<VagaSalao> buscarTodasVagaSalaoInteiraByEvento(Evento evento, Espaco espaco) {

        Query q = getConexao().createQuery("SELECT c FROM VagaSalao c WHERE c.espaco.idespaco = :espaco and c.espaco.evento.idEvento = :evento and (c.ehpgalimento = false and c.ehmeiaentrada = false)");
        q.setParameter("evento", evento.getIdEvento());
        q.setParameter("espaco", espaco.getIdespaco());
        
        try {
            
            return (List<VagaSalao>) q.getResultList();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
