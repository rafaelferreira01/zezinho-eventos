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
import model.cliente.Cliente;

/**
 *
 * @author suporte
 */
@Entity
@Table(name = "evento_cliente", catalog = "zezinho_eventos", schema = "")
@NamedQueries({
    @NamedQuery(name = "EventoCliente.findAll", query = "SELECT e FROM EventoCliente e"),
    @NamedQuery(name = "EventoCliente.findById", query = "SELECT e FROM EventoCliente e WHERE e.id = :id")})
public class EventoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "cliente", referencedColumnName = "cpf", nullable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "evento", referencedColumnName = "idEvento", nullable = false)
    @ManyToOne(optional = false)
    private Evento evento;

    public EventoCliente() {
    }
    
    //
    public EventoCliente(Integer id, Cliente cliente, Evento evento) {
        this.id = id;
        this.cliente = cliente;
        this.evento = evento;
    }
    //

    public EventoCliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoCliente)) {
            return false;
        }
        EventoCliente other = (EventoCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.cliente.EventoCliente[ id=" + id + " ]";
    }
    
}
