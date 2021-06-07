/***********************************************************************
 * Module:  Enseignant.java
 * Author:  Hp
 * Purpose: Defines the Class Enseignant
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid 38397f51-cb50-4ffb-bff4-e292468ed765 */
public class Enseignant extends Utilisateur {
   /** @pdOid 2029c5fc-595f-48c7-a618-5a92951a75c6 */
   private String specialite;
   
   /** @pdRoleInfo migr=no name=Absence assc=Association_20 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Absence> absencesMarquees;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Absence> getAbsencesMarquees() {
      if (absencesMarquees == null)
         absencesMarquees = new java.util.HashSet<Absence>();
      return absencesMarquees;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAbsencesMarquees() {
      if (absencesMarquees == null)
         absencesMarquees = new java.util.HashSet<Absence>();
      return absencesMarquees.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAbsencesMarquees */
   public void setAbsencesMarquees(java.util.Collection<Absence> newAbsencesMarquees) {
      removeAllAbsencesMarquees();
      for (java.util.Iterator iter = newAbsencesMarquees.iterator(); iter.hasNext();)
         addAbsencesMarquees((Absence)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAbsence */
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
   
   /** @pdGenerated default remove
     * @param oldAbsence */
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
   
   /** @pdGenerated default removeAll */
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

}