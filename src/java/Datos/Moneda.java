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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monica
 */
@Entity
@Table(name = "Moneda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moneda.findAll", query = "SELECT m FROM Moneda m"),
    @NamedQuery(name = "Moneda.findByIdMoneda", query = "SELECT m FROM Moneda m WHERE m.idMoneda = :idMoneda"),
    @NamedQuery(name = "Moneda.findByTasaDeInteres", query = "SELECT m FROM Moneda m WHERE m.tasaDeInteres = :tasaDeInteres"),
    @NamedQuery(name = "Moneda.findByTipoDeCambio", query = "SELECT m FROM Moneda m WHERE m.tipoDeCambio = :tipoDeCambio")})
public class Moneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMoneda")
    private Integer idMoneda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasa_de_interes")
    private float tasaDeInteres;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tipo_de_cambio")
    private Float tipoDeCambio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monedaidMoneda")
    private List<Cuenta> cuentaList;

    public Moneda() {
    }

    public Moneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Moneda(Integer idMoneda, float tasaDeInteres) {
        this.idMoneda = idMoneda;
        this.tasaDeInteres = tasaDeInteres;
    }

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public float getTasaDeInteres() {
        return tasaDeInteres;
    }

    public void setTasaDeInteres(float tasaDeInteres) {
        this.tasaDeInteres = tasaDeInteres;
    }

    public Float getTipoDeCambio() {
        return tipoDeCambio;
    }

    public void setTipoDeCambio(Float tipoDeCambio) {
        this.tipoDeCambio = tipoDeCambio;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMoneda != null ? idMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moneda)) {
            return false;
        }
        Moneda other = (Moneda) object;
        if ((this.idMoneda == null && other.idMoneda != null) || (this.idMoneda != null && !this.idMoneda.equals(other.idMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Moneda[ idMoneda=" + idMoneda + " ]";
    }
    
}
