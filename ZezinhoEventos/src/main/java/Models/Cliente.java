/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.espaco.anfiteatro.assento.VagaEspecial;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Leonardo
 */
@Entity
public class Cliente {
    
   @Id
   private int cpf;
   private String nome;
   
   private int idAssento;
   private ArrayList<Evento> meusEventosList;

    public Cliente() {
        this.meusEventosList = new ArrayList<>();
    }

    public Cliente(int cpf, int idAssento, String nome, Evento evento) {
        this.cpf = cpf;
        this.idAssento = idAssento;
        this.nome = nome;
        this.meusEventosList = new ArrayList<>();
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public ArrayList<Evento> getMeusEventosList() {
        return meusEventosList;
    }

    public void setMeusEventosList(ArrayList<Evento> meusEventosList) {
        this.meusEventosList = meusEventosList;
    }

    
   
   
    
}
