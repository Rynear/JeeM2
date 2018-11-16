/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c")
    , @NamedQuery(name = "Cours.findByIdC", query = "SELECT c FROM Cours c WHERE c.idC = :idC")
    , @NamedQuery(name = "Cours.findByDateHeureC", query = "SELECT c FROM Cours c WHERE c.dateHeureC = :dateHeureC")
    , @NamedQuery(name = "Cours.findByCommentaireC", query = "SELECT c FROM Cours c WHERE c.commentaireC = :commentaireC")})
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdC")
    private Integer idC;
    @Column(name = "DateHeureC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureC;
    @Size(max = 250)
    @Column(name = "CommentaireC")
    private String commentaireC;
    @JoinColumn(name = "IdE", referencedColumnName = "IdE")
    @ManyToOne
    private Eleve idE;
    @JoinColumn(name = "IdP", referencedColumnName = "IdP")
    @ManyToOne
    private Prof idP;

    public Cours() {
    }

    public Cours(Integer idC) {
        this.idC = idC;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public Date getDateHeureC() {
        return dateHeureC;
    }

    public void setDateHeureC(Date dateHeureC) {
        this.dateHeureC = dateHeureC;
    }

    public String getCommentaireC() {
        return commentaireC;
    }

    public void setCommentaireC(String commentaireC) {
        this.commentaireC = commentaireC;
    }

    public Eleve getIdE() {
        return idE;
    }

    public void setIdE(Eleve idE) {
        this.idE = idE;
    }

    public Prof getIdP() {
        return idP;
    }

    public void setIdP(Prof idP) {
        this.idP = idP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idC != null ? idC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.idC == null && other.idC != null) || (this.idC != null && !this.idC.equals(other.idC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cours[ idC=" + idC + " ]";
    }
    
}
