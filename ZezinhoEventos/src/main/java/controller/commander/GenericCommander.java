/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commander;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
public abstract class GenericCommander {
    
    private boolean estaLogado;
    
    public abstract void executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

 
    public GenericCommander(boolean estaLogado) {
        this.estaLogado = estaLogado;
    }

    public boolean isEstaLogado() {
        return estaLogado;
    }

    public void setEstaLogado(boolean estaLogado) {
        this.estaLogado = estaLogado;
    }
            
}
