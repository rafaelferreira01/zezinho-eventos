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
    @NamedQuery(name = "VagaEspecial.findAll", query = "SELECT v FROM VagaEspecial v"),
    @NamedQuery(name = "VagaEspecial.findByIdVagaEspecial", query = "SELECT v FROM VagaEspecial v WHERE v.idVagaEspecial = :idVagaEspecial"),
    @NamedQuery(name = "VagaEspecial.findByValor", query = "SELECT v FROM VagaEspecial v WHERE v.valor = :valor")})
public class VagaEspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idVagaEspecial;
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

    public VagaEspecial() {
    }

    public VagaEspecial(Integer idVagaEspecial, double valor, Espaco espaco, Evento evento) {
        this.idVagaEspecial = idVagaEspecial;
        this.valor = valor;
        this.espaco = espaco;
        this.evento = evento;
    }
    
    public VagaEspecial(Integer idVagaEspecial) {
        this.idVagaEspecial = idVagaEspecial;
    }

    public VagaEspecial(Integer idVagaEspecial, double valor) {
        this.idVagaEspecial = idVagaEspecial;
        this.valor = valor;
    }

    public Integer getIdVagaEspecial() {
        return idVagaEspecial;
    }

    public void setIdVagaEspecial(Integer idVagaEspecial) {
        this.idVagaEspecial = idVagaEspecial;
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
        hash += (idVagaEspecial != null ? idVagaEspecial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VagaEspecial)) {
            return false;
        }
        VagaEspecial other = (VagaEspecial) object;
        if ((this.idVagaEspecial == null && other.idVagaEspecial != null) || (this.idVagaEspecial != null && !this.idVagaEspecial.equals(other.idVagaEspecial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.espaco.assento.VagaEspecial[ idVagaEspecial=" + idVagaEspecial + " ]";
    }
    
}
