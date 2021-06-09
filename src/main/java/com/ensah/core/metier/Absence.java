/***********************************************************************
 * Module:  Absence.java
 * Author:  Hp
 * Purpose: Defines the Class Absence
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid 8483cb8e-2f42-4216-a903-ea14449fe272 */
public class Absence {
   /** @pdOid 048e768f-529b-4b9b-984a-7b602ca61595 */
   private int idAbsence;
   /** @pdOid 12db9c3f-b9f3-4c16-86b5-580b93395cd5 */
   private java.util.Date dateHeureDebutAbsence;
   /** @pdOid 09a4d15e-0c7b-4020-a1f1-ccd24560fb6d */
   private java.util.Date dateHeureFinAbsence;
   /** @pdOid cf20f4da-5aea-44d2-8306-60e6bc1d67df */
   private int etat;
   /** @pdOid 36a659ce-b1db-4a34-bf2e-f85f408078c1 */
   private String typeSaisie;
   
   /** @pdRoleInfo migr=no name=PieceJustificative assc=Absence_PieceJustificative coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Set<PieceJustificative> pieceJustificative;
   /** @pdRoleInfo migr=no name=Inscription assc=Association_9 coll=java.util.Collection impl=java.util.HashSet mult=1..1 */
   public Inscription inscription;
   /** @pdRoleInfo migr=no name=TypeSeance assc=Association_11 coll=java.util.Collection impl=java.util.HashSet mult=1..1 */
   public TypeSeance typeSeance;
   /** @pdRoleInfo migr=no name=Enseignant assc=Association_20 coll=java.util.Collection impl=java.util.HashSet mult=1..1 */
   public Enseignant observateur;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<PieceJustificative> getPieceJustificative() {
      if (pieceJustificative == null)
         pieceJustificative = new java.util.HashSet<PieceJustificative>();
      return pieceJustificative;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPieceJustificative() {
      if (pieceJustificative == null)
         pieceJustificative = new java.util.HashSet<PieceJustificative>();
      return pieceJustificative.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPieceJustificative */
   public void setPieceJustificative(java.util.Collection<PieceJustificative> newPieceJustificative) {
      removeAllPieceJustificative();
      for (java.util.Iterator iter = newPieceJustificative.iterator(); iter.hasNext();)
         addPieceJustificative((PieceJustificative)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPieceJustificative */
   public void addPieceJustificative(PieceJustificative newPieceJustificative) {
      if (newPieceJustificative == null)
         return;
      if (this.pieceJustificative == null)
         this.pieceJustificative = new java.util.HashSet<PieceJustificative>();
      if (!this.pieceJustificative.contains(newPieceJustificative))
      {
         this.pieceJustificative.add(newPieceJustificative);
         newPieceJustificative.addAbsence(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPieceJustificative */
   public void removePieceJustificative(PieceJustificative oldPieceJustificative) {
      if (oldPieceJustificative == null)
         return;
      if (this.pieceJustificative != null)
         if (this.pieceJustificative.contains(oldPieceJustificative))
         {
            this.pieceJustificative.remove(oldPieceJustificative);
            oldPieceJustificative.removeAbsence(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPieceJustificative() {
      if (pieceJustificative != null)
      {
         PieceJustificative oldPieceJustificative;
         for (java.util.Iterator iter = getIteratorPieceJustificative(); iter.hasNext();)
         {
            oldPieceJustificative = (PieceJustificative)iter.next();
            iter.remove();
            oldPieceJustificative.removeAbsence(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Inscription getInscription() {
      return inscription;
   }
   
   /** @pdGenerated default parent setter
     * @param newInscription */
   public void setInscription(Inscription newInscription) {
      if (this.inscription == null || !this.inscription.equals(newInscription))
      {
         if (this.inscription != null)
         {
            Inscription oldInscription = this.inscription;
            this.inscription = null;
            oldInscription.removeAbsences(this);
         }
         if (newInscription != null)
         {
            this.inscription = newInscription;
            this.inscription.addAbsences(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TypeSeance getTypeSeance() {
      return typeSeance;
   }
   
   /** @pdGenerated default parent setter
     * @param newTypeSeance */
   public void setTypeSeance(TypeSeance newTypeSeance) {
      if (this.typeSeance == null || !this.typeSeance.equals(newTypeSeance))
      {
         if (this.typeSeance != null)
         {
            TypeSeance oldTypeSeance = this.typeSeance;
            this.typeSeance = null;
            oldTypeSeance.removeAbsences(this);
         }
         if (newTypeSeance != null)
         {
            this.typeSeance = newTypeSeance;
            this.typeSeance.addAbsences(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Enseignant getObservateur() {
      return observateur;
   }
   
   /** @pdGenerated default parent setter
     * @param newEnseignant */
   public void setObservateur(Enseignant newEnseignant) {
      if (this.observateur == null || !this.observateur.equals(newEnseignant))
      {
         if (this.observateur != null)
         {
            Enseignant oldEnseignant = this.observateur;
            this.observateur = null;
            oldEnseignant.removeAbsencesMarquees(this);
         }
         if (newEnseignant != null)
         {
            this.observateur = newEnseignant;
            this.observateur.addAbsencesMarquees(this);
         }
      }
   }

}