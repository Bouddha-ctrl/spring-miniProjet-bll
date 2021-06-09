/***********************************************************************
 * Module:  Utilisateur.java
 * Author:  Hp
 * Purpose: Defines the Class Utilisateur
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class Utilisateur {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column
	private int idUtilisateur;

	private String nom;

	private String prenom;

	private String cin;

	private String email;

	private String telephone;

	private String nomArabe;

	private String prenomArabe;

	private String photo;
   
	@Transient
   public java.util.Set<Compte> comptes;
   
   
   /** @pdGenerated default getter */
   public java.util.Set<Compte> getComptes() {
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
   public void setComptes(java.util.Set<Compte> newComptes) {
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

	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getCin() {
		return cin;
	}
	
	public void setCin(String cin) {
		this.cin = cin;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getNomArabe() {
		return nomArabe;
	}
	
	public void setNomArabe(String nomArabe) {
		this.nomArabe = nomArabe;
	}
	
	public String getPrenomArabe() {
		return prenomArabe;
	}
	
	public void setPrenomArabe(String prenomArabe) {
		this.prenomArabe = prenomArabe;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	   
	   
   

}