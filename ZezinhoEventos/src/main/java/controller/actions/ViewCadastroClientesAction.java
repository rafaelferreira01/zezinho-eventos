/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actions;

import controller.commander.GenericCommander;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.cliente.Cliente;
import model.daos.ClienteDao;

/**
 *
 * @author suporte
 */
public class ViewCadastroClientesAction extends GenericCommander {

    public ViewCadastroClientesAction(boolean b) {
        super(b);
    }
    
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
        
        String titulo;
        Cliente cBusca = new Cliente();

        if (request.getParameter("cpf")!=null){//cpf que estava no campo
            titulo = "Alterar Cliente";
            cBusca = ClienteDao.buscarByCPF( Integer.parseInt(request.getParameter("cpf")) );//cpf que estava no campo
        }else{
            titulo = "Novo Cliente";
        }                
        
        request.setAttribute("cliente", cBusca);
        request.setAttribute("titulo", titulo);
        request.setAttribute("page", "/pages/cadastro/cadastroClientes.jsp");
        rd.forward(request, response);
    }
    
}
