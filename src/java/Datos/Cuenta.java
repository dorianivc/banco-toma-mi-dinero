/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monica
 */
@Entity
@Table(name = "Cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByNumCuenta", query = "SELECT c FROM Cuenta c WHERE c.numCuenta = :numCuenta"),
    @NamedQuery(name = "Cuenta.findBySaldo", query = "SELECT c FROM Cuenta c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "Cuenta.findByLimiteTransferencia", query = "SELECT c FROM Cuenta c WHERE c.limiteTransferencia = :limiteTransferencia")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "num_Cuenta")
    private String numCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private float saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limite_transferencia")
    private int limiteTransferencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroCuenta")
    private List<Movimiento> movimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numCuentavinculada")
    private List<Vinculadas> vinculadasList;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente clienteidCliente;
    @JoinColumn(name = "Moneda_idMoneda", referencedColumnName = "idMoneda")
    @ManyToOne(optional = false)
    private Moneda monedaidMoneda;

    public Cuenta() {
    }

    public Cuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Cuenta(String numCuenta, float saldo, int limiteTransferencia) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.limiteTransferencia = limiteTransferencia;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getLimiteTransferencia() {
        return limiteTransferencia;
    }

    public void setLimiteTransferencia(int limiteTransferencia) {
        this.limiteTransferencia = limiteTransferencia;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    @XmlTransient
    public List<Vinculadas> getVinculadasList() {
        return vinculadasList;
    }

    public void setVinculadasList(List<Vinculadas> vinculadasList) {
        this.vinculadasList = vinculadasList;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Moneda getMonedaidMoneda() {
        return monedaidMoneda;
    }

    public void setMonedaidMoneda(Moneda monedaidMoneda) {
        this.monedaidMoneda = monedaidMoneda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCuenta != null ? numCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.numCuenta == null && other.numCuenta != null) || (this.numCuenta != null && !this.numCuenta.equals(other.numCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Cuenta[ numCuenta=" + numCuenta + " ]";
    }
    
}
