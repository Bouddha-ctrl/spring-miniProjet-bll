/***********************************************************************
 * Module:  JournalisationEvenements.java
 * Author:  Hp
 * Purpose: Defines the Class JournalisationEvenements
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid eb559b6c-d123-4a70-bf19-d8f7d5091714 */
public class JournalisationEvenements {
   /** @pdOid 21490434-fcd5-4cfb-a029-9148a00cceb7 */
   private int idEvenement;
   /** @pdOid 399751c7-f06d-4048-8abd-5d63adbbaf4e */
   private String details;
   /** @pdOid d0b602cc-6cc6-45d1-97b4-12fbc4566e41 */
   private String adresseIP;
   /** @pdOid eede5e6c-c6a4-41aa-b86b-2c02497854ca */
   private java.util.Date DateHeure;
   /** @pdOid 3f8e544d-9b2b-493b-9f18-ebc7ab2e5424 */
   private String typeEvenement;
   /** @pdOid 7a6ad8b2-60e7-48ac-aee9-48fef518c1e5 */
   private String criticite;
   
   /** @pdRoleInfo migr=no name=Compte assc=Association_19 coll=java.util.Collection impl=java.util.HashSet mult=1..1 side=A */
   public Compte compte;
   
   
   /** @pdGenerated default parent getter */
   public Compte getCompte() {
      return compte;
   }
   
   /** @pdGenerated default parent setter
     * @param newCompte */
   public void setCompte(Compte newCompte) {
      if (this.compte == null || !this.compte.equals(newCompte))
      {
         if (this.compte != null)
         {
            Compte oldCompte = this.compte;
            this.compte = null;
            oldCompte.removeEvenements(this);
         }
         if (newCompte != null)
         {
            this.compte = newCompte;
            this.compte.addEvenements(this);
         }
      }
   }

}