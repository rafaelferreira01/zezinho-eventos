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
public class VagaEspecial {
    
    private int idVagaEspecial;
    private int vagasDisponiveis = 10;

    public VagaEspecial() {
    }

    public VagaEspecial(int idVagaEspecial) {
        this.idVagaEspecial = idVagaEspecial;
    }

    public int getIdVagaEspecial() {
        return idVagaEspecial;
    }

    public void setIdVagaEspecial(int idVagaEspecial) {
        this.idVagaEspecial = idVagaEspecial;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
    
    
}
