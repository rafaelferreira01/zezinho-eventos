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

/**
 *
 * @author daves
 */
public class ClienteDao extends BaseDao {
    
    public static List<Cliente> buscarTodosClientes() {

        Query q = getConexao().createNamedQuery("Cliente.findAll");
        
        return q.getResultList();        
    }


    public static Cliente buscarByCPF(int cpf) {

        Query q = getConexao().createNamedQuery("Cliente.findByCpf");

        q.setParameter("cpf", cpf);
        try {
            
            return (Cliente) q.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }

}
