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
    @NamedQuery(name = "VagaSalao.findAll", query = "SELECT v FROM VagaSalao v"),
    @NamedQuery(name = "VagaSalao.findByIdVagasalao", query = "SELECT v FROM VagaSalao v WHERE v.idVagasalao = :idVagasalao"),
    @NamedQuery(name = "VagaSalao.findByValor", query = "SELECT v FROM VagaSalao v WHERE v.valor = :valor")})
public class VagaSalao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idVagasalao;
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

    public VagaSalao() {
    }

    //ADICIONADO MANUALMENTE
    public VagaSalao(Integer idVagasalao, double valor, Espaco espaco, Evento evento) {
        this.idVagasalao = idVagasalao;
        this.valor = valor;
        this.espaco = espaco;
        this.evento = evento;
    }
    //FIM ADICIONADO MANUALMENTE
    

    public VagaSalao(Integer idVagasalao) {
        this.idVagasalao = idVagasalao;
    }

    public VagaSalao(Integer idVagasalao, double valor) {
        this.idVagasalao = idVagasalao;
        this.valor = valor;
    }

    public Integer getIdVagasalao() {
        return idVagasalao;
    }

    public void setIdVagasalao(Integer idVagasalao) {
        this.idVagasalao = idVagasalao;
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
        hash += (idVagasalao != null ? idVagasalao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VagaSalao)) {
            return false;
        }
        VagaSalao other = (VagaSalao) object;
        if ((this.idVagasalao == null && other.idVagasalao != null) || (this.idVagasalao != null && !this.idVagasalao.equals(other.idVagasalao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.espaco.assento.VagaSalao[ idVagasalao=" + idVagasalao + " ]";
    }
    
}
