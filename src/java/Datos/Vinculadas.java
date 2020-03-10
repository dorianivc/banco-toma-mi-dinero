/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monica
 */
@Entity
@Table(name = "Vinculadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vinculadas.findAll", query = "SELECT v FROM Vinculadas v"),
    @NamedQuery(name = "Vinculadas.findByVinId", query = "SELECT v FROM Vinculadas v WHERE v.vinId = :vinId"),
    @NamedQuery(name = "Vinculadas.findByOwner", query = "SELECT v FROM Vinculadas v WHERE v.owner = :owner")})
public class Vinculadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "vin_id")
    private String vinId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "owner")
    private short owner;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente clienteidCliente;
    @JoinColumn(name = "Num_Cuenta_vinculada", referencedColumnName = "num_Cuenta")
    @ManyToOne(optional = false)
    private Cuenta numCuentavinculada;

    public Vinculadas() {
    }

    public Vinculadas(String vinId) {
        this.vinId = vinId;
    }

    public Vinculadas(String vinId, short owner) {
        this.vinId = vinId;
        this.owner = owner;
    }

    public String getVinId() {
        return vinId;
    }

    public void setVinId(String vinId) {
        this.vinId = vinId;
    }

    public short getOwner() {
        return owner;
    }

    public void setOwner(short owner) {
        this.owner = owner;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Cuenta getNumCuentavinculada() {
        return numCuentavinculada;
    }

    public void setNumCuentavinculada(Cuenta numCuentavinculada) {
        this.numCuentavinculada = numCuentavinculada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vinId != null ? vinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vinculadas)) {
            return false;
        }
        Vinculadas other = (Vinculadas) object;
        if ((this.vinId == null && other.vinId != null) || (this.vinId != null && !this.vinId.equals(other.vinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Vinculadas[ vinId=" + vinId + " ]";
    }
    
}
