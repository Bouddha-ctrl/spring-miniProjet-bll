/***********************************************************************
 * Module:  Utilisateur.java
 * Author:  Hp
 * Purpose: Defines the Class Utilisateur
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid 69b6802e-d469-46d2-b663-588e96446f24 */
public class Utilisateur {
   /** @pdOid 349fa1eb-d021-4a9c-ae2b-65ca80e8af5e */
   private int idUtilisateur;
   /** @pdOid 2d5675ee-fe27-4e12-a3da-afcbe0354e71 */
   private String nom;
   /** @pdOid 44f82160-ef8b-4094-ba42-55aecf488887 */
   private String prenom;
   /** @pdOid 91451691-4f33-48cf-9cda-047f6c1ae4fc */
   private String cin;
   /** @pdOid 186a9890-eb10-43c9-bebc-2981c5f1f7d1 */
   private String email;
   /** @pdOid 3202da41-c953-46ba-be23-11f78c12264b */
   private String telephone;
   /** @pdOid 1d8d771b-d77b-4bd2-829d-e74084a73e3f */
   private String nomArabe;
   /** @pdOid 322083ce-14fd-46e1-9876-86777f2de8f7 */
   private String prenomArabe;
   /** @pdOid b4b63893-43e0-4f6a-ba9c-83279f298f73 */
   private String photo;
   
   /** @pdRoleInfo migr=no name=Compte assc=Association_7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Compte> comptes;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Compte> getComptes() {
      if (comptes == null)
         comptes = new java.util.HashSet<Compte>();
      return comptes;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorComptes() {
      if (comptes == null)
         comptes = new java.util.HashSet<Compte>();
      return comptes.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newComptes */
   public void setComptes(java.util.Collection<Compte> newComptes) {
      removeAllComptes();
      for (java.util.Iterator iter = newComptes.iterator(); iter.hasNext();)
         addComptes((Compte)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCompte */
   public void addComptes(Compte newCompte) {
      if (newCompte == null)
         return;
      if (this.comptes == null)
         this.comptes = new java.util.HashSet<Compte>();
      if (!this.comptes.contains(newCompte))
      {
         this.comptes.add(newCompte);
         newCompte.setProprietaire(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldCompte */
   public void removeComptes(Compte oldCompte) {
      if (oldCompte == null)
         return;
      if (this.comptes != null)
         if (this.comptes.contains(oldCompte))
         {
            this.comptes.remove(oldCompte);
            oldCompte.setProprietaire((Utilisateur)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllComptes() {
      if (comptes != null)
      {
         Compte oldCompte;
         for (java.util.Iterator iter = getIteratorComptes(); iter.hasNext();)
         {
            oldCompte = (Compte)iter.next();
            iter.remove();
            oldCompte.setProprietaire((Utilisateur)null);
         }
      }
   }

}