/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.espaco;

/**
 *
 * @author Leonardo
 */
public abstract class Espaco {
    
        protected int idEspaco;
        protected int capacidadeTotal;
        protected double custoExtra;
        protected String tipoEspaco; 

    public Espaco() {
    }

    public Espaco(int idEspaco, int capacidadeTotal, double custoExtra, String tipoEspaco) {
        this.idEspaco = idEspaco;
        this.capacidadeTotal = capacidadeTotal;
        this.custoExtra = custoExtra;
        this.tipoEspaco = tipoEspaco;
    }

    public int getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(int idEspaco) {
        this.idEspaco = idEspaco;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public double getCustoExtra() {
        return custoExtra;
    }

    public void setCustoExtra(double custoExtra) {
        this.custoExtra = custoExtra;
    }

    public String getTipoEspaco() {
        return tipoEspaco;
    }

    public void setTipoEspaco(String tipoEspaco) {
        this.tipoEspaco = tipoEspaco;
    }

   
        
        
}
