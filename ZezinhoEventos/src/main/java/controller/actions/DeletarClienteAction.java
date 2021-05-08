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
 * @author Leonardo
 */
public class DeletarClienteAction extends GenericCommander {

    public DeletarClienteAction(boolean estaLogado) {
        super(estaLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
       
        
       
        ClienteDao.getConexao().getTransaction().begin();
        
        Cliente cliente = ClienteDao.getConexao().find(Cliente.class,Integer.parseInt(cpf));
        
        ClienteDao.getConexao().remove(cliente);
        ClienteDao.getConexao().getTransaction().commit();
        
        response.sendRedirect("control?ac=listaClientes");

    }
    
}
