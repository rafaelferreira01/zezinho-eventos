/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Children;

import Models.Parents.Espaco;

/**
 *
 * @author Leonardo
 */
public class Salao extends Espaco {
    
    private int capacidadeTotal;

    public Salao() {
    }

    public Salao(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public Salao(int idEspaco, double custoExtra, String tipoEspaco) {
        super(idEspaco, custoExtra, tipoEspaco);
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }
    
    
}
