
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
import model.daos.EventoDao;
import model.evento.Evento;

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
      
       Cliente cliente = new Cliente();
     
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
       
      // request.setAttribute("eventos", EventoDao.buscarTodosEventos());
       
        request.setAttribute("page", "/pages/listagens/listagemClientes.jsp");
       
      
       
       
     
      
       List<Cliente> clientes = null;
       if (request.getParameter("cpSearchNomeCliente") == null)
       {
          clientes =  ClienteDao.buscarTodosClientes( (Cliente) request.getAttribute("cliente"));
       }
       else
       {    
           
           // Evento evento = new Evento(Integer.parseInt(request.getParameter("cpSearchEvento")));
           // String cpf = request.getParameter("cpSearchCPF");
           // clientes =  ClienteDao.buscarClientesFiltro(request.getParameter("cpSearchNomeCliente"),cpf,evento);
            clientes =  ClienteDao.buscarClientesFiltro(request.getParameter("cpSearchNomeCliente"));
            
          

       }
       
   request.setAttribute("clientes", clientes);
   
   
      
   
   
     
    rd.forward(request, response);
    }
    
}
