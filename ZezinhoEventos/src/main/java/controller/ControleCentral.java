/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import controller.actions.SaveVendaIngressoAction;
import controller.actions.DeletarClienteAction;
import controller.actions.DeletarEventoAction;
import controller.actions.SaveClienteAction;
import controller.actions.ViewLoginAction;
import controller.actions.LoginVerifyAction;
import controller.actions.SaveEventoAction;
import controller.actions.SaveUsuarioAction;
import controller.actions.ViewCadastroAction;
import controller.actions.ViewCadastroClientesAction;
import controller.actions.ViewCadastroEventosAction;
import controller.actions.ViewVenderIngressoAction;
import controller.actions.ViewHomeLogadoAction;
import controller.actions.ViewListaClientesAction;
import controller.actions.ViewListaEventosAction;
import controller.actions.ViewLogoutAction;
import controller.actions.ViewRelatorioAction;
import controller.commander.GenericCommander;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "ControleCentral", urlPatterns = {"/control"})
public class ControleCentral extends HttpServlet {

    static HashMap<String, GenericCommander> comandos;

    static {
        comandos = new HashMap<>();
        comandos.put(null, new ViewLoginAction(false));
        comandos.put("login", new LoginVerifyAction(false));
        comandos.put("cad", new ViewCadastroAction(false));
        comandos.put("salvarUsuario", new SaveUsuarioAction(false));
        comandos.put("paginaInicial", new ViewHomeLogadoAction(true));
        comandos.put("logout", new ViewLogoutAction(true));
        
        
        
       
                
        comandos.put("Clientes", new ViewCadastroClientesAction(true));
        comandos.put("listaClientes", new ViewListaClientesAction(true));
        comandos.put("clienteCad", new SaveClienteAction(true));
        comandos.put("editCliente", new ViewCadastroClientesAction(true));
        comandos.put("apgCliente", new  DeletarClienteAction(true));
         
        comandos.put("Eventos", new ViewCadastroEventosAction(true));
        comandos.put("eventoCad", new SaveEventoAction(true));   
        comandos.put("listaEventos", new ViewListaEventosAction(true));
        comandos.put("editEvento", new ViewCadastroEventosAction(true));
        comandos.put("apgEvento", new DeletarEventoAction(true));
        comandos.put("relatorio", new ViewRelatorioAction(true));
        
        
        comandos.put("venderIngresso", new ViewVenderIngressoAction(true));
        comandos.put("gravarVendaIngresso", new SaveVendaIngressoAction(true));
        
       
        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String acao = request.getParameter("ac");
            
            
                try {
                
                if (!comandos.get(acao).isEstaLogado()|| request.getSession().getAttribute("usuario") != null ){
                    
                    comandos.get(acao).executa(request, response);                
                }else{
                    request.setAttribute("mensagem", "Acesso não autorizado, pilantra!");
                    new ViewLoginAction(false).executa(request, response);
                }
                
                
                
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                
                request.setAttribute("error", e.getMessage()==null?"ação não encontrada":e.getMessage());
                
                rd.forward(request, response);
            }

    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }

