/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author Leonardo
 */
public enum EnumEspaco {
    
    SALAO(1),ANFITEATRO(2);
    
    private int valorEspaco; 

    private EnumEspaco(int valorEspaco) {
        this.valorEspaco = valorEspaco;
    }

    public int getValorEspaco() {
        return valorEspaco;
    }

    public void setValorEspaco(int valorEspaco) {
        this.valorEspaco = valorEspaco;
    }

    
}
