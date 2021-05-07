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
import model.daos.EspacoDao;
import model.daos.EventoDao;
import model.daos.TipoEspacoDao;
import model.daos.VagaSalaoDao;
import model.espaco.Espaco;
import static model.espaco.Espaco_.vagaSalao;
import model.espaco.TipoEspaco;
import model.evento.Evento;
import model.espaco.assento.VagaSalao;

/**
 *
 * @author suporte
 */
public class SaveEventoActionCOPIA extends GenericCommander {

    public SaveEventoActionCOPIA(boolean b) {
        super(b);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
            try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            EventoDao.getConexao().getTransaction().begin();

            Evento evento;
            String msg;
            if (request.getParameter("cpId").equals("")) {

                evento = new Evento(0,
                        request.getParameter("cpNomeEvento"),
                        sdf.parse(request.getParameter("cpDataEvento")),
                        Boolean.parseBoolean(request.getParameter("CpCapacidadeReduzida")!=null?"true":"false"),
                        Double.parseDouble(request.getParameter("cpCustoExtra")),
                        Double.parseDouble(request.getParameter("cpCustoInicial")));
                
                System.out.println("dddddddddddddddddddddd"
                        + ""+evento.getCustoInicial());
            //ESPACO E ASSENTOS
//            int proximoIdEvento = EventoDao.buscarUltimoIdEnento().getIdEvento()+1;//id do proximo evento a ser adicionado
            
            //TIPOESPACO
                
                TipoEspacoDao.getConexao().getTransaction().begin();
                TipoEspaco tipoEspaco;
                              
                tipoEspaco = new TipoEspaco(TipoEspacoDao.buscarByIdTipoEspaco(Integer.parseInt(request.getParameter("cpEspacoEvento"))).getIdTipoEspaco());
                
//                TipoEspacoDao.getConexao().persist(tipoEspaco);
//                TipoEspacoDao.getConexao().getTransaction().commit();
            
                
                System.out.println("sssssssssssssssssssssss");
                
                //ESPACO
                EspacoDao.getConexao().getTransaction().begin();
                Espaco espaco;
                
                espaco = new Espaco(0, evento, tipoEspaco);
                
                EspacoDao.getConexao().persist(espaco);
                EspacoDao.getConexao().getTransaction().commit();
                
                
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa"
                        + ""+espaco.getIdespaco());
                
                
             //ASSENTOS   
            if(tipoEspaco.getIdTipoEspaco() == 1){//se for Salao
                VagaSalaoDao.getConexao().getTransaction().begin();
                VagaSalao vagasalao;
                
                for(int i=1 ; i <= 10; i++){
                    vagasalao = new VagaSalao(i,
                            Double.parseDouble(request.getParameter("cpValorVagaSalao")),
                            espaco,
                            evento);
                    
                    VagaSalaoDao.getConexao().persist(vagasalao);
                    VagaSalaoDao.getConexao().getTransaction().commit();
                }
                
                
            }
                
                
                
//            } else {//se for anfiteatro
//            CabineDao.getConexao().getTransaction().begin();
//            CadeiraDao.getConexao().getTransaction().begin();
//            VagaEspecialDao.getConexao().getTransaction().begin();
//            }
            //FIM ASSENTOS 
                
                
                
                
                        
                       
                msg = "Evento criado com sucesso!!!";
            } else {
                evento = EventoDao.buscarByIdEvento(Integer.parseInt(request.getParameter("cpId")) );
                
                evento.setNomeEvento(request.getParameter("cpNomeEvento"));
                evento.setDataEvento(sdf.parse(request.getParameter("cpDataEvento")));
                evento.setCapacidadeReduzida(Boolean.parseBoolean(request.getParameter("CpCapacidadeReduzida")));
                evento.setCustoInicial(Double.parseDouble(request.getParameter("cpCustoInicial")));
                evento.setCustoExtra(Double.parseDouble(request.getParameter("cpCustoExtra")));
                
                
                
                
                
                
                
                
                
                
                
                msg = "Evento alterado com sucesso!!!";
            }

            EventoDao.getConexao().persist(evento);
            EventoDao.getConexao().getTransaction().commit();
            
            

            request.setAttribute("msg", msg);
            
            
             
            
            
            
            
            
            

            new ViewCadastroEventosAction(true).executa(request, response);
            
        } catch (ParseException ex) {
            throw new ServletException("Erro ao converter a data");
        }
        
    }
     
   
}
