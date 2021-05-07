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
import model.daos.VagaEspecialDao;
import model.daos.VagaSalaoDao;
import model.espaco.Espaco;
import model.espaco.TipoEspaco;
import model.espaco.assento.Cabine;
import model.espaco.assento.Cadeira;
import model.espaco.assento.VagaEspecial;
import model.evento.Evento;
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

                evento = new Evento(0,
                        request.getParameter("cpNomeEvento"),
                        sdf.parse(request.getParameter("cpDataEvento")),
                        Boolean.parseBoolean(request.getParameter("CpCapacidadeReduzida")!=null?"true":"false"),
                        Double.parseDouble(request.getParameter("cpCustoExtra")),
                        Double.parseDouble(request.getParameter("cpCustoInicial")));
                
                EventoDao.getConexao().persist(evento);
                EventoDao.getConexao().getTransaction().commit();
            
            
                //TIPOESPACO
                TipoEspaco tipoEspaco;
                tipoEspaco = TipoEspacoDao.buscarByIdTipoEspaco(Integer.parseInt(request.getParameter("cpEspacoEvento")));
                
                //ESPACO
                EspacoDao.getConexao().getTransaction().begin();
                Espaco espaco;
                
                espaco = new Espaco(0, evento, tipoEspaco);
                
                EspacoDao.getConexao().persist(espaco);
                EspacoDao.getConexao().getTransaction().commit();
                
                
                
//                //ASSENTOS
//                int numVagaSalao = 500;
//                int numCabine = 10;
//                int numCadeira = 40;
//                int numVagaEspecial = 20;
//                
//                if (evento.getCapacidadeReduzida()==true){
//                    numVagaSalao = 250;
//                    numCabine = 5;
//                    numCadeira = 20;
//                    numVagaEspecial = 10;
//                }
//                
//                if (tipoEspaco.getIdTipoEspaco() == 1) {//se for Salao
//                    VagaSalao vagasalao;
//
//                    for (int i = 1; i <= numVagaSalao; i++) {
//                        VagaSalaoDao.getConexao().getTransaction().begin();
//
//                        vagasalao = new VagaSalao(0,
//                                Double.parseDouble(request.getParameter("cpValorVagaSalao")),
//                                espaco,
//                                evento);
//
//                        VagaSalaoDao.getConexao().persist(vagasalao);
//                        VagaSalaoDao.getConexao().getTransaction().commit();
//
//                    }
//
//                } else {
//
//                    Cabine cabine;
//                    for (int i = 1; i <= numCabine; i++) {
//                        CabineDao.getConexao().getTransaction().begin();
//
//                        cabine = new Cabine(0,
//                                Double.parseDouble(request.getParameter("cpValorCabine")),
//                                espaco,
//                                evento);
//
//                        CabineDao.getConexao().persist(cabine);
//                        CabineDao.getConexao().getTransaction().commit();
//                    }
//                    
//                    Cadeira cadeira;
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
//                    
//                    VagaEspecial vagaEspecial;
//                    for (int i = 1; i <= numVagaEspecial; i++) {
//                        VagaEspecialDao.getConexao().getTransaction().begin();
//
//                        vagaEspecial = new VagaEspecial(0,
//                                Double.parseDouble(request.getParameter("cpValorVagaEspecial")),
//                                espaco,
//                                evento);
//
//                        VagaEspecialDao.getConexao().persist(vagaEspecial);
//                        VagaEspecialDao.getConexao().getTransaction().commit();
//                    }
//                    
//                }

                msg = "Evento criado com sucesso!!!";
            } else {
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
