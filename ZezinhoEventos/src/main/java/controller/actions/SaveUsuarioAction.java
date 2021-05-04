/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actions;

import controller.commander.GenericCommander;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.daos.UsuarioDao;
import model.usuario.Usuario;

/**
 *
 * @author Leonardo
 */
public class SaveUsuarioAction extends GenericCommander {

    public SaveUsuarioAction(boolean estaLogado) {
        super(estaLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
           Usuario user = new Usuario(0, 
                request.getParameter("cpNome"), 
                request.getParameter("cpLogin"), 
                request.getParameter("cpSenha"));
        
        if ( UsuarioDao.existeLogin(user) ){            
            request.setAttribute("mensagemErro", "Usuário já existe no sistema");
            
            user.setLogin("");
            request.setAttribute("usuario", user);
            
            
           new ViewCadastroAction(false).executa(request, response);            
        }else{        
        
            UsuarioDao.getConexao().getTransaction().begin();
            UsuarioDao.getConexao().persist(user);
            UsuarioDao.getConexao().getTransaction().commit();

            request.setAttribute("mensagem", "Usuário criado com sucesso!");

            new  ViewLoginAction(false).executa(request, response);
        }
    }
}
    

