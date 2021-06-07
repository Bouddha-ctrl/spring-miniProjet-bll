/***********************************************************************
 * Module:  Etudiant.java
 * Author:  Hp
 * Purpose: Defines the Class Etudiant
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid 8f0686c1-ebf4-444c-b8b0-0abc8bed824f */
public class Etudiant extends Utilisateur {
   /** @pdOid 978fdefe-9096-4e18-aedc-955e45f96847 */
   private String cne;
   /** @pdOid 4beea913-5c0e-41c9-868b-bb85bea5024a */
   private java.util.Date dateNaissance;
   
   /** @pdRoleInfo migr=no name=Inscription assc=Association_1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Inscription> inscriptions;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Inscription> getInscriptions() {
      if (inscriptions == null)
         inscriptions = new java.util.HashSet<Inscription>();
      return inscriptions;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorInscriptions() {
      if (inscriptions == null)
         inscriptions = new java.util.HashSet<Inscription>();
      return inscriptions.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newInscriptions */
   public void setInscriptions(java.util.Collection<Inscription> newInscriptions) {
      removeAllInscriptions();
      for (java.util.Iterator iter = newInscriptions.iterator(); iter.hasNext();)
         addInscriptions((Inscription)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newInscription */
   public void addInscriptions(Inscription newInscription) {
      if (newInscription == null)
         return;
      if (this.inscriptions == null)
         this.inscriptions = new java.util.HashSet<Inscription>();
      if (!this.inscriptions.contains(newInscription))
      {
         this.inscriptions.add(newInscription);
         newInscription.setEtudiant(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldInscription */
   public void removeInscriptions(Inscription oldInscription) {
      if (oldInscription == null)
         return;
      if (this.inscriptions != null)
         if (this.inscriptions.contains(oldInscription))
         {
            this.inscriptions.remove(oldInscription);
            oldInscription.setEtudiant((Etudiant)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllInscriptions() {
      if (inscriptions != null)
      {
         Inscription oldInscription;
         for (java.util.Iterator iter = getIteratorInscriptions(); iter.hasNext();)
         {
            oldInscription = (Inscription)iter.next();
            iter.remove();
            oldInscription.setEtudiant((Etudiant)null);
         }
      }
   }

}