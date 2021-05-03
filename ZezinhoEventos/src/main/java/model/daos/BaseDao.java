/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daves
 */
public class BaseDao  {
    
    private static EntityManagerFactory emf; // = Persistence.createEntityManagerFactory("matadorPU");
        
    private static EntityManager conexao; // = emf.createEntityManager();
    
    public static void close(){
        if (conexao.isOpen()){
            conexao.close();
        }
    }
    
    public static EntityManager getConexao(){
        if (conexao == null || !conexao.isOpen()){
           emf = Persistence.createEntityManagerFactory("eventosPU");
           conexao = emf.createEntityManager();
        }
        return conexao;
    }
        
}
