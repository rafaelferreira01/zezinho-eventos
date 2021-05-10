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
import model.daos.CabineDao;
import model.daos.VagaEspecialDao;
import model.daos.VagaSalaoDao;
import model.daos.EventoDao;
import model.espaco.Espaco;
import model.espaco.assento.Cadeira;
import model.espaco.assento.Cabine;
import model.espaco.assento.VagaEspecial;
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

        List<Cliente> clientes = null;
        clientes = ClienteDao.buscarTodosClientes();

        Evento evento;
        evento = EventoDao.buscarByIdEvento(Integer.parseInt(request.getParameter("id")));
        
        String titulo  = evento.getNomeEvento();

        Espaco espaco;
        espaco = EspacoDao.buscarByEvento(evento);
        

//        //ASSENTOS QUANTIDADE
//        int numVagaSalao = 500;
//        int numCabine = 10;
//        int numCadeira = 40;
//        int numVagaEspecial = 20;
//        
//        if(evento.getCapacidadeReduzida()){//se for capacidade reduzida
//            numVagaSalao = 100;
//            numCabine = 5;
//            numCadeira = 20;
//            numVagaEspecial = 10;
//        }
//        //---------------------

//        double valorCadeira = espaco.getValorCadeira();
//        double valorCabine = espaco.getValorCabine();
//        double valorVagaSalao = espaco.getValorVagaSalao();
//        double valorVagaEspecial = espaco.getValorVagaEspecial();

        //CADEIRAS
        List<Cadeira> cadeirasTotal = new ArrayList<Cadeira>();//lista com todas cadeiras do evento, ocupadas ou não
        Cadeira cadeira;
        
        for (int i = 1; i <= espaco.getQuantcadeira(); i++) {//
            cadeira = new Cadeira();
            
            cadeira.setDescricao("CD" + i);
            cadeirasTotal.add(cadeira);
        }

        List<Cadeira> cadeirasOcupadas;
        cadeirasOcupadas = CadeiraDao.buscarTodasCadeirasByEvento(evento, espaco);//lista de cadeiras ocupadas
        
        List<Cadeira> cadeirasDisponivels;
        cadeirasDisponivels = cadeirasTotal;//cadeiras ainda disponiveis (nao reservadas)

        //ver se assento esta ocupado
        for (int i = 0; i < cadeirasTotal.size(); i++) {//para todos os itens da lista total faça
            for (int j = 0; j < cadeirasOcupadas.size(); j++) {//para todos os itens da lista de cadeiras ocupadas faça
                if (cadeirasTotal.get(i).getDescricao().equals(cadeirasOcupadas.get(j).getDescricao())) {
                    cadeirasDisponivels.remove(cadeirasTotal.get(i));
                }
            }
        }
        
        //CABINES
        List<Cabine> cabinesTotal = new ArrayList<Cabine>();//lista com todas canbines do evento, ocupadas ou não
        Cabine cabine;
        
        for (int i = 1; i <= espaco.getQuantcabine(); i++) {//
            cabine = new Cabine();
            
            cabine.setDescricao("CB" + i);
            cabinesTotal.add(cabine);
        }

        List<Cabine> cabinesOcupadas;
        cabinesOcupadas = CabineDao.buscarTodasCabinesByEvento(evento, espaco);//lista de cabines ocupadas
        
        List<Cabine> cabinesDisponivels;
        cabinesDisponivels = cabinesTotal;//cabines ainda disponiveis (nao reservadas)

        //ver se assento esta ocupado
        for (int i = 0; i < cabinesTotal.size(); i++) {//para todos os itens da lista total faça
            for (int j = 0; j < cabinesOcupadas.size(); j++) {//para todos os itens da lista de cabines ocupadas faça
                if (cabinesTotal.get(i).getDescricao().equals(cabinesOcupadas.get(j).getDescricao())) {
                    cabinesDisponivels.remove(cabinesTotal.get(i));
                }
            }
        }
        
        //VAGA ESPECIAL
        List<VagaEspecial> vagasEspeciaisTotal = new ArrayList<VagaEspecial>();//lista com todas canbines do evento, ocupadas ou não
        VagaEspecial vagaEspecial;
        
        for (int i = 1; i <= espaco.getQuantvagaespecial(); i++) {//
            vagaEspecial = new VagaEspecial();
            
            vagaEspecial.setDescricao("VE" + i);
            vagasEspeciaisTotal.add(vagaEspecial);
        }

        List<VagaEspecial> vagasEspeciaisOcupadas;
        vagasEspeciaisOcupadas = VagaEspecialDao.buscarTodasVagaEspecialByEvento(evento, espaco);//lista de cabines ocupadas
        
        List<VagaEspecial> vagasEspeciaisDisponivels;
        vagasEspeciaisDisponivels = vagasEspeciaisTotal;//cabines ainda disponiveis (nao reservadas)

        //ver se assento esta ocupado
        for (int i = 0; i < vagasEspeciaisTotal.size(); i++) {//para todos os itens da lista total faça
            for (int j = 0; j < vagasEspeciaisOcupadas.size(); j++) {//para todos os itens da lista de cabines ocupadas faça
                if (vagasEspeciaisTotal.get(i).getDescricao().equals(vagasEspeciaisOcupadas.get(j).getDescricao())) {
                    vagasEspeciaisDisponivels.remove(vagasEspeciaisTotal.get(i));
                }
            }
        }
        
        
        
        
        
        request.setAttribute("cadeirasDisponivels", cadeirasDisponivels);
        request.setAttribute("cabinesDisponivels", cabinesDisponivels);
        request.setAttribute("vagasEspeciaisDisponivels", vagasEspeciaisDisponivels);
        request.setAttribute("clientes", clientes);

        request.setAttribute("page", "/pages/outros/vendaIngressos.jsp");

        rd.forward(request, response);
    }
}
