/***********************************************************************
 * Module:  TypeSeance.java
 * Author:  Hp
 * Purpose: Defines the Class TypeSeance
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid c1dd5e9d-63fa-469d-a983-4dee2e5304cb */
public class TypeSeance {
   /** @pdOid 345099c1-09e5-4d81-80fc-7d18aca07842 */
   private int idTypeSeance;
   /** @pdOid 9d2ee56d-2da0-404f-b17a-ecf6473f99d2 */
   private String intitule;
   /** @pdOid 715ca2ee-2306-4aab-bc37-c2fbd7575c7d */
   private String alias;
   
   /** @pdRoleInfo migr=no name=Absence assc=Association_11 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Absence> absences;
   
   
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
         newAbsence.setTypeSeance(this);      
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
            oldAbsence.setTypeSeance((TypeSeance)null);
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
            oldAbsence.setTypeSeance((TypeSeance)null);
         }
      }
   }

}