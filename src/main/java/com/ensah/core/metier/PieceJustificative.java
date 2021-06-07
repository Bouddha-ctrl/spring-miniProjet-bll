/***********************************************************************
 * Module:  PieceJustificative.java
 * Author:  Hp
 * Purpose: Defines the Class PieceJustificative
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid 0c4dba96-661b-4f2c-859e-f97f5b23e250 */
public class PieceJustificative {
   /** @pdOid 19ee710b-d98b-44d7-b776-196a463f26de */
   private int idPieceJustificative;
   /** @pdOid 39d85cbd-6a79-4342-b3f3-53301159568a */
   private String cheminFichier;
   /** @pdOid 0a35b4fd-60fd-4d3e-8d8e-d4ffb2b6cf5d */
   private String intitule;
   /** @pdOid d235c0ba-bb33-4bf9-bb4c-d0e82194b17a */
   private java.util.Date dateLivraison;
   /** @pdOid 54dca18f-55bc-4f30-894d-19972a9e3707 */
   private int etat;
   /** @pdOid c414ce5d-3d53-4743-abc6-b3cc6aa86de7 */
   private String source;
   
   /** @pdRoleInfo migr=no name=Absence assc=Absence_PieceJustificative coll=java.util.Collection impl=java.util.HashSet mult=1..* side=A */
   public java.util.Collection<Absence> absence;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Absence> getAbsence() {
      if (absence == null)
         absence = new java.util.HashSet<Absence>();
      return absence;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAbsence() {
      if (absence == null)
         absence = new java.util.HashSet<Absence>();
      return absence.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAbsence */
   public void setAbsence(java.util.Collection<Absence> newAbsence) {
      removeAllAbsence();
      for (java.util.Iterator iter = newAbsence.iterator(); iter.hasNext();)
         addAbsence((Absence)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAbsence */
   public void addAbsence(Absence newAbsence) {
      if (newAbsence == null)
         return;
      if (this.absence == null)
         this.absence = new java.util.HashSet<Absence>();
      if (!this.absence.contains(newAbsence))
      {
         this.absence.add(newAbsence);
         newAbsence.addPieceJustificative(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAbsence */
   public void removeAbsence(Absence oldAbsence) {
      if (oldAbsence == null)
         return;
      if (this.absence != null)
         if (this.absence.contains(oldAbsence))
         {
            this.absence.remove(oldAbsence);
            oldAbsence.removePieceJustificative(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAbsence() {
      if (absence != null)
      {
         Absence oldAbsence;
         for (java.util.Iterator iter = getIteratorAbsence(); iter.hasNext();)
         {
            oldAbsence = (Absence)iter.next();
            iter.remove();
            oldAbsence.removePieceJustificative(this);
         }
      }
   }

}