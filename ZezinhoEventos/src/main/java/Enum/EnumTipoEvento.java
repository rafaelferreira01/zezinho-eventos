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
public enum EnumTipoEvento {
    
    PALESTRA(1),SHOW(2),CURSO(3),FESTA(4);
    
    private int valorTipoEvento;

    private EnumTipoEvento(int valorTipoEvento) {
        this.valorTipoEvento = valorTipoEvento;
    }
    
    public int getValorTipoEvento() {
        return valorTipoEvento;
    }

    public void setValorTipoEvento(int valorTipoEvento) {
        this.valorTipoEvento = valorTipoEvento;
    }
    
    
}
