package com.ensah.core.metier;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Coordination {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column
	private int idCoordination;
   
	private java.util.Date dateDebut;
   
	private java.util.Date dateFin;
   
	@ManyToOne
	@JoinColumn(name= "idEnseignant")
	public Enseignant coordonateur;

    @ManyToOne
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