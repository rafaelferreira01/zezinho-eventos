/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actions;

import controller.commander.GenericCommander;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
import model.daos.EventoDao;
import model.daos.VagaSalaoDao;
import model.espaco.Espaco;
import model.espaco.assento.Cadeira;
import model.espaco.assento.Cabine;
import model.espaco.assento.VagaEspecial;
import model.espaco.assento.VagaSalao;
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
        cadeirasDisponivels = new ArrayList<Cadeira>(cadeirasTotal);//cadeiras ainda disponiveis (nao reservadas)

        //ver se assento esta ocupado
        for (int i = 0; i < cadeirasOcupadas.size(); i++) {//para todos os itens da lista total faça
            for (int j = 0; j < cadeirasTotal.size(); j++) {//para todos os itens da lista de cadeiras ocupadas faça
                if (cadeirasOcupadas.get(i).getDescricao().equals(cadeirasTotal.get(j).getDescricao())) {
                    cadeirasDisponivels.set(j, null);//faz o elemento no insicie ser null (se mandar remover ele mexe no inidicie tambem)
                    break;
                }
            }
        }
        cadeirasDisponivels.removeAll(Collections.singletonList(null));//remove os null da lista
        
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
        cabinesDisponivels = new ArrayList<Cabine>(cabinesTotal);//cabines ainda disponiveis (nao reservadas)

        //ver se assento esta ocupado
        for (int i = 0; i < cabinesOcupadas.size(); i++) {//para todos os itens da lista total faça
            for (int j = 0; j < cabinesTotal.size(); j++) {//para todos os itens da lista de cadeiras ocupadas faça
                if (cabinesOcupadas.get(i).getDescricao().equals(cabinesTotal.get(j).getDescricao())) {
                    cabinesDisponivels.set(j, null);//faz o elemento no insicie ser null (se mandar remover ele mexe no inidicie tambem)
                    break;
                }
            }
        }
        cabinesDisponivels.removeAll(Collections.singletonList(null));//remove os null da lista
        
        
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
        vagasEspeciaisDisponivels = new ArrayList<VagaEspecial>(vagasEspeciaisTotal);//cabines ainda disponiveis (nao reservadas)

        //ver se assento esta ocupado
        for (int i = 0; i < cabinesOcupadas.size(); i++) {//para todos os itens da lista total faça
            for (int j = 0; j < cabinesTotal.size(); j++) {//para todos os itens da lista de cadeiras ocupadas faça
                if (cabinesOcupadas.get(i).getDescricao().equals(cabinesTotal.get(j).getDescricao())) {
                    cabinesDisponivels.set(j, null);//faz o elemento no insicie ser null (se mandar remover ele mexe no inidicie tambem)
                    break;
                }
            }
        }
        vagasEspeciaisDisponivels.removeAll(Collections.singletonList(null));//remove os null da lista
        
        
        //VAGA SALAO
        List<VagaSalao> vagasSalaoOcupadas;
        vagasSalaoOcupadas = VagaSalaoDao.buscarTodasVagaSalaoByEvento(evento, espaco);//lista de vagas ocupadas
        
        
        request.setAttribute("espaco", espaco);
        request.setAttribute("evento", evento);
        request.setAttribute("cadeirasDisponivels", cadeirasDisponivels);
        request.setAttribute("cabinesDisponivels", cabinesDisponivels);
        request.setAttribute("vagasEspeciaisDisponivels", vagasEspeciaisDisponivels);
        request.setAttribute("vagasSalaoDisponivels", espaco.getQuantvagaespecial() - vagasSalaoOcupadas.size());
        request.setAttribute("clientes", clientes);

        request.setAttribute("page", "/pages/outros/vendaIngressos.jsp");

        rd.forward(request, response);
    }
}
