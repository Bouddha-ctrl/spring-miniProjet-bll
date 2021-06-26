/***********************************************************************
 * Module:  Module.java
 * Author:  Hp
 * Purpose: Defines the Class Module
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Module {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column
	private int idModule;

	@Column
	@NotBlank(message = "This field is required")
	private String titre;
	
	@Column
	@NotBlank(message = "This field is required")
	private String code;
   
	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
	public java.util.Set<Matiere> matieres;

	@ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name= "idNiveau")
	public Niveau niveau;
   
   
   public java.util.Set<Matiere> getMatieres() {
      if (matieres == null)
         matieres = new java.util.HashSet<Matiere>();
      return matieres;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMatieres() {
      if (matieres == null)
         matieres = new java.util.HashSet<Matiere>();
      return matieres.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMatieres */
   public void setMatieres(java.util.Set<Matiere> newMatieres) {
      removeAllMatieres();
      for (java.util.Iterator iter = newMatieres.iterator(); iter.hasNext();)
         addMatieres((Matiere)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMatiere */
   public void addMatieres(Matiere newMatiere) {
      if (newMatiere == null)
         return;
      if (this.matieres == null)
         this.matieres = new java.util.HashSet<Matiere>();
      if (!this.matieres.contains(newMatiere))
      {
         this.matieres.add(newMatiere);
         newMatiere.setModule(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldMatiere */
   public void removeMatieres(Matiere oldMatiere) {
      if (oldMatiere == null)
         return;
      if (this.matieres != null)
         if (this.matieres.contains(oldMatiere))
         {
            this.matieres.remove(oldMatiere);
            oldMatiere.setModule((Module)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMatieres() {
      if (matieres != null)
      {
         Matiere oldMatiere;
         for (java.util.Iterator iter = getIteratorMatieres(); iter.hasNext();)
         {
            oldMatiere = (Matiere)iter.next();
            iter.remove();
            oldMatiere.setModule((Module)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Niveau getNiveau() {
      return niveau;
   }
   
   /** @pdGenerated default parent setter
     * @param newNiveau */
   public void setNiveau(Niveau newNiveau) {
      if (this.niveau == null || !this.niveau.equals(newNiveau))
      {
         if (this.niveau != null)
         {
            Niveau oldNiveau = this.niveau;
            this.niveau = null;
            oldNiveau.removeModules(this);
         }
         if (newNiveau != null)
         {
            this.niveau = newNiveau;
            this.niveau.addModules(this);
         }
      }
   }
	
	public int getIdModule() {
		return idModule;
	}
	
	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

   
   
}