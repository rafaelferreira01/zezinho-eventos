/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roda.testes.banco;

import model.usuario.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daves
 */
public class TestaBanco {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventosPU");
        
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Conectou ");
        
        //criaRegistros(em);
        

        Usuario u = new Usuario(0, "Rafael", "rafa", "123");
        
        em.getTransaction().begin();
        
        em.persist(u);
        
        em.getTransaction().commit();
        
//        
//        Query q1 = em.createQuery("SELECT u FROM Usuario u where "
//                + " u.timeList.size = 1 order by u.nome ");
//        
//        long total = (long) q1.getSingleResult();
//        System.out.println(" total de times  "+total);
        
//        List<Time> lista1 = (List<Time>) q1.getResultList();
//        for (Time t : lista1) {
//            System.out.println("2 --> "+t.getNome());
//        }
                                
        
        
    }

    
}
