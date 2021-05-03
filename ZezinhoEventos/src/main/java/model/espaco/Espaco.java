/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.espaco;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Espaco.findByVagaespecial", query = "SELECT e FROM Espaco e WHERE e.vagaespecial = :vagaespecial"),
    @NamedQuery(name = "Espaco.findByCadeira", query = "SELECT e FROM Espaco e WHERE e.cadeira = :cadeira"),
    @NamedQuery(name = "Espaco.findByCabine", query = "SELECT e FROM Espaco e WHERE e.cabine = :cabine"),
    @NamedQuery(name = "Espaco.findByVagaSalao", query = "SELECT e FROM Espaco e WHERE e.vagaSalao = :vagaSalao")})
public class Espaco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idespaco;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int vagaespecial;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cadeira;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cabine;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int vagaSalao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espaco")
    private List<VagaSalao> vagaSalaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espaco")
    private List<Cadeira> cadeiraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espaco")
    private List<Cabine> cabineList;
    @JoinColumn(name = "evento", referencedColumnName = "idEvento", nullable = false)
    @ManyToOne(optional = false)
    private Evento evento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espaco")
    private List<TipoEspaco> tipoEspacoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espaco")
    private List<VagaEspecial> vagaEspecialList;

    public Espaco() {
    }

    public Espaco(Integer idespaco) {
        this.idespaco = idespaco;
    }

    public Espaco(Integer idespaco, int vagaespecial, int cadeira, int cabine, int vagaSalao) {
        this.idespaco = idespaco;
        this.vagaespecial = vagaespecial;
        this.cadeira = cadeira;
        this.cabine = cabine;
        this.vagaSalao = vagaSalao;
    }

    public Integer getIdespaco() {
        return idespaco;
    }

    public void setIdespaco(Integer idespaco) {
        this.idespaco = idespaco;
    }

    public int getVagaespecial() {
        return vagaespecial;
    }

    public void setVagaespecial(int vagaespecial) {
        this.vagaespecial = vagaespecial;
    }

    public int getCadeira() {
        return cadeira;
    }

    public void setCadeira(int cadeira) {
        this.cadeira = cadeira;
    }

    public int getCabine() {
        return cabine;
    }

    public void setCabine(int cabine) {
        this.cabine = cabine;
    }

    public int getVagaSalao() {
        return vagaSalao;
    }

    public void setVagaSalao(int vagaSalao) {
        this.vagaSalao = vagaSalao;
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

    public List<TipoEspaco> getTipoEspacoList() {
        return tipoEspacoList;
    }

    public void setTipoEspacoList(List<TipoEspaco> tipoEspacoList) {
        this.tipoEspacoList = tipoEspacoList;
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
        return "model.Espaco[ idespaco=" + idespaco + " ]";
    }
    
}
