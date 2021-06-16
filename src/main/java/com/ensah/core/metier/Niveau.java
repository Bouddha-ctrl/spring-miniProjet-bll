/***********************************************************************
 * Module:  Niveau.java
 * Author:  Hp
 * Purpose: Defines the Class Niveau
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Niveau {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column
	private int idNiveau;

	@Column
	@NotBlank(message = "This field is required")
	private String alias;

	@Column
	@NotBlank(message = "This field is required")
	private String titre;
	
	@OneToMany(mappedBy = "niveau", cascade = CascadeType.ALL)
	public java.util.Set<Module> modules;
	
	@Transient
	public java.util.Set<Inscription> niveau;

   	@ManyToOne
   	@JoinColumn(name= "idFiliere")
   	public Filiere filiere;
   
   
   	public java.util.Set<Module> getModules() {
   		if (modules == null)
   			modules = new java.util.HashSet<Module>();
   		return modules;
   	}
   
   	public java.util.Iterator getIteratorModules() {
   		if (modules == null)
   			modules = new java.util.HashSet<Module>();
   		return modules.iterator();
   	}
   
   public void setModules(java.util.Set<Module> newModules) {
      removeAllModules();
      for (java.util.Iterator iter = newModules.iterator(); iter.hasNext();)
         addModules((Module)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newModule */
   public void addModules(Module newModule) {
      if (newModule == null)
         return;
      if (this.modules == null)
         this.modules = new java.util.HashSet<Module>();
      if (!this.modules.contains(newModule))
      {
         this.modules.add(newModule);
         newModule.setNiveau(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldModule */
   public void removeModules(Module oldModule) {
      if (oldModule == null)
         return;
      if (this.modules != null)
         if (this.modules.contains(oldModule))
         {
            this.modules.remove(oldModule);
            oldModule.setNiveau((Niveau)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllModules() {
      if (modules != null)
      {
         Module oldModule;
         for (java.util.Iterator iter = getIteratorModules(); iter.hasNext();)
         {
            oldModule = (Module)iter.next();
            iter.remove();
            oldModule.setNiveau((Niveau)null);
         }
      }
      else 
      {
    	 modules = this.modules = new java.util.HashSet<Module>();
      }
   }
   /** @pdGenerated default getter */
   public java.util.Set<Inscription> getNiveau() {
      if (niveau == null)
         niveau = new java.util.HashSet<Inscription>();
      return niveau;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNiveau() {
      if (niveau == null)
         niveau = new java.util.HashSet<Inscription>();
      return niveau.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNiveau */
   public void setNiveau(java.util.Set<Inscription> newNiveau) {
      removeAllNiveau();
      for (java.util.Iterator iter = newNiveau.iterator(); iter.hasNext();)
         addNiveau((Inscription)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newInscription */
   public void addNiveau(Inscription newInscription) {
      if (newInscription == null)
         return;
      if (this.niveau == null)
         this.niveau = new java.util.HashSet<Inscription>();
      if (!this.niveau.contains(newInscription))
      {
         this.niveau.add(newInscription);
         newInscription.setInscriptions(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldInscription */
   public void removeNiveau(Inscription oldInscription) {
      if (oldInscription == null)
         return;
      if (this.niveau != null)
         if (this.niveau.contains(oldInscription))
         {
            this.niveau.remove(oldInscription);
            oldInscription.setInscriptions((Niveau)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNiveau() {
      if (niveau != null)
      {
         Inscription oldInscription;
         for (java.util.Iterator iter = getIteratorNiveau(); iter.hasNext();)
         {
            oldInscription = (Inscription)iter.next();
            iter.remove();
            oldInscription.setInscriptions((Niveau)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Filiere getFiliere() {
      return filiere;
   }
   
   /** @pdGenerated default parent setter
     * @param newFiliere */
   public void setFiliere(Filiere newFiliere) {
      if (this.filiere == null || !this.filiere.equals(newFiliere))
      {
         if (this.filiere != null)
         {
            Filiere oldFiliere = this.filiere;
            this.filiere = null;
            oldFiliere.removeNiveaux(this);
         }
         if (newFiliere != null)
         {
            this.filiere = newFiliere;
            this.filiere.addNiveaux(this);
         }
      }
   }
	
	public int getIdNiveau() {
		return idNiveau;
	}
	
	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Niveau [idNiveau=" + idNiveau + ", alias=" + alias + ", titre=" + titre + ", modules=" + modules
				+ ", niveau=" + niveau + ", filiere= override tostring to see filieres ]";
	}

   
   
}