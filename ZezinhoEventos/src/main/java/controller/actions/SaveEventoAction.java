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
import model.daos.EventoDao;
import model.evento.Evento;

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
                        Double.parseDouble(request.getParameter("cpCustoInicial")),
                        0);
                
                
                
            CabineDao.getConexao().getTransaction().begin();    
                
                
                
                
                
                        
                       
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
            
            
            //PARTE DOS ASSENTOS
            
            
            
            
            
            
            

            new ViewCadastroEventosAction(true).executa(request, response);
            
        } catch (ParseException ex) {
            throw new ServletException("Erro ao converter a data");
        }
        
    }
     
   
}
