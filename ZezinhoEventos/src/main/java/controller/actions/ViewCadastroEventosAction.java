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
import model.daos.EspacoDao;
import model.daos.TipoEventoDao;
import model.espaco.Espaco;
import model.evento.TipoEvento;

/**
 *
 * @author Leonardo
 */
public class ViewCadastroEventosAction extends GenericCommander {

    public ViewCadastroEventosAction(boolean estaLogado) {
        super(estaLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
      
      List<TipoEvento> tipoEventos = null;
      tipoEventos = TipoEventoDao.buscarTodosTipoEventos();
      
      List<Espaco> espacos = null;
      espacos = EspacoDao.buscarTodosEspacos();
      
      request.setAttribute("espacos", espacos );
      request.setAttribute("tipoEventos", tipoEventos);
      request.setAttribute("page", "/pages/cadastro/cadastroEventos.jsp");
      
      rd.forward(request, response);
    }
    
}
