
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
 * @author Leonardo
 */
public class ViewListaClientesAction extends GenericCommander {

    public ViewListaClientesAction(boolean estaLogado) {
        super(estaLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
       
       request.setAttribute("page", "/pages/listagens/listagemClientes.jsp");
      
       List<Cliente> clientes = null;
       if (request.getParameter("cpSearchNomeCliente") == null)
       {
           request.setAttribute("clientes", ClienteDao.buscarTodosClientes());
       }
       else
       {
       //      request.setAttribute("clientes", ClienteDao.buscarClientesFiltro());
       }
       
    
      
      rd.forward(request, response);
    }
    
}
