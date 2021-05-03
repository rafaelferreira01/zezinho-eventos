/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.espaco.salao;

import javax.persistence.Entity;
import models.espaco.Espaco;

/**
 *
 * @author Leonardo
 */
@Entity
public class Salao extends Espaco {
    
    public Salao() {
        this.capacidadeTotal = 500;
        this.tipoEspaco = "Salao";
    }

    public Salao(int capacidadeTotal) {
        this.capacidadeTotal = 500;
        this.tipoEspaco = "Salao";
    }

    public Salao(int idEspaco, int capacidadeTotal, double custoExtra, String tipoEspaco) {
        super(idEspaco, 500, custoExtra, "Salao");
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
