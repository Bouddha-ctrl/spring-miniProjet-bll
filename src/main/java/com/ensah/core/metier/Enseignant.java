/***********************************************************************
 * Module:  Enseignant.java
 * Author:  Hp
 * Purpose: Defines the Class Enseignant
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Enseignant extends Utilisateur {

	private String specialite;
   

	@Transient
	public java.util.Set<Absence> absencesMarquees;
   
	@OneToMany(mappedBy = "coordonateur", cascade = CascadeType.ALL)
	public java.util.Set<Coordination> coordinations;


	public java.util.Set<Absence> getAbsencesMarquees() {
      if (absencesMarquees == null)
         absencesMarquees = new java.util.HashSet<Absence>();
      return absencesMarquees;
   }
   

	public java.util.Iterator getIteratorAbsencesMarquees() {
      if (absencesMarquees == null)
         absencesMarquees = new java.util.HashSet<Absence>();
      return absencesMarquees.iterator();
   }
   
   public void setAbsencesMarquees(java.util.Set<Absence> newAbsencesMarquees) {
      removeAllAbsencesMarquees();
      for (java.util.Iterator iter = newAbsencesMarquees.iterator(); iter.hasNext();)
         addAbsencesMarquees((Absence)iter.next());
   }
   
   public void addAbsencesMarquees(Absence newAbsence) {
      if (newAbsence == null)
         return;
      if (this.absencesMarquees == null)
         this.absencesMarquees = new java.util.HashSet<Absence>();
      if (!this.absencesMarquees.contains(newAbsence))
      {
         this.absencesMarquees.add(newAbsence);
         newAbsence.setObservateur(this);      
      }
   }
   
   public void removeAbsencesMarquees(Absence oldAbsence) {
      if (oldAbsence == null)
         return;
      if (this.absencesMarquees != null)
         if (this.absencesMarquees.contains(oldAbsence))
         {
            this.absencesMarquees.remove(oldAbsence);
            oldAbsence.setObservateur((Enseignant)null);
         }
   }
   
   public void removeAllAbsencesMarquees() {
      if (absencesMarquees != null)
      {
         Absence oldAbsence;
         for (java.util.Iterator iter = getIteratorAbsencesMarquees(); iter.hasNext();)
         {
            oldAbsence = (Absence)iter.next();
            iter.remove();
            oldAbsence.setObservateur((Enseignant)null);
         }
      }
   }
   
   /** @pdGenerated default getter */
   public java.util.Set<Coordination> getCoordinations() {
      if (coordinations == null)
         coordinations = new java.util.HashSet<Coordination>();
      return coordinations;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCoordinations() {
      if (coordinations == null)
         coordinations = new java.util.HashSet<Coordination>();
      return coordinations.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPeriodeCoordination */
   public void setCoordinations(java.util.Set<Coordination> newCoordination) {
      removeAllCoordinations();
      for (java.util.Iterator iter = newCoordination.iterator(); iter.hasNext();)
         addCoordinations((Coordination)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCoordination */
   public void addCoordinations(Coordination newCoordination) {
      if (newCoordination == null)
         return;
      if (this.coordinations == null)
         this.coordinations = new java.util.HashSet<Coordination>();
      if (!this.coordinations.contains(newCoordination))
         this.coordinations.add(newCoordination);
   }
   
   /** @pdGenerated default remove
     * @param oldCoordination */
   public void removeCoordinations(Coordination oldCoordination) {
      if (oldCoordination == null)
         return;
      if (this.coordinations != null)
         if (this.coordinations.contains(oldCoordination))
            this.coordinations.remove(oldCoordination);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCoordinations() {
      if (coordinations != null)
         coordinations.clear();
   }
	
	public String getSpecialite() {
		return specialite;
	}
	
	
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	   
   

}