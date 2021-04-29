/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Leonardo
 */
public class Cliente {
    
   private int cpf,idAssento;
   private String nome;
   private Evento evento;

    public Cliente() {
    }

    public Cliente(int cpf, int idAssento, String nome, Evento evento) {
        this.cpf = cpf;
        this.idAssento = idAssento;
        this.nome = nome;
        this.evento = evento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
   
   
    
}
