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
import model.daos.EventoDao;
import model.evento.Evento;

/**
 *
 * @author Leonardo
 */
public class ViewListaEventosAction extends GenericCommander {

    public ViewListaEventosAction(boolean estaLogado) {
        super(estaLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
      
         request.setAttribute("page", "/pages/listagens/listagemEventos.jsp");
      
    //  List<TipoEvento> tipoEventos = null;
    //  tipoEventos = TipoEventoDao.buscarTodosTipoEventos();
      
     
      //request.setAttribute("espacos", EspacoDao.buscarTodosEspacos() );
     // request.setAttribute("tipoEventos", tipoEventos);
         
            List<Evento> eventos = null;
       if (request.getParameter("cpSearchNomeEvento") == null)
       {
           request.setAttribute("eventos", EventoDao.buscarTodosEventos());
       }
       else
       {
       //      request.setAttribute("clientes", ClienteDao.buscarClientesFiltro());
       }

      rd.forward(request, response);
     

      
    }
    
}
