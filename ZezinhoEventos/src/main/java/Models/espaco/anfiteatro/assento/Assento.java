/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.espaco.anfiteatro.assento;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author suporte
 */
public abstract class Assento {
    @Id
    protected int idAssento;
    protected int vagasDisponiveis;

    public Assento() {
    }

    public Assento(int idAssento, int vagasDisponiveis) {
        this.idAssento = idAssento;
        this.vagasDisponiveis = vagasDisponiveis;
    }
    
   
    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }


    
    
}
