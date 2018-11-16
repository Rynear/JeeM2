/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author felix
 */
@Entity
@Table(name = "prof")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prof.findAll", query = "SELECT p FROM Prof p")
    , @NamedQuery(name = "Prof.findByIdP", query = "SELECT p FROM Prof p WHERE p.idP = :idP")
    , @NamedQuery(name = "Prof.findByNomP", query = "SELECT p FROM Prof p WHERE p.nomP = :nomP")
    , @NamedQuery(name = "Prof.findByPrenomP", query = "SELECT p FROM Prof p WHERE p.prenomP = :prenomP")
    , @NamedQuery(name = "Prof.findBySexeP", query = "SELECT p FROM Prof p WHERE p.sexeP = :sexeP")
    , @NamedQuery(name = "Prof.findByNiveauMaxP", query = "SELECT p FROM Prof p WHERE p.niveauMaxP = :niveauMaxP")
    , @NamedQuery(name = "Prof.findByMdpP", query = "SELECT p FROM Prof p WHERE p.mdpP = :mdpP")})
public class Prof implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdP")
    private Integer idP;
    @Size(max = 100)
    @Column(name = "NomP")
    private String nomP;
    @Size(max = 100)
    @Column(name = "PrenomP")
    private String prenomP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SexeP")
    private int sexeP;
    @Column(name = "NiveauMaxP")
    private Short niveauMaxP;
    @Size(max = 50)
    @Column(name = "mdpP")
    private String mdpP;
    @OneToMany(mappedBy = "idP")
    private Collection<Cours> coursCollection;

    public Prof() {
    }

    public Prof(Integer idP) {
        this.idP = idP;
    }

    public Prof(Integer idP, int sexeP) {
        this.idP = idP;
        this.sexeP = sexeP;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public int getSexeP() {
        return sexeP;
    }

    public void setSexeP(int sexeP) {
        this.sexeP = sexeP;
    }

    public Short getNiveauMaxP() {
        return niveauMaxP;
    }

    public void setNiveauMaxP(Short niveauMaxP) {
        this.niveauMaxP = niveauMaxP;
    }

    public String getMdpP() {
        return mdpP;
    }

    public void setMdpP(String mdpP) {
        this.mdpP = mdpP;
    }

    @XmlTransient
    public Collection<Cours> getCoursCollection() {
        return coursCollection;
    }

    public void setCoursCollection(Collection<Cours> coursCollection) {
        this.coursCollection = coursCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prof)) {
            return false;
        }
        Prof other = (Prof) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prof[ idP=" + idP + " ]";
    }
    
}
