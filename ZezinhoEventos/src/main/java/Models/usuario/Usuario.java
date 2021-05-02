/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | TemplatesPlano-Sequência dos Mortos
 * and open the template in the editor.
 */
package Models.usuario;

import Models.Evento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class Usuario {
    
    private int idUsuario;
    private String nome,login,senha;
    List<Evento> eventos = new ArrayList<Evento>(); 

    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String login, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    
    
}
