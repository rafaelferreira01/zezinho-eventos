/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Enum.EnumEspaco;
import Enum.EnumTipoEvento;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Leonardo
 */
@Entity
public class Evento {
   @Id
   private int idEvento; 
   private String nomeEvento;
   private EnumEspaco espaco; 
   private boolean capacidadeReduzida;
   private EnumTipoEvento tipoEvento;
   private Date dataEvento;

    public Evento() {
    }

    public Evento(int idEvento, String nomeEvento, EnumEspaco espaco, boolean capacidadeReduzida, EnumTipoEvento tipoEvento, Date dataEvento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.espaco = espaco;
        this.capacidadeReduzida = capacidadeReduzida;
        this.tipoEvento = tipoEvento;
        this.dataEvento = dataEvento;
    }

  

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    
    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public EnumEspaco getEspaco() {
        return espaco;
    }

    public void setEspaco(EnumEspaco espaco) {
        this.espaco = espaco;
    }

    public boolean isCapacidadeReduzida() {
        return capacidadeReduzida;
    }

    public void setCapacidadeReduzida(boolean capacidadeReduzida) {
        this.capacidadeReduzida = capacidadeReduzida;
    }

    public EnumTipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EnumTipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }


    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }
   
   
    
}

