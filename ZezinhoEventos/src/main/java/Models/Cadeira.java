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
public class Cadeira {
    
    private int idCadeira;
    private int vagasDisponiveis = 100;

    public Cadeira() {
    }

    public Cadeira(int idCadeira) {
        this.idCadeira = idCadeira;
    }

    public int getIdCadeira() {
        return idCadeira;
    }

    public void setIdCadeira(int idCadeira) {
        this.idCadeira = idCadeira;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
    
    
    
}
