/***********************************************************************
 * Module:  Notification.java
 * Author:  Hp
 * Purpose: Defines the Class Notification
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid 9c9169a2-ebce-4e12-9d94-259156f6a929 */
public class Notification {
   /** @pdOid afde4193-8090-475f-899f-323260e17e23 */
   private int idNotification;
   /** @pdOid ee9b63fb-a47e-45e4-bcb0-eafbda221440 */
   private String type;
   /** @pdOid 134a34e8-63f9-4afa-b5dd-cb918b8a696a */
   private String titre;
   /** @pdOid e1979fb9-a2fd-456c-8cbc-d0080ef3cac8 */
   private String texte;
   /** @pdOid 1cc59977-bf8a-48a1-ae2e-c035c6dad223 */
   private java.util.Date dateCreation;
   /** @pdOid 91800e55-4dff-460c-a49c-2afc126f51b5 */
   private int etat;
   
   /** @pdRoleInfo migr=no name=Compte assc=Association_10 coll=java.util.Collection impl=java.util.HashSet mult=1..1 side=A */
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
            oldCompte.removeNotifications(this);
         }
         if (newCompte != null)
         {
            this.compte = newCompte;
            this.compte.addNotifications(this);
         }
      }
   }

}