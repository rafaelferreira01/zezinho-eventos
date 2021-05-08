/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.evento;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import model.espaco.Espaco;

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Evento.findByNomeEvento", query = "SELECT e FROM Evento e WHERE e.nomeEvento = :nomeEvento"),
    @NamedQuery(name = "Evento.findByDataEvento", query = "SELECT e FROM Evento e WHERE e.dataEvento = :dataEvento"),
    @NamedQuery(name = "Evento.findByCapacidadeReduzida", query = "SELECT e FROM Evento e WHERE e.capacidadeReduzida = :capacidadeReduzida"),
    @NamedQuery(name = "Evento.findByCustoExtra", query = "SELECT e FROM Evento e WHERE e.custoExtra = :custoExtra"),
    @NamedQuery(name = "Evento.findByCustoInicial", query = "SELECT e FROM Evento e WHERE e.custoInicial = :custoInicial")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nomeEvento;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEvento;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean capacidadeReduzida;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double custoExtra;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double custoInicial;
    @JoinColumn(name = "tipoevento", referencedColumnName = "idTipoEvento")
    @ManyToOne
    private TipoEvento tipoevento;
    @OneToMany(mappedBy = "evento")
    private List<Espaco> espacoList;

    public Evento() {
    }

    public Evento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Evento(Integer idEvento, String nomeEvento, Date dataEvento, boolean capacidadeReduzida, double custoExtra, double custoInicial) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.capacidadeReduzida = capacidadeReduzida;
        this.custoExtra = custoExtra;
        this.custoInicial = custoInicial;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public boolean getCapacidadeReduzida() {
        return capacidadeReduzida;
    }

    public void setCapacidadeReduzida(boolean capacidadeReduzida) {
        this.capacidadeReduzida = capacidadeReduzida;
    }

    public double getCustoExtra() {
        return custoExtra;
    }

    public void setCustoExtra(double custoExtra) {
        this.custoExtra = custoExtra;
    }

    public double getCustoInicial() {
        return custoInicial;
    }

    public void setCustoInicial(double custoInicial) {
        this.custoInicial = custoInicial;
    }

    public TipoEvento getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(TipoEvento tipoevento) {
        this.tipoevento = tipoevento;
    }

    public List<Espaco> getEspacoList() {
        return espacoList;
    }

    public void setEspacoList(List<Espaco> espacoList) {
        this.espacoList = espacoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.espaco.assento.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
