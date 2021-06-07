/***********************************************************************
 * Module:  Role.java
 * Author:  Hp
 * Purpose: Defines the Class Role
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid df391f00-4c90-4c54-ae7f-e19f19f27b1c */
public class Role {
   /** @pdOid e1715d86-b406-4a55-b3a3-974997a116fc */
   private int idRole;
   /** @pdOid 5b09b29c-da06-4f43-a4fa-aba5947b0dac */
   private String nomRole;
   
   /** @pdRoleInfo migr=no name=Compte assc=Association_6 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
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
         newCompte.setRole(this);      
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
            oldCompte.setRole((Role)null);
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
            oldCompte.setRole((Role)null);
         }
      }
   }

}