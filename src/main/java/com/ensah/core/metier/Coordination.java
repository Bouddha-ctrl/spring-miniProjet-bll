package com.ensah.core.metier;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Coordination {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column
	private int idCoordination;
	
	@NotNull(message = "This field is required")
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateDebut;
   
	@NotNull(message = "This field is required")
	@Temporal(TemporalType.DATE)
	private Date dateFin;
   
	@ManyToOne
	@JoinColumn(name= "idEnseignant")
	public Enseignant coordonateur;

    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name= "idFiliere")
    public Filiere filiere;
    
    
    
    
    public Enseignant getCoordonateur() {
		return coordonateur;
	}

	public void setCoordonateur(Enseignant newCoordonateur) {

		if (this.coordonateur == null || !this.coordonateur.equals(newCoordonateur))
        {
           if (this.coordonateur != null)
           {
        	   Enseignant oldCoordonateur = this.coordonateur;
              this.coordonateur = null;
              oldCoordonateur.removeCoordinations(this);
           }
           if (newCoordonateur != null)
           {
              this.coordonateur = newCoordonateur;
              this.coordonateur.addCoordinations(this);
           }
        }
	}

	public Filiere getFiliere() {
        return filiere;
     }
     
     public void setFiliere(Filiere newFiliere) {
        if (this.filiere == null || !this.filiere.equals(newFiliere))
        {
           if (this.filiere != null)
           {
              Filiere oldFiliere = this.filiere;
              this.filiere = null;
              oldFiliere.removePeriodeCoordination(this);
           }
           if (newFiliere != null)
           {
              this.filiere = newFiliere;
              this.filiere.addPeriodeCoordination(this);
           }
        }
     }
     

	public int getIdCoordination() {
		return idCoordination;
	}

	public void setIdCoordination(int idCoordination) {
		this.idCoordination = idCoordination;
	}

	public java.util.Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(java.util.Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public java.util.Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(java.util.Date dateFin) {
		this.dateFin = dateFin;
	}

    
    
}