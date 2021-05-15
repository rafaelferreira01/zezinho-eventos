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
import model.daos.EventoDao;
import model.daos.TipoEspacoDao;
import model.daos.TipoEventoDao;
import model.espaco.Espaco;
import model.espaco.TipoEspaco;
import model.evento.Evento;
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
      
      List<TipoEspaco> espacos = null;
      espacos = TipoEspacoDao.buscarTodosTiposEspacos();
      
      
        String titulo;
        
        Espaco espaco = new Espaco();
        
        Evento evento = new Evento();
        
        
      
        if (request.getParameter("id") != null) {//cpf que estava no campo
            titulo = "Alterar Evento";
            evento = EventoDao.buscarByIdEvento(Integer.parseInt(request.getParameter("id")));
            espaco = EspacoDao.buscarByEvento(evento);
        } else {
            titulo = "Novo Evento";
        }
        
        
        
        
//       request.getParameter("cpNomeEvento")
//       sdf.parse(request.getParameter("cpDataEvento")),
//       Boolean.parseBoolean(request.getParameter("CpCapacidadeReduzida") != null ? "true" : "false"),
//       Double.parseDouble(request.getParameter("cpCustoExtra")),
//       Double.parseDouble(request.getParameter("cpCustoInicial")),
//       Boolean.parseBoolean(request.getParameter("CpaceitaMeiaEntrada") != null ? "true" : "false"),
//                        
//        
//        request.setAttribute("cpSearchNomeEvento", request.getParameter("cpNomeEvento"));//
//        request.setAttribute("cpDataInicio", request.getParameter("cpDataEvento"));//
//        
//        request.setAttribute("cpTipoEvento", request.getParameter("cpTipoEvento"));//
//        
//        request.setAttribute("cpEspacoEvento", request.getParameter("cpEspacoEvento"));
      
        request.setAttribute("evento", evento );
        request.setAttribute("espaco", espaco );
        
        
        request.setAttribute("espacos", espacos );
        request.setAttribute("tipoEventos", tipoEventos);
        request.setAttribute("page", "/pages/cadastro/cadastroEventos.jsp");
      
      rd.forward(request, response);
    }
    
}
