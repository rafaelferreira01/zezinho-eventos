/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.espaco.anfiteatro.assento;

/**
 *
 * @author Leonardo
 */
public class VagaEspecial extends Assento{

    public VagaEspecial() {
        this.vagasDisponiveis = 20;
    }

    public VagaEspecial(int idAssento, int vagasDisponiveis) {
        super(idAssento, 20);
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
