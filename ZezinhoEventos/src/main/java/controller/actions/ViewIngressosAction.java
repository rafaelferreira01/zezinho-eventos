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
import model.daos.TipoEspacoDao;
import model.daos.TipoEventoDao;
import model.espaco.TipoEspaco;
import model.espaco.assento.Cadeira;
import model.evento.Evento;
import model.evento.TipoEvento;

/**
 *
 * @author suporte
 */
public class ViewIngressosAction extends GenericCommander {

    public ViewIngressosAction(boolean estaLogado) {
        super(estaLogado);
    }
    
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
      
      List<Cliente> clientes = null;
     // clientes = ClienteDao.buscarTodosClientes();
       clientes =  ClienteDao.buscarTodosClientes( (Cliente) request.getAttribute("cliente"));
      // MODIFICAÇÃO -  Alterado passando o cliente como parâmetro, se precisar fazer o buscarTodosClientes com parametro vazio
      
      //ASSENTOS
        int numVagaSalao = 500;
        int numCabine = 10;
        int numCadeira = 40;
        int numVagaEspecial = 20;

//        if (evento.getCapacidadeReduzida() == true) {
//            numVagaSalao = 250;
//            numCabine = 5;
//            numCadeira = 20;
//            numVagaEspecial = 10;
//        }

        


            
//        List<Cadeira> cadeiras = null;
//        Cadeira cadeira;
//        for(int i = 1; i <= numCadeira; i++){
//             cadeira = new Cadeira(i,
//                    val,
//                    espaco,
//                    evento)
//            
//            
//                    
//                    
//        }
      
      
      
      
      
      
      
//                    for (int i = 1; i <= numCadeira; i++) {
//                        CadeiraDao.getConexao().getTransaction().begin();
//
//                        cadeira = new Cadeira(0,
//                                Double.parseDouble(request.getParameter("cpValorCadeira")),
//                                espaco,
//                                evento);
//
//                        CadeiraDao.getConexao().persist(cadeira);
//                        CadeiraDao.getConexao().getTransaction().commit();
//                    }
      
      
      
      request.setAttribute("clientes", clientes );
//      request.setAttribute("eventos", eventos);
      request.setAttribute("page", "/pages/outros/vendaIngressos.jsp");
      
      rd.forward(request, response);
    }
    
}
