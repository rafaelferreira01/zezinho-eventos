/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.evento;

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
import javax.validation.constraints.Size;

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoEvento.findAll", query = "SELECT t FROM TipoEvento t"),
    @NamedQuery(name = "TipoEvento.findByIdTipoEvento", query = "SELECT t FROM TipoEvento t WHERE t.idTipoEvento = :idTipoEvento"),
    @NamedQuery(name = "TipoEvento.findByDescricaoTipoEvento", query = "SELECT t FROM TipoEvento t WHERE t.descricaoTipoEvento = :descricaoTipoEvento")})
public class TipoEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idTipoEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String descricaoTipoEvento;
    @JoinColumn(name = "evento", referencedColumnName = "idEvento", nullable = false)
    @ManyToOne(optional = false)
    private Evento evento;

    public TipoEvento() {
    }

    public TipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public TipoEvento(Integer idTipoEvento, String descricaoTipoEvento) {
        this.idTipoEvento = idTipoEvento;
        this.descricaoTipoEvento = descricaoTipoEvento;
    }

    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getDescricaoTipoEvento() {
        return descricaoTipoEvento;
    }

    public void setDescricaoTipoEvento(String descricaoTipoEvento) {
        this.descricaoTipoEvento = descricaoTipoEvento;
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
        hash += (idTipoEvento != null ? idTipoEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvento)) {
            return false;
        }
        TipoEvento other = (TipoEvento) object;
        if ((this.idTipoEvento == null && other.idTipoEvento != null) || (this.idTipoEvento != null && !this.idTipoEvento.equals(other.idTipoEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoEvento[ idTipoEvento=" + idTipoEvento + " ]";
    }
    
}
