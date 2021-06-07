/***********************************************************************
 * Module:  Conversation.java
 * Author:  Hp
 * Purpose: Defines the Class Conversation
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid 32bfa944-9ff6-4406-a85d-8111716cdf7c */
public class Conversation {
   /** @pdOid cb67a4a7-947a-4db3-8f14-e8052142b54a */
   private int idConversation;
   /** @pdOid a6e6649b-10e6-4cc2-9741-a06f2d788505 */
   private String type;
   /** @pdOid 21fe610a-1a49-4457-b2a0-ab2ab76d4b27 */
   private String titre;
   /** @pdOid 83da1a45-5854-4be0-abc4-a0121d403f00 */
   private int etat;
   
   /** @pdRoleInfo migr=no name=Compte assc=Compte_Conversation coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Compte> participant;
   /** @pdRoleInfo migr=no name=Message assc=Association_14 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Message> messages;
   /** @pdRoleInfo migr=no name=Compte assc=Association_15 coll=java.util.Collection impl=java.util.HashSet mult=1..1 side=A */
   public Compte createurConversation;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Compte> getParticipant() {
      if (participant == null)
         participant = new java.util.HashSet<Compte>();
      return participant;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorParticipant() {
      if (participant == null)
         participant = new java.util.HashSet<Compte>();
      return participant.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newParticipant */
   public void setParticipant(java.util.Collection<Compte> newParticipant) {
      removeAllParticipant();
      for (java.util.Iterator iter = newParticipant.iterator(); iter.hasNext();)
         addParticipant((Compte)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCompte */
   public void addParticipant(Compte newCompte) {
      if (newCompte == null)
         return;
      if (this.participant == null)
         this.participant = new java.util.HashSet<Compte>();
      if (!this.participant.contains(newCompte))
      {
         this.participant.add(newCompte);
         newCompte.addConversationReçues(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldCompte */
   public void removeParticipant(Compte oldCompte) {
      if (oldCompte == null)
         return;
      if (this.participant != null)
         if (this.participant.contains(oldCompte))
         {
            this.participant.remove(oldCompte);
            oldCompte.removeConversationReçues(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllParticipant() {
      if (participant != null)
      {
         Compte oldCompte;
         for (java.util.Iterator iter = getIteratorParticipant(); iter.hasNext();)
         {
            oldCompte = (Compte)iter.next();
            iter.remove();
            oldCompte.removeConversationReçues(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Message> getMessages() {
      if (messages == null)
         messages = new java.util.HashSet<Message>();
      return messages;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMessages() {
      if (messages == null)
         messages = new java.util.HashSet<Message>();
      return messages.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMessages */
   public void setMessages(java.util.Collection<Message> newMessages) {
      removeAllMessages();
      for (java.util.Iterator iter = newMessages.iterator(); iter.hasNext();)
         addMessages((Message)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMessage */
   public void addMessages(Message newMessage) {
      if (newMessage == null)
         return;
      if (this.messages == null)
         this.messages = new java.util.HashSet<Message>();
      if (!this.messages.contains(newMessage))
      {
         this.messages.add(newMessage);
         newMessage.setConversation(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldMessage */
   public void removeMessages(Message oldMessage) {
      if (oldMessage == null)
         return;
      if (this.messages != null)
         if (this.messages.contains(oldMessage))
         {
            this.messages.remove(oldMessage);
            oldMessage.setConversation((Conversation)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMessages() {
      if (messages != null)
      {
         Message oldMessage;
         for (java.util.Iterator iter = getIteratorMessages(); iter.hasNext();)
         {
            oldMessage = (Message)iter.next();
            iter.remove();
            oldMessage.setConversation((Conversation)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Compte getCreateurConversation() {
      return createurConversation;
   }
   
   /** @pdGenerated default parent setter
     * @param newCompte */
   public void setCreateurConversation(Compte newCompte) {
      if (this.createurConversation == null || !this.createurConversation.equals(newCompte))
      {
         if (this.createurConversation != null)
         {
            Compte oldCompte = this.createurConversation;
            this.createurConversation = null;
            oldCompte.removeConversationsCrees(this);
         }
         if (newCompte != null)
         {
            this.createurConversation = newCompte;
            this.createurConversation.addConversationsCrees(this);
         }
      }
   }

}