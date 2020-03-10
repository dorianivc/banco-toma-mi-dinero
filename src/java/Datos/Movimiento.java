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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monica
 */
@Entity
@Table(name = "Movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findByMovId", query = "SELECT m FROM Movimiento m WHERE m.movId = :movId"),
    @NamedQuery(name = "Movimiento.findByMonto", query = "SELECT m FROM Movimiento m WHERE m.monto = :monto"),
    @NamedQuery(name = "Movimiento.findByMovFecha", query = "SELECT m FROM Movimiento m WHERE m.movFecha = :movFecha")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mov_id")
    private Integer movId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto")
    private float monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mov_fecha")
    private int movFecha;
    @JoinColumn(name = "numero_cuenta", referencedColumnName = "num_Cuenta")
    @ManyToOne(optional = false)
    private Cuenta numeroCuenta;

    public Movimiento() {
    }

    public Movimiento(Integer movId) {
        this.movId = movId;
    }

    public Movimiento(Integer movId, float monto, int movFecha) {
        this.movId = movId;
        this.monto = monto;
        this.movFecha = movFecha;
    }

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getMovFecha() {
        return movFecha;
    }

    public void setMovFecha(int movFecha) {
        this.movFecha = movFecha;
    }

    public Cuenta getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Cuenta numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movId != null ? movId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.movId == null && other.movId != null) || (this.movId != null && !this.movId.equals(other.movId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Movimiento[ movId=" + movId + " ]";
    }
    
}
