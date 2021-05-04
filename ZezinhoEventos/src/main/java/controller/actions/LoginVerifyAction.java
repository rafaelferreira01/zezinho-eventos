/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actions;

import controller.commander.GenericCommander;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.daos.UsuarioDao;
import model.usuario.Usuario;

/**
 *
 * @author Leonardo
 */
public class LoginVerifyAction extends GenericCommander {


    public LoginVerifyAction(boolean isLogado) {
        super(isLogado);
    }

     @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{

      
      
             try {
            String email = request.getParameter("cpLogin");
            String senha = request.getParameter("cpSenha");
            
            Usuario u = new UsuarioDao().verificarUsuario(email, senha);
                        
            if ( u != null  ) {
                
                request.getSession().setAttribute("usuario", u);
                
                new ViewHomeLogadoAction(true).executa(request,response);
            
            } else {
                response.sendRedirect("control?error=1");
            }
        } catch (SQLException ex) {
            throw new ServerException(ex.getMessage());
        }
    }
}
                        
          

    



        
    
        

    



        
        
        
        
    

   //String login = request.getParameter("cpLogin");
   //     String senha = request.getParameter("cpSenha");
   //     if (login.equals("zezin@zezin") && senha.equals("123")) {
   //         response.sendRedirect("layout.jsp");
   //    } else {
    //        response.sendRedirect("login.jsp?error=1");
    //    }
