/***********************************************************************
 * Module:  Filiere.java
 * Author:  Hp
 * Purpose: Defines the Class Filiere
 ***********************************************************************/
package com.ensah.core.metier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import java.util.*;


/** @pdOid 0c7465cd-4988-4c54-9647-a3bccfd16c22 */

@Entity
public class Filiere {
   /** @pdOid 15c8c6d5-6e44-4ba3-abae-f5b94ce45409 */
	
	
	

	public Filiere( String idFiliere,
		 String titreFiliere, String codeFiliere,
		int anneeaccreditation,
		int anneeFinaccreditation) {
	this.idFiliere = idFiliere;
	this.titreFiliere = titreFiliere;
	this.codeFiliere = codeFiliere;
	this.anneeaccreditation = anneeaccreditation;
	this.anneeFinaccreditation = anneeFinaccreditation;
	}
	
	

	public Filiere() {
	}

	@Id
	@NotBlank(message = "This field is required")
	@Column
	private String idFiliere;

	@Column
	@NotBlank(message = "This field is required")
	private String titreFiliere;
	
	@Column
	@NotBlank(message = "This field is required")
	private String codeFiliere;
	
	@Column
	@NotNull(message = "This field is required")
	//@Pattern(regexp = "^[0-9]{4}$", message= "4 digits required")
	@Min(value = 1000, message = "4 digits required")
	@Max(value = 9999, message = "4 digits required")
	private int anneeaccreditation;
	
	@Column
	@NotNull(message = "This field is required")
	//@Pattern(regexp = "^[0-9]{4}$", message= "4 digits required")	
	@Range(min=1000,max = 9999, message = "4 digits required")
	private int anneeFinaccreditation;
   
	@OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
	public java.util.Set<Niveau> niveaux;

	@Transient
   	public java.util.Set<Coordination> periodeCoordination;
   
   
   public java.util.Set<Niveau> getNiveaux() {
      if (niveaux == null)
         niveaux = new java.util.HashSet<Niveau>();
      return niveaux;
   }
   
   public java.util.Iterator getIteratorNiveaux() {
      if (niveaux == null)
         niveaux = new java.util.HashSet<Niveau>();
      return niveaux.iterator();
   }
   
   public void setNiveaux(java.util.Collection<Niveau> newNiveaux) {
      removeAllNiveaux();
      for (java.util.Iterator iter = newNiveaux.iterator(); iter.hasNext();)
         addNiveaux((Niveau)iter.next());
   }
   
   public void addNiveaux(Niveau newNiveau) {
      if (newNiveau == null)
         return;
      if (this.niveaux == null)
         this.niveaux = new java.util.HashSet<Niveau>();
      if (!this.niveaux.contains(newNiveau))
      {
         this.niveaux.add(newNiveau);
         newNiveau.setFiliere(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldNiveau */
   public void removeNiveaux(Niveau oldNiveau) {
      if (oldNiveau == null)
         return;
      if (this.niveaux != null)
         if (this.niveaux.contains(oldNiveau))
         {
            this.niveaux.remove(oldNiveau);
            oldNiveau.setFiliere((Filiere)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNiveaux() {
      if (niveaux != null)
      {
         Niveau oldNiveau;
         for (java.util.Iterator iter = getIteratorNiveaux(); iter.hasNext();)
         {
            oldNiveau = (Niveau)iter.next();
            iter.remove();
            oldNiveau.setFiliere((Filiere)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Coordination> getPeriodeCoordination() {
      if (periodeCoordination == null)
         periodeCoordination = new java.util.HashSet<Coordination>();
      return periodeCoordination;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPeriodeCoordination() {
      if (periodeCoordination == null)
         periodeCoordination = new java.util.HashSet<Coordination>();
      return periodeCoordination.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPeriodeCoordination */
   public void setPeriodeCoordination(java.util.Collection<Coordination> newPeriodeCoordination) {
      removeAllPeriodeCoordination();
      for (java.util.Iterator iter = newPeriodeCoordination.iterator(); iter.hasNext();)
         addPeriodeCoordination((Coordination)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCoordination */
   public void addPeriodeCoordination(Coordination newCoordination) {
      if (newCoordination == null)
         return;
      if (this.periodeCoordination == null)
         this.periodeCoordination = new java.util.HashSet<Coordination>();
      if (!this.periodeCoordination.contains(newCoordination))
         this.periodeCoordination.add(newCoordination);
   }
   
   /** @pdGenerated default remove
     * @param oldCoordination */
   public void removePeriodeCoordination(Coordination oldCoordination) {
      if (oldCoordination == null)
         return;
      if (this.periodeCoordination != null)
         if (this.periodeCoordination.contains(oldCoordination))
            this.periodeCoordination.remove(oldCoordination);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPeriodeCoordination() {
      if (periodeCoordination != null)
         periodeCoordination.clear();
   }


	
	public String getIdFiliere() {
		return idFiliere;
	}
	
	
	
	public void setIdFiliere(String idFiliere) {
		this.idFiliere = idFiliere;
	}
	
	
	
	public String getTitreFiliere() {
		return titreFiliere;
	}
	
	
	
	public void setTitreFiliere(String titreFiliere) {
		this.titreFiliere = titreFiliere;
	}
	
	
	
	public String getCodeFiliere() {
		return codeFiliere;
	}
	
	
	
	public void setCodeFiliere(String codeFiliere) {
		this.codeFiliere = codeFiliere;
	}
	
	
	
	public int getAnneeaccreditation() {
		return anneeaccreditation;
	}
	
	
	
	public void setAnneeaccreditation(int anneeaccreditation) {
		this.anneeaccreditation = anneeaccreditation;
	}
	
	
	
	public int getAnneeFinaccreditation() {
		return anneeFinaccreditation;
	}
	
	
	
	public void setAnneeFinaccreditation(int anneeFinaccreditation) {
		this.anneeFinaccreditation = anneeFinaccreditation;
	}



	@Override
	public String toString() {
		return "Filiere [idFiliere=" + idFiliere + ", titreFiliere=" + titreFiliere + ", codeFiliere=" + codeFiliere
				+ ", anneeaccreditation=" + anneeaccreditation + ", anneeFinaccreditation=" + anneeFinaccreditation
				+ "]";
	}

	
   
}