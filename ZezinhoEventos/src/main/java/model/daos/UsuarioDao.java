/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.sql.SQLException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import model.usuario.Usuario;

/**
 *
 * @author Leonardo
 */
public class UsuarioDao extends BaseDao {
    
       public Usuario verificarUsuario(String login, String senha) throws SQLException{
        
      Query q = getConexao().createNamedQuery("Usuario.findByLoginAndSenha");
        
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        
        try {
            
            return (Usuario) q.getSingleResult(); 
        
        } catch (NonUniqueResultException e) {
            throw new SQLException("foi encontrado 2 usuários no banco, contate o administrador");
           //return (Usuario) q.getResultList().get(0);
        } catch (NoResultException e){
            return null;

    
        }
      }
        public static boolean existeLogin(Usuario user) {
        Query q = getConexao().createQuery("select count(u) from Usuario u where u.login = :login ");
        
        q.setParameter("login", user.getLogin());
        
         return (long)q.getSingleResult() >= 1; 
    }
        
    
}
     
