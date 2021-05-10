/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cliente;

import model.espaco.assento.VagaSalao;
import model.espaco.assento.Cadeira;
import model.espaco.assento.VagaEspecial;
import model.espaco.assento.Cabine;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import model.evento.Evento;
import model.cliente.Cliente;
import model.evento.EventoCliente;

/**
 *
 * @author suporte
 */
@Entity
@Table(catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nome;
    @OneToMany(mappedBy = "cliente")
    private List<VagaSalao> vagaSalaoList;
    @JoinColumn(name = "evento", referencedColumnName = "idEvento")
    @ManyToOne
    private Evento evento;
    @OneToMany(mappedBy = "cliente")
    private List<Evento> eventoList;
    @OneToMany(mappedBy = "cliente")
    private List<Cadeira> cadeiraList;
    @OneToMany(mappedBy = "cliente")
    private List<Cabine> cabineList;
    @OneToMany(mappedBy = "cliente")
    private List<VagaEspecial> vagaEspecialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<EventoCliente> eventoClienteList;

    public Cliente() {
    }

    public Cliente(Integer cpf) {
        this.cpf = cpf;
    }

    public Cliente(Integer cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<VagaSalao> getVagaSalaoList() {
        return vagaSalaoList;
    }

    public void setVagaSalaoList(List<VagaSalao> vagaSalaoList) {
        this.vagaSalaoList = vagaSalaoList;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
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

    public List<VagaEspecial> getVagaEspecialList() {
        return vagaEspecialList;
    }

    public void setVagaEspecialList(List<VagaEspecial> vagaEspecialList) {
        this.vagaEspecialList = vagaEspecialList;
    }

    public List<EventoCliente> getEventoClienteList() {
        return eventoClienteList;
    }

    public void setEventoClienteList(List<EventoCliente> eventoClienteList) {
        this.eventoClienteList = eventoClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.cliente.Cliente[ cpf=" + cpf + " ]";
    }
    
}
