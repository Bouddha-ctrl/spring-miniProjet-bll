/***********************************************************************
 * Module:  Inscription.java
 * Author:  Hp
 * Purpose: Defines the Class Inscription
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid dee018b8-171b-4097-9f3e-a4eb0bb1fe9c */
public class Inscription {
   /** @pdOid 3beb6f08-3ab3-40ee-9842-9c1be3b14098 */
   private int idInscription;
   /** @pdOid cf59fb6f-5289-4b61-87b0-a6dd34838048 */
   private int annee;
   /** @pdOid 76c8f794-2f29-414d-9fe0-7f0577645026 */
   private int etat;
   
   /** @pdRoleInfo migr=no name=Niveau assc=Association_2 coll=java.util.Collection impl=java.util.HashSet mult=1..1 */
   public Niveau inscriptions;
   /** @pdRoleInfo migr=no name=Etudiant assc=Association_1 coll=java.util.Collection impl=java.util.HashSet mult=1..1 side=A */
   public Etudiant etudiant;
   /** @pdRoleInfo migr=no name=Absence assc=Association_9 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Absence> absences;
   
   
   /** @pdGenerated default parent getter */
   public Niveau getInscriptions() {
      return inscriptions;
   }
   
   /** @pdGenerated default parent setter
     * @param newNiveau */
   public void setInscriptions(Niveau newNiveau) {
      if (this.inscriptions == null || !this.inscriptions.equals(newNiveau))
      {
         if (this.inscriptions != null)
         {
            Niveau oldNiveau = this.inscriptions;
            this.inscriptions = null;
            oldNiveau.removeNiveau(this);
         }
         if (newNiveau != null)
         {
            this.inscriptions = newNiveau;
            this.inscriptions.addNiveau(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Etudiant getEtudiant() {
      return etudiant;
   }
   
   /** @pdGenerated default parent setter
     * @param newEtudiant */
   public void setEtudiant(Etudiant newEtudiant) {
      if (this.etudiant == null || !this.etudiant.equals(newEtudiant))
      {
         if (this.etudiant != null)
         {
            Etudiant oldEtudiant = this.etudiant;
            this.etudiant = null;
            oldEtudiant.removeInscriptions(this);
         }
         if (newEtudiant != null)
         {
            this.etudiant = newEtudiant;
            this.etudiant.addInscriptions(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Absence> getAbsences() {
      if (absences == null)
         absences = new java.util.HashSet<Absence>();
      return absences;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAbsences() {
      if (absences == null)
         absences = new java.util.HashSet<Absence>();
      return absences.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAbsences */
   public void setAbsences(java.util.Collection<Absence> newAbsences) {
      removeAllAbsences();
      for (java.util.Iterator iter = newAbsences.iterator(); iter.hasNext();)
         addAbsences((Absence)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAbsence */
   public void addAbsences(Absence newAbsence) {
      if (newAbsence == null)
         return;
      if (this.absences == null)
         this.absences = new java.util.HashSet<Absence>();
      if (!this.absences.contains(newAbsence))
      {
         this.absences.add(newAbsence);
         newAbsence.setInscription(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAbsence */
   public void removeAbsences(Absence oldAbsence) {
      if (oldAbsence == null)
         return;
      if (this.absences != null)
         if (this.absences.contains(oldAbsence))
         {
            this.absences.remove(oldAbsence);
            oldAbsence.setInscription((Inscription)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAbsences() {
      if (absences != null)
      {
         Absence oldAbsence;
         for (java.util.Iterator iter = getIteratorAbsences(); iter.hasNext();)
         {
            oldAbsence = (Absence)iter.next();
            iter.remove();
            oldAbsence.setInscription((Inscription)null);
         }
      }
   }

}