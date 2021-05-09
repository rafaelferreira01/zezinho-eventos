/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actions;

import controller.commander.GenericCommander;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import model.evento.Evento;
import model.evento.TipoEvento;
import model.espaco.assento.VagaSalao;

/**
 *
 * @author suporte
 */
public class SaveEventoAction extends GenericCommander {

    public SaveEventoAction(boolean b) {
        super(b);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
            try {//EVENTO
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            EventoDao.getConexao().getTransaction().begin();

            Evento evento;
            String msg;
            if (request.getParameter("cpId").equals("")) {//se for evento novo

                
                //TIPOEVENTO
                TipoEvento tipoEvento;
                tipoEvento = TipoEventoDao.buscarByIdTipoEvento(Integer.parseInt(request.getParameter("cpTipoEvento")));
                
                //TIPOESPACO
                TipoEspaco tipoEspaco;
                tipoEspaco = TipoEspacoDao.buscarByIdTipoEspaco(Integer.parseInt(request.getParameter("cpEspacoEvento")));
                
                //EVENTO
                evento = new Evento(0,
                        request.getParameter("cpNomeEvento"),
                        sdf.parse(request.getParameter("cpDataEvento")),
                        Boolean.parseBoolean(request.getParameter("CpCapacidadeReduzida") != null ? "true" : "false"),
                        Double.parseDouble(request.getParameter("cpCustoExtra")),
                        Double.parseDouble(request.getParameter("cpCustoInicial")),
                        tipoEvento);

                EventoDao.getConexao().persist(evento);
                EventoDao.getConexao().getTransaction().commit();


                //ASSENTOS
                int quantCabine = 0;
                int quantCadeira = 0;
                int quantVagaEspecial = 0;
                int quantVagaSalao = 0;

                if (tipoEspaco.getIdTipoEspaco() == 1) {//se for Salao
                    quantVagaSalao = 500;
                    if (evento.getCapacidadeReduzida()) {
                        quantVagaSalao = 250;
                    }
                } else {
                    quantCabine = 10;
                    quantCadeira = 100;
                    quantVagaEspecial = 20;
                    if (evento.getCapacidadeReduzida()) {
                        quantCabine = 5;
                        quantCadeira = 20;
                        quantVagaEspecial = 10;
                    }
                }
                
                //ESPACO
                EspacoDao.getConexao().getTransaction().begin();
                Espaco espaco;
                
                espaco = new Espaco(0,
                        quantVagaEspecial,
                        quantCadeira,
                        quantCabine,
                        quantVagaSalao,
                        Double.parseDouble(request.getParameter("cpValorCadeira")),
                        Double.parseDouble(request.getParameter("cpValorCabine")),
                        Double.parseDouble(request.getParameter("cpValorVagaEspecial")),
                        Double.parseDouble(request.getParameter("cpValorVagaSalao")),
                        evento,
                        tipoEspaco);

                EspacoDao.getConexao().persist(espaco);
                EspacoDao.getConexao().getTransaction().commit();

                msg = "Evento criado com sucesso!!!";
            } else {
                
                //NAO FIZ NADA AQUI - RAFAEL
                evento = EventoDao.buscarByIdEvento(Integer.parseInt(request.getParameter("cpId")));

                evento.setNomeEvento(request.getParameter("cpNomeEvento"));
                evento.setDataEvento(sdf.parse(request.getParameter("cpDataEvento")));
                evento.setCapacidadeReduzida(Boolean.parseBoolean(request.getParameter("CpCapacidadeReduzida")));
                evento.setCustoInicial(Double.parseDouble(request.getParameter("cpCustoInicial")));
                evento.setCustoExtra(Double.parseDouble(request.getParameter("cpCustoExtra")));


                
                
                
                
                
                msg = "Evento alterado com sucesso!!!";
            }
            
            request.setAttribute("msg", msg);
            
            new ViewCadastroEventosAction(true).executa(request, response);
            
        } catch (ParseException ex) {
            throw new ServletException("Erro ao converter a data");
        }
        
    }
     
   
}
