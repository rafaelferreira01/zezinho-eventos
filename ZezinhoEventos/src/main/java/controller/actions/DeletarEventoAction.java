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
import model.daos.EventoDao;
import model.evento.Evento;


/**
 *
 * @author Leonardo
 */
public class DeletarEventoAction extends GenericCommander {

    public DeletarEventoAction(boolean estaLogado) {
        super(estaLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         String id = request.getParameter("id");
       
        
       
        EventoDao.getConexao().getTransaction().begin();
        
        Evento evento = EventoDao.getConexao().find(Evento.class,Integer.parseInt(id));
        
        EventoDao.getConexao().remove(evento);
        EventoDao.getConexao().getTransaction().commit();
        
        
       
        response.sendRedirect("control?ac=listaEventos");
    }
    
}
