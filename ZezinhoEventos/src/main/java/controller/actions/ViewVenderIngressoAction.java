/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actions;

import controller.commander.GenericCommander;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.cliente.Cliente;
import model.daos.CadeiraDao;
import model.daos.ClienteDao;
import model.daos.EspacoDao;
import model.daos.EventoDao;
import model.espaco.Espaco;
import model.espaco.assento.Cadeira;
import model.evento.Evento;

/**
 *
 * @author Leonardo
 */
public class ViewVenderIngressoAction extends GenericCommander {

    public ViewVenderIngressoAction(boolean estaLogado) {
        super(estaLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
      
        Evento evento = EventoDao.buscarByIdEvento(Integer.parseInt(request.getParameter("id")));
        Espaco espaco = EspacoDao.buscarByEvento(evento.getIdEvento());
        double valorCadeira = espaco.getValorCadeira();
        double valorCabine = espaco.getValorCabine();
        double valorVagaSalao = espaco.getValorVagaSalao();
        double valorVagaEspecial = espaco.getValorVagaEspecial();
        
        
        List<Cliente> clientes = null;
        clientes = ClienteDao.buscarTodosClientes();
        
        int numVagaSalao = 500;
        int numCabine = 10;
        int numCadeira = 40;
        int numVagaEspecial = 20;
        
        if(evento.getCapacidadeReduzida()){//se for capacidade reduzida
            numVagaSalao = 100;
            numCabine = 5;
            numCadeira = 20;
            numVagaEspecial = 10;
        }
        
        //
        List<Cadeira> cadeirasTotal = new ArrayList<Cadeira>();//lista com todas cadeiras do evento, ocupadas ou não
        Cadeira cadeira = new Cadeira();
        for (int i = 1; i <= numCadeira; i++) {//
            cadeira.setDescricao("CA"+i);
            cadeirasTotal.add(cadeira);
        }
        
         List<Cadeira> cadeirasOcupadas = CadeiraDao.buscarTodasCadeirasByEvento(evento.getIdEvento());//lista de cadeiras ocupadas
//        List<Cadeira> cadeirasOcupadas = CadeiraDao.buscarTodasCadeirasByEvento(evento);//lista de cadeiras ocupadas
        

        List<Cadeira> cadeirasDisponivels = new ArrayList<Cadeira>();//cadeiras ainda disponiveis (nao reservadas)
        
        
        //VER SE ASSENTO ESTA OCUPADO
        for (int i = 0; i < cadeirasTotal.size(); i++) {//para todos os itens da lista total faça
            for (int j = 0; j < cadeirasOcupadas.size(); j++) {//para todos os itens da lista de cadeiras ocupadas faça
                if (!cadeirasTotal.get(i).getDescricao().equals(cadeirasOcupadas.get(j).getDescricao())) {
                    cadeirasDisponivels.add(cadeirasTotal.get(i));
                }
            }         
        }

        
        
        
        request.setAttribute("cadeirasDisponivels", cadeirasDisponivels);
        request.setAttribute("clientes", clientes);

        request.setAttribute("page", "/pages/outros/vendaIngressos.jsp");

         rd.forward(request, response);
    }
    
}
