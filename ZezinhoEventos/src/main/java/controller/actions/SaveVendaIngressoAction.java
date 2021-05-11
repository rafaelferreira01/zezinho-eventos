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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.daos.EspacoDao;
import model.daos.EventoDao;
import model.daos.CadeiraDao;
import model.daos.CabineDao;
import model.daos.VagaEspecialDao;
import model.daos.VagaSalaoDao;
import model.daos.TipoEspacoDao;
import model.daos.TipoEventoDao;
import model.daos.ClienteDao;
import model.espaco.Espaco;
import model.espaco.assento.Cabine;
import model.espaco.assento.Cadeira;
import model.espaco.assento.VagaSalao;
import model.espaco.assento.VagaEspecial;
import model.espaco.TipoEspaco;
import model.evento.Evento;
import model.evento.EventoCliente;
import model.cliente.Cliente;
import model.daos.EventoClienteDao;
import model.evento.TipoEvento;

/**
 *
 * @author suporte
 */
public class SaveVendaIngressoAction extends GenericCommander {

    public SaveVendaIngressoAction(boolean estaLogado) {
        super(estaLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg = "";
        String descricaoCadeira = request.getParameter("cpCadeiras");
        String descricaoCabine = request.getParameter("cpCabines");
        String descricaoVagaEspecial = request.getParameter("cpVagaEspecial");
        String descricaoVagaSalao = request.getParameter("cpVagaSalao");
        
        //EVENTO
//            EventoDao.getConexao().getTransaction().begin();
            Evento evento;
            evento = EventoDao.buscarByIdEvento(Integer.parseInt(request.getParameter("cpEventoId")));

            //CLIENTE
            Cliente cliente;
            cliente = ClienteDao.buscarByCPF(Integer.parseInt(request.getParameter("cpSearchClientes")));

            //ESPACO
            Espaco espaco;
            espaco = EspacoDao.buscarByEvento(evento);
        
        if (espaco.getTipoespaco().getIdTipoEspaco() == 2) {
            if (descricaoCadeira.equals("-1") && descricaoCabine.equals("-1")
                    && descricaoVagaEspecial.equals("-1")) {
                msg = "Você deve selecionar ao menos um tipo de assento!!!";
            }
        } else if (Integer.parseInt(request.getParameter("cpSearchClientes")) == -1) {
            msg = "Você deve selecionar um cliente!!!";
        } else {

            

            //CADEIRA
            if (!descricaoCadeira.equals("-1")) {
                CadeiraDao.getConexao().getTransaction().begin();

                Cadeira cadeira;
                cadeira = new Cadeira(0,
                        descricaoCadeira,
                        cliente,
                        espaco);

                CadeiraDao.getConexao().persist(cadeira);
                CadeiraDao.getConexao().getTransaction().commit();
            }

            //CABINE
            if (!descricaoCabine.equals("-1")) {
                CabineDao.getConexao().getTransaction().begin();

                Cabine cabine;
                cabine = new Cabine(0,
                        descricaoCabine,
                        cliente,
                        espaco);

                CabineDao.getConexao().persist(cabine);
                CabineDao.getConexao().getTransaction().commit();
            }

            //VAGA ESPECIAL
            if (!descricaoVagaEspecial.equals("-1")) {
                VagaEspecialDao.getConexao().getTransaction().begin();

                VagaEspecial vagaEspecial;
                vagaEspecial = new VagaEspecial(0,
                        descricaoVagaEspecial,
                        cliente,
                        espaco);

               VagaEspecialDao.getConexao().persist(vagaEspecial);
               VagaEspecialDao.getConexao().getTransaction().commit();
            }
            
            
            //VAGA SALAO
            if (!descricaoVagaSalao.equals("")) {
//            if (espaco.getTipoespaco().getIdTipoEspaco() == 1){
                VagaSalaoDao.getConexao().getTransaction().begin();

                VagaSalao vagaSalao;
                vagaSalao = new VagaSalao(0,
                        cliente,
                        espaco);

               VagaSalaoDao.getConexao().persist(vagaSalao);
               VagaSalaoDao.getConexao().getTransaction().commit();
            }
            
            

            //EVENTO_CLIENTE
            EventoClienteDao.getConexao().getTransaction().begin();
            EventoCliente eventoCliente;
            eventoCliente = new EventoCliente(0, cliente, evento);
            EventoClienteDao.getConexao().persist(eventoCliente);
            EventoClienteDao.getConexao().getTransaction().commit();

            msg = "Ingresso vendido com sucesso!!!";

        }
        
        
        request.setAttribute("msg", msg);
        new ViewListaEventosAction(true).executa(request, response);

    }

}
