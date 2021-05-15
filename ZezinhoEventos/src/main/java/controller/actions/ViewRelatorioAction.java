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
import model.daos.CabineDao;
import model.daos.CadeiraDao;
import model.daos.EspacoDao;
import model.daos.EventoDao;
import model.daos.TipoEspacoDao;
import model.daos.TipoEventoDao;
import model.daos.VagaEspecialDao;
import model.daos.VagaSalaoDao;
import model.espaco.Espaco;
import model.espaco.TipoEspaco;
import model.espaco.assento.Cabine;
import model.espaco.assento.Cadeira;
import model.espaco.assento.VagaEspecial;
import model.espaco.assento.VagaSalao;
import model.evento.Evento;
import static model.evento.EventoCliente_.evento;
import model.evento.TipoEvento;

/**
 *
 * @author Leonardo
 */
public class ViewRelatorioAction extends GenericCommander {

    public ViewRelatorioAction(boolean estaLogado) {
        super(estaLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");

        List<TipoEvento> tipoEventos = null;//preencher a combo de tipo de eventos
        tipoEventos = TipoEventoDao.buscarTodosTipoEventos();

        List<TipoEspaco> espacos = null;//preencher a combo de espacos
        espacos = TipoEspacoDao.buscarTodosTiposEspacos();
        
        Espaco espaco;

        double lucro;
        
        List<Double> custoEventos = new ArrayList<Double>();
        List<Double> lucroIngressos = new ArrayList<Double>();
        
        
        List<Evento> listaEventos = null;//lista com todos eventos
        
        if ( request.getParameter("cpSearchNomeEvento") == null ){
            listaEventos = EventoDao.buscarTodosEventos();
        }else{
            String dei = request.getParameter("cpDataInicio"); //yyyy-mm-dd
            String def = request.getParameter("cpDataFim");
            listaEventos = EventoDao.buscarEventosFiltro(
                    request.getParameter("cpSearchNomeEvento"),
                    dei,
                    def,
                    Integer.parseInt(request.getParameter("cpEspacoEvento")),
                    Integer.parseInt(request.getParameter("cpTipoEvento")));
        }
        
        for (Evento evento : listaEventos) {
            lucro = 0;
            espaco = EspacoDao.buscarByEvento(evento);

            //CADEIRAS
            List<Cadeira> cadeirasPrecoNormal;
            cadeirasPrecoNormal = CadeiraDao.buscarTodasCadeirasInteiraByEvento(evento, espaco);

            List<Cadeira> cadeirasMeiaEntrada;
            cadeirasMeiaEntrada = CadeiraDao.buscarTodasCadeirasMeiaEntradaByEvento(evento, espaco);

            for (Cadeira cadeira : cadeirasPrecoNormal) {
                lucro += espaco.getValorCadeira();
            }
            for (Cadeira cadeira : cadeirasMeiaEntrada) {
                lucro += (espaco.getValorCadeira() / 2);
            }
            
            //CABINE
            List<Cabine> cabinesPrecoNormal;
            cabinesPrecoNormal = CabineDao.buscarTodasCabinesByEvento(evento, espaco);

            for (Cabine cabine : cabinesPrecoNormal) {
                lucro += espaco.getValorCabine();
            }
            
            //VAGA ESPECIAL
            List<VagaEspecial> vagaEspecialPrecoNormal;
            vagaEspecialPrecoNormal = VagaEspecialDao.buscarTodasVagaEspecialInteiraByEvento(evento, espaco);

            List<VagaEspecial> vagaEspecialMeiaEntrada;
            vagaEspecialMeiaEntrada = VagaEspecialDao.buscarTodasVagaEspecialMeiaEntradaByEvento(evento, espaco);

            for (VagaEspecial vagaEspecial : vagaEspecialPrecoNormal) {
                lucro += espaco.getValorVagaEspecial();
            }
            for (VagaEspecial vagaEspecial : vagaEspecialMeiaEntrada) {
                lucro += (espaco.getValorVagaEspecial() / 2);
            }
            
            //VAGA SALAO
            List<VagaSalao> vagaSalaoPrecoNormal;
            vagaSalaoPrecoNormal = VagaSalaoDao.buscarTodasVagaSalaoInteiraByEvento(evento, espaco);

            List<VagaSalao> vagaSalaoMeiaEntrada;
            vagaSalaoMeiaEntrada = VagaSalaoDao.buscarTodasVagaSalaoMeiaEntradaByEvento(evento, espaco);

            for (VagaSalao vagaSalao : vagaSalaoPrecoNormal) {
                lucro += espaco.getValorVagaSalao();
            }
            for (VagaSalao vagaSalao : vagaSalaoMeiaEntrada) {
                lucro += (espaco.getValorVagaSalao() / 2);
            }
            
            lucroIngressos.add(lucro);
            custoEventos.add(evento.getCustoInicial()+evento.getCustoExtra());
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            

//      List<Cabine> cabinesOcupadas;
//      cabinesOcupadas = CabineDao.buscarTodasCabinesByEvento(evento, espaco);//lista de cabines ocupadas
//      
//      List<VagaEspecial> vagasEspeciaisOcupadas;
//      vagasEspeciaisOcupadas = VagaEspecialDao.buscarTodasVagaEspecialByEvento(evento, espaco);//lista de cabines ocupadas
//
//      List<VagaSalao> vagasSalaoOcupadas;
//      vagasSalaoOcupadas = VagaSalaoDao.buscarTodasVagaSalaoByEvento(evento, espaco);//lista de cabines ocupadas
        }
        request.setAttribute("espacos", espacos);
        request.setAttribute("tipoEventos", tipoEventos);
      
        
        request.setAttribute("listaEventos", listaEventos);
        request.setAttribute("custoEventos", custoEventos);
        request.setAttribute("lucroIngressos", lucroIngressos);
        
        request.setAttribute("cpDataInicio", request.getParameter("cpDataInicio"));
        request.setAttribute("cpDataFim", request.getParameter("cpDataFim"));
        request.setAttribute("cpSearchNomeEvento", request.getParameter("cpSearchNomeEvento"));
        request.setAttribute("cpTipoEvento", request.getParameter("cpTipoEvento"));
        request.setAttribute("cpEspacoEvento", request.getParameter("cpEspacoEvento"));

        request.setAttribute("page", "/pages/outros/relatorio.jsp");
        rd.forward(request, response);
    }

}
