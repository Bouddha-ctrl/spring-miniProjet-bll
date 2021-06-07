/***********************************************************************
 * Module:  Message.java
 * Author:  Hp
 * Purpose: Defines the Class Message
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid b18eef66-7ae4-449e-ac18-a6786c57e172 */
public class Message {
   /** @pdOid 583e78f2-2168-4733-b77a-bd9bb2de9e60 */
   private int idMessage;
   /** @pdOid 5e86a64d-2208-497a-bb79-08ba5de3d4f8 */
   private String texte;
   /** @pdOid 0ca94b69-f666-41c1-bd55-b304eada0e14 */
   private java.util.Date dateHeure;
   
   /** @pdRoleInfo migr=no name=Conversation assc=Association_14 coll=java.util.Collection impl=java.util.HashSet mult=1..1 */
   public Conversation conversation;
   /** @pdRoleInfo migr=no name=Compte assc=Association_12 coll=java.util.Collection impl=java.util.HashSet mult=1..1 side=A */
   public Compte expediteur;
   /** @pdRoleInfo migr=no name=Compte assc=Association_13 coll=java.util.Collection impl=java.util.HashSet mult=1..1 side=A */
   public Compte destinataire;
   
   
   /** @pdGenerated default parent getter */
   public Conversation getConversation() {
      return conversation;
   }
   
   /** @pdGenerated default parent setter
     * @param newConversation */
   public void setConversation(Conversation newConversation) {
      if (this.conversation == null || !this.conversation.equals(newConversation))
      {
         if (this.conversation != null)
         {
            Conversation oldConversation = this.conversation;
            this.conversation = null;
            oldConversation.removeMessages(this);
         }
         if (newConversation != null)
         {
            this.conversation = newConversation;
            this.conversation.addMessages(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Compte getExpediteur() {
      return expediteur;
   }
   
   /** @pdGenerated default parent setter
     * @param newCompte */
   public void setExpediteur(Compte newCompte) {
      if (this.expediteur == null || !this.expediteur.equals(newCompte))
      {
         if (this.expediteur != null)
         {
            Compte oldCompte = this.expediteur;
            this.expediteur = null;
            oldCompte.removeMessagesEnvoyes(this);
         }
         if (newCompte != null)
         {
            this.expediteur = newCompte;
            this.expediteur.addMessagesEnvoyes(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Compte getDestinataire() {
      return destinataire;
   }
   
   /** @pdGenerated default parent setter
     * @param newCompte */
   public void setDestinataire(Compte newCompte) {
      if (this.destinataire == null || !this.destinataire.equals(newCompte))
      {
         if (this.destinataire != null)
         {
            Compte oldCompte = this.destinataire;
            this.destinataire = null;
            oldCompte.removeMessagesReçus(this);
         }
         if (newCompte != null)
         {
            this.destinataire = newCompte;
            this.destinataire.addMessagesReçus(this);
         }
      }
   }

}