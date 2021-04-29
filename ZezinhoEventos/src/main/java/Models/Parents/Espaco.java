/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Parents;

/**
 *
 * @author Leonardo
 */
public abstract class  Espaco {
    
        private int idEspaco;
        private double custoExtra;
        private String tipoEspaco; 

    public Espaco() {
    }

    public Espaco(int idEspaco, double custoExtra, String tipoEspaco) {
        this.idEspaco = idEspaco;
        this.custoExtra = custoExtra;
        this.tipoEspaco = tipoEspaco;
    }

    public int getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(int idEspaco) {
        this.idEspaco = idEspaco;
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
