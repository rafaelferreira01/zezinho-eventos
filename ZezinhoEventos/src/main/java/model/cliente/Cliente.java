/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cliente;

import model.evento.Evento;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import model.espaco.assento.Cabine;
import model.espaco.assento.Cadeira;
import model.espaco.assento.VagaEspecial;
import model.espaco.assento.VagaSalao;

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
    @JoinColumn(name = "cabine", referencedColumnName = "idCabine")
    @ManyToOne
    private Cabine cabine;
    @JoinColumn(name = "cadeira", referencedColumnName = "idCadeira")
    @ManyToOne
    private Cadeira cadeira;
    @JoinColumn(name = "evento", referencedColumnName = "idEvento")
    @ManyToOne
    private Evento evento;
    @JoinColumn(name = "vagaespecial", referencedColumnName = "idVagaEspecial")
    @ManyToOne
    private VagaEspecial vagaespecial;
    @JoinColumn(name = "vagasalao", referencedColumnName = "idVagasalao")
    @ManyToOne
    private VagaSalao vagasalao;

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

    public Cabine getCabine() {
        return cabine;
    }

    public void setCabine(Cabine cabine) {
        this.cabine = cabine;
    }

    public Cadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeira cadeira) {
        this.cadeira = cadeira;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public VagaEspecial getVagaespecial() {
        return vagaespecial;
    }

    public void setVagaespecial(VagaEspecial vagaespecial) {
        this.vagaespecial = vagaespecial;
    }

    public VagaSalao getVagasalao() {
        return vagasalao;
    }

    public void setVagasalao(VagaSalao vagasalao) {
        this.vagasalao = vagasalao;
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
        return "roda.testes.banco.Cliente[ cpf=" + cpf + " ]";
    }
    
}
