/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.evento;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.validation.constraints.Size;
import model.cliente.Cliente;

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
    @NamedQuery(name = "Evento.findByCustoInicial", query = "SELECT e FROM Evento e WHERE e.custoInicial = :custoInicial"),
    @NamedQuery(name = "Evento.findByAceitameiaentrada", query = "SELECT e FROM Evento e WHERE e.aceitameiaentrada = :aceitameiaentrada")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idEvento;
    @Size(max = 45)
    @Column(length = 45)
    private String nomeEvento;
    @Temporal(TemporalType.DATE)
    private Date dataEvento;
    private Boolean capacidadeReduzida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22, scale = 0)
    private Double custoExtra;
    @Column(precision = 22, scale = 0)
    private Double custoInicial;
    private Boolean aceitameiaentrada;
    @OneToMany(mappedBy = "evento")
    private List<Cliente> clienteList;
    @JoinColumn(name = "cliente", referencedColumnName = "cpf")
    @ManyToOne
    private Cliente cliente;
    @JoinColumn(name = "tipoevento", referencedColumnName = "idTipoEvento")
    @ManyToOne
    private TipoEvento tipoevento;

    public Evento() {
    }
    
   //
    public Evento(Integer idEvento, String nomeEvento, Date dataEvento, boolean capacidadeReduzida, double custoExtra, double custoInicial) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.capacidadeReduzida = capacidadeReduzida;
        this.custoExtra = custoExtra;
        this.custoInicial = custoInicial;
    }

    public Evento(Integer idEvento, String nomeEvento, Date dataEvento, boolean capacidadeReduzida, double custoExtra, double custoInicial, TipoEvento tipoevento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.capacidadeReduzida = capacidadeReduzida;
        this.custoExtra = custoExtra;
        this.custoInicial = custoInicial;
        this.tipoevento = tipoevento;
    }

    public Evento(Integer idEvento, String nomeEvento, Date dataEvento, Boolean capacidadeReduzida, Double custoExtra, Double custoInicial, Boolean aceitameiaentrada, TipoEvento tipoevento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.capacidadeReduzida = capacidadeReduzida;
        this.custoExtra = custoExtra;
        this.custoInicial = custoInicial;
        this.aceitameiaentrada = aceitameiaentrada;
        this.tipoevento = tipoevento;
    }
    //
    
    public Boolean getAceitameiaentrada() {
        return aceitameiaentrada;
    }

    public void setAceitameiaentrada(Boolean aceitameiaentrada) {
        this.aceitameiaentrada = aceitameiaentrada;
    }
    
    public Evento(Integer idEvento) {
        this.idEvento = idEvento;
    }
    
    public String dataAmericana(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        return sdf.format(dataEvento);
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

    public Boolean getCapacidadeReduzida() {
        return capacidadeReduzida;
    }

    public void setCapacidadeReduzida(Boolean capacidadeReduzida) {
        this.capacidadeReduzida = capacidadeReduzida;
    }

    public Double getCustoExtra() {
        return custoExtra;
    }

    public void setCustoExtra(Double custoExtra) {
        this.custoExtra = custoExtra;
    }

    public Double getCustoInicial() {
        return custoInicial;
    }

    public void setCustoInicial(Double custoInicial) {
        this.custoInicial = custoInicial;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoEvento getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(TipoEvento tipoevento) {
        this.tipoevento = tipoevento;
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
        return "model.cliente.Evento[ idEvento=" + idEvento + " ]";
    }
    
}
