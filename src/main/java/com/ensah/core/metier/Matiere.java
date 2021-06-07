/***********************************************************************
 * Module:  Matiere.java
 * Author:  Hp
 * Purpose: Defines the Class Matiere
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Matiere {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column
	private int idMatiere;

	@Column
	@NotBlank(message = "This field is required")
	private String nom;
	
	@Column
	@NotBlank(message = "This field is required")
	private String code;
   
   	@ManyToOne
  	@JoinColumn(name= "idModule")
   	public Module module;
   
   
   public Module getModule() {
      return module;
   }
   
   public void setModule(Module newModule) {
      if (this.module == null || !this.module.equals(newModule))
      {
         if (this.module != null)
         {
            Module oldModule = this.module;
            this.module = null;
            oldModule.removeMatieres(this);
         }
         if (newModule != null)
         {
            this.module = newModule;
            this.module.addMatieres(this);
         }
      }
   }
	
	public int getIdMatiere() {
		return idMatiere;
	}
	
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	   
   
}