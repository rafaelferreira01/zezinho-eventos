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
public class Cabine {
    
    private int idCabine;
    private int vagasDisponiveis = 10;

    public Cabine() {
    }
    
    

    public Cabine(int idCabine) {
        this.idCabine = idCabine;
    }

    public int getIdCabine() {
        return idCabine;
    }

    public void setIdCabine(int idCabine) {
        this.idCabine = idCabine;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
   
    
    
}
