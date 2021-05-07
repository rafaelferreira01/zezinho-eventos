/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.espaco;

import model.evento.Evento;
import java.io.Serializable;
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

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Espaco.findAll", query = "SELECT e FROM Espaco e"),
    @NamedQuery(name = "Espaco.findByIdespaco", query = "SELECT e FROM Espaco e WHERE e.idespaco = :idespaco"),
    @NamedQuery(name = "Espaco.findByVagaespecial", query = "SELECT e FROM Espaco e WHERE e.vagaespecial = :vagaespecial"),
    @NamedQuery(name = "Espaco.findByCadeira", query = "SELECT e FROM Espaco e WHERE e.cadeira = :cadeira"),
    @NamedQuery(name = "Espaco.findByCabine", query = "SELECT e FROM Espaco e WHERE e.cabine = :cabine"),
    @NamedQuery(name = "Espaco.findByVagaSalao", query = "SELECT e FROM Espaco e WHERE e.vagaSalao = :vagaSalao"),
    @NamedQuery(name = "Espaco.findByValorCadeira", query = "SELECT e FROM Espaco e WHERE e.valorCadeira = :valorCadeira"),
    @NamedQuery(name = "Espaco.findByValorCabine", query = "SELECT e FROM Espaco e WHERE e.valorCabine = :valorCabine"),
    @NamedQuery(name = "Espaco.findByValorVagaEspecial", query = "SELECT e FROM Espaco e WHERE e.valorVagaEspecial = :valorVagaEspecial"),
    @NamedQuery(name = "Espaco.findByValorVagaSalao", query = "SELECT e FROM Espaco e WHERE e.valorVagaSalao = :valorVagaSalao")})
public class Espaco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idespaco;
    private Integer vagaespecial;
    private Integer cadeira;
    private Integer cabine;
    private Integer vagaSalao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22, scale = 0)
    private Double valorCadeira;
    @Column(precision = 22, scale = 0)
    private Double valorCabine;
    @Column(precision = 22, scale = 0)
    private Double valorVagaEspecial;
    @Column(precision = 22, scale = 0)
    private Double valorVagaSalao;
    @JoinColumn(name = "evento", referencedColumnName = "idEvento")
    @ManyToOne
    private Evento evento;
    @JoinColumn(name = "tipoespaco", referencedColumnName = "idTipoEspaco")
    @ManyToOne
    private TipoEspaco tipoespaco;
    @OneToMany(mappedBy = "espaco")
    private List<TipoEspaco> tipoEspacoList;

    public Espaco() {
    }

    public Espaco(Integer idespaco) {
        this.idespaco = idespaco;
    }
    
     //ADICIONADO MANUALMENTE
    public Espaco(Integer idespaco, model.evento.Evento evento, model.espaco.TipoEspaco tipoespaco) {
        this.idespaco = idespaco;
        this.evento = evento;
        this.tipoespaco = tipoespaco;
    }

    public Espaco(Integer idespaco, Evento evento) {
        this.idespaco = idespaco;
        this.evento = evento;
    }
    //ADICIONADO MANUALMENTE FIM

    public Integer getIdespaco() {
        return idespaco;
    }

    public void setIdespaco(Integer idespaco) {
        this.idespaco = idespaco;
    }

    public Integer getVagaespecial() {
        return vagaespecial;
    }

    public void setVagaespecial(Integer vagaespecial) {
        this.vagaespecial = vagaespecial;
    }

    public Integer getCadeira() {
        return cadeira;
    }

    public void setCadeira(Integer cadeira) {
        this.cadeira = cadeira;
    }

    public Integer getCabine() {
        return cabine;
    }

    public void setCabine(Integer cabine) {
        this.cabine = cabine;
    }

    public Integer getVagaSalao() {
        return vagaSalao;
    }

    public void setVagaSalao(Integer vagaSalao) {
        this.vagaSalao = vagaSalao;
    }

    public Double getValorCadeira() {
        return valorCadeira;
    }

    public void setValorCadeira(Double valorCadeira) {
        this.valorCadeira = valorCadeira;
    }

    public Double getValorCabine() {
        return valorCabine;
    }

    public void setValorCabine(Double valorCabine) {
        this.valorCabine = valorCabine;
    }

    public Double getValorVagaEspecial() {
        return valorVagaEspecial;
    }

    public void setValorVagaEspecial(Double valorVagaEspecial) {
        this.valorVagaEspecial = valorVagaEspecial;
    }

    public Double getValorVagaSalao() {
        return valorVagaSalao;
    }

    public void setValorVagaSalao(Double valorVagaSalao) {
        this.valorVagaSalao = valorVagaSalao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public TipoEspaco getTipoespaco() {
        return tipoespaco;
    }

    public void setTipoespaco(TipoEspaco tipoespaco) {
        this.tipoespaco = tipoespaco;
    }

    public List<TipoEspaco> getTipoEspacoList() {
        return tipoEspacoList;
    }

    public void setTipoEspacoList(List<TipoEspaco> tipoEspacoList) {
        this.tipoEspacoList = tipoEspacoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespaco != null ? idespaco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espaco)) {
            return false;
        }
        Espaco other = (Espaco) object;
        if ((this.idespaco == null && other.idespaco != null) || (this.idespaco != null && !this.idespaco.equals(other.idespaco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.espaco.Espaco[ idespaco=" + idespaco + " ]";
    }
    
}
