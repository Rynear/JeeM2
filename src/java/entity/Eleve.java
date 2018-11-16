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
@Table(name = "eleve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e")
    , @NamedQuery(name = "Eleve.findByIdE", query = "SELECT e FROM Eleve e WHERE e.idE = :idE")
    , @NamedQuery(name = "Eleve.findByNomE", query = "SELECT e FROM Eleve e WHERE e.nomE = :nomE")
    , @NamedQuery(name = "Eleve.findByPrenomE", query = "SELECT e FROM Eleve e WHERE e.prenomE = :prenomE")
    , @NamedQuery(name = "Eleve.findBySexeE", query = "SELECT e FROM Eleve e WHERE e.sexeE = :sexeE")
    , @NamedQuery(name = "Eleve.findByAgeE", query = "SELECT e FROM Eleve e WHERE e.ageE = :ageE")
    , @NamedQuery(name = "Eleve.findByNiveauE", query = "SELECT e FROM Eleve e WHERE e.niveauE = :niveauE")
    , @NamedQuery(name = "Eleve.findByMdpE", query = "SELECT e FROM Eleve e WHERE e.mdpE = :mdpE")})
public class Eleve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdE")
    private Integer idE;
    @Size(max = 100)
    @Column(name = "NomE")
    private String nomE;
    @Size(max = 100)
    @Column(name = "PrenomE")
    private String prenomE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SexeE")
    private int sexeE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AgeE")
    private int ageE;
    @Column(name = "NiveauE")
    private Short niveauE;
    @Size(max = 50)
    @Column(name = "mdpE")
    private String mdpE;
    @OneToMany(mappedBy = "idE")
    private Collection<Cours> coursCollection;

    public Eleve() {
    }

    public Eleve(Integer idE) {
        this.idE = idE;
    }

    public Eleve(Integer idE, int sexeE, int ageE) {
        this.idE = idE;
        this.sexeE = sexeE;
        this.ageE = ageE;
    }

    public Integer getIdE() {
        return idE;
    }

    public void setIdE(Integer idE) {
        this.idE = idE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public int getSexeE() {
        return sexeE;
    }

    public void setSexeE(int sexeE) {
        this.sexeE = sexeE;
    }

    public int getAgeE() {
        return ageE;
    }

    public void setAgeE(int ageE) {
        this.ageE = ageE;
    }

    public Short getNiveauE() {
        return niveauE;
    }

    public void setNiveauE(Short niveauE) {
        this.niveauE = niveauE;
    }

    public String getMdpE() {
        return mdpE;
    }

    public void setMdpE(String mdpE) {
        this.mdpE = mdpE;
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
        hash += (idE != null ? idE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.idE == null && other.idE != null) || (this.idE != null && !this.idE.equals(other.idE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Eleve[ idE=" + idE + " ]";
    }
    
}
