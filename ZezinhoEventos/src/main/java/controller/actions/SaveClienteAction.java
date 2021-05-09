/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.actions;

import controller.commander.GenericCommander;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.cliente.Cliente;
import model.daos.ClienteDao;

/**
 *
 * @author suporte
 */
public class SaveClienteAction extends GenericCommander {

    public SaveClienteAction(boolean b) {
        super(b);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            ClienteDao.getConexao().getTransaction().begin();

            Cliente cliente;
            String msg;
            
                if (request.getParameter("cpAlterar").equals("")) {
            //  if (request.getParameter("tipo").equals("cadastrar")) {

                cliente = new Cliente(Integer.parseInt(request.getParameter("cpCPF")),
                        request.getParameter("cpNomeCliente"));

                msg = "Cliente criado com sucesso!!!";
            } else {
                
                cliente = ClienteDao.buscarByCPF(Integer.parseInt(request.getParameter("cpCPF")) );
                
                cliente.setNome(request.getParameter("cpNomeCliente"));
                cliente.setCpf(Integer.parseInt(request.getParameter("cpCPF")));
                msg = "Cliente alterado com sucesso!!!";
            }

            ClienteDao.getConexao().persist(cliente);
            
            ClienteDao.getConexao().getTransaction().commit();

            request.setAttribute("msg", msg);

            new ViewCadastroClientesAction(true).executa(request, response);
        
    }
     
   
}
