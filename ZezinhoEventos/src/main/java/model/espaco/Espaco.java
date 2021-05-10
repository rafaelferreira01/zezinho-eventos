/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.espaco;

import model.espaco.assento.VagaSalao;
import model.espaco.assento.Cadeira;
import model.espaco.assento.VagaEspecial;
import model.espaco.assento.Cabine;
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
import model.evento.Evento;

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Espaco.findAll", query = "SELECT e FROM Espaco e"),
    @NamedQuery(name = "Espaco.findByIdespaco", query = "SELECT e FROM Espaco e WHERE e.idespaco = :idespaco"),
    @NamedQuery(name = "Espaco.findByQuantvagaespecial", query = "SELECT e FROM Espaco e WHERE e.quantvagaespecial = :quantvagaespecial"),
    @NamedQuery(name = "Espaco.findByQuantcadeira", query = "SELECT e FROM Espaco e WHERE e.quantcadeira = :quantcadeira"),
    @NamedQuery(name = "Espaco.findByQuantcabine", query = "SELECT e FROM Espaco e WHERE e.quantcabine = :quantcabine"),
    @NamedQuery(name = "Espaco.findByQuantvagaSalao", query = "SELECT e FROM Espaco e WHERE e.quantvagaSalao = :quantvagaSalao"),
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
    private Integer quantvagaespecial;
    private Integer quantcadeira;
    private Integer quantcabine;
    private Integer quantvagaSalao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22, scale = 0)
    private Double valorCadeira;
    @Column(precision = 22, scale = 0)
    private Double valorCabine;
    @Column(precision = 22, scale = 0)
    private Double valorVagaEspecial;
    @Column(precision = 22, scale = 0)
    private Double valorVagaSalao;
    @OneToMany(mappedBy = "espaco")
    private List<VagaSalao> vagaSalaoList;
    @OneToMany(mappedBy = "espaco")
    private List<Cadeira> cadeiraList;
    @OneToMany(mappedBy = "espaco")
    private List<Cabine> cabineList;
    @JoinColumn(name = "evento", referencedColumnName = "idEvento")
    @ManyToOne
    private Evento evento;
    @JoinColumn(name = "tipoespaco", referencedColumnName = "idTipoEspaco")
    @ManyToOne
    private TipoEspaco tipoespaco;
    @OneToMany(mappedBy = "espaco")
    private List<VagaEspecial> vagaEspecialList;

    public Espaco() {
    }
    
        //

    public Espaco(Integer idespaco, Evento evento, TipoEspaco tipoespaco) {
        this.idespaco = idespaco;
        this.evento = evento;
        this.tipoespaco = tipoespaco;
    }

    public Espaco(Integer idespaco, Integer quantvagaespecial, Integer quantcadeira, Integer quantcabine, Integer quantvagaSalao, Double valorCadeira, Double valorCabine, Double valorVagaEspecial, Double valorVagaSalao, Evento evento, TipoEspaco tipoespaco) {
        this.idespaco = idespaco;
        this.quantvagaespecial = quantvagaespecial;
        this.quantcadeira = quantcadeira;
        this.quantcabine = quantcabine;
        this.quantvagaSalao = quantvagaSalao;
        this.valorCadeira = valorCadeira;
        this.valorCabine = valorCabine;
        this.valorVagaEspecial = valorVagaEspecial;
        this.valorVagaSalao = valorVagaSalao;
        this.evento = evento;
        this.tipoespaco = tipoespaco;
    }
    //

    public Espaco(Integer idespaco) {
        this.idespaco = idespaco;
    }

    public Integer getIdespaco() {
        return idespaco;
    }

    public void setIdespaco(Integer idespaco) {
        this.idespaco = idespaco;
    }

    public Integer getQuantvagaespecial() {
        return quantvagaespecial;
    }

    public void setQuantvagaespecial(Integer quantvagaespecial) {
        this.quantvagaespecial = quantvagaespecial;
    }

    public Integer getQuantcadeira() {
        return quantcadeira;
    }

    public void setQuantcadeira(Integer quantcadeira) {
        this.quantcadeira = quantcadeira;
    }

    public Integer getQuantcabine() {
        return quantcabine;
    }

    public void setQuantcabine(Integer quantcabine) {
        this.quantcabine = quantcabine;
    }

    public Integer getQuantvagaSalao() {
        return quantvagaSalao;
    }

    public void setQuantvagaSalao(Integer quantvagaSalao) {
        this.quantvagaSalao = quantvagaSalao;
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

    public List<VagaSalao> getVagaSalaoList() {
        return vagaSalaoList;
    }

    public void setVagaSalaoList(List<VagaSalao> vagaSalaoList) {
        this.vagaSalaoList = vagaSalaoList;
    }

    public List<Cadeira> getCadeiraList() {
        return cadeiraList;
    }

    public void setCadeiraList(List<Cadeira> cadeiraList) {
        this.cadeiraList = cadeiraList;
    }

    public List<Cabine> getCabineList() {
        return cabineList;
    }

    public void setCabineList(List<Cabine> cabineList) {
        this.cabineList = cabineList;
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

    public List<VagaEspecial> getVagaEspecialList() {
        return vagaEspecialList;
    }

    public void setVagaEspecialList(List<VagaEspecial> vagaEspecialList) {
        this.vagaEspecialList = vagaEspecialList;
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
        return "model.cliente.Espaco[ idespaco=" + idespaco + " ]";
    }
    
}
