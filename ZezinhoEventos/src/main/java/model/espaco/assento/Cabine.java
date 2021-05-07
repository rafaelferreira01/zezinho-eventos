/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.espaco.assento;

import model.espaco.Espaco;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import model.evento.Evento;

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cabine.findAll", query = "SELECT c FROM Cabine c"),
    @NamedQuery(name = "Cabine.findByIdCabine", query = "SELECT c FROM Cabine c WHERE c.idCabine = :idCabine"),
    @NamedQuery(name = "Cabine.findByValor", query = "SELECT c FROM Cabine c WHERE c.valor = :valor")})
public class Cabine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idCabine;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double valor;
    @JoinColumn(name = "espaco", referencedColumnName = "idespaco")
    @ManyToOne
    private Espaco espaco;
    @JoinColumn(name = "evento", referencedColumnName = "idEvento")
    @ManyToOne
    private Evento evento;

    public Cabine() {
    }

    public Cabine(Integer idCabine, double valor, Espaco espaco, Evento evento) {
        this.idCabine = idCabine;
        this.valor = valor;
        this.espaco = espaco;
        this.evento = evento;
    }
    
    public Cabine(Integer idCabine) {
        this.idCabine = idCabine;
    }

    public Cabine(Integer idCabine, double valor) {
        this.idCabine = idCabine;
        this.valor = valor;
    }

    public Integer getIdCabine() {
        return idCabine;
    }

    public void setIdCabine(Integer idCabine) {
        this.idCabine = idCabine;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCabine != null ? idCabine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabine)) {
            return false;
        }
        Cabine other = (Cabine) object;
        if ((this.idCabine == null && other.idCabine != null) || (this.idCabine != null && !this.idCabine.equals(other.idCabine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.espaco.assento.Cabine[ idCabine=" + idCabine + " ]";
    }
    
}
