package com.ensah.core.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class CoordinationModel {

	private int idCoordination;
	
	@NotBlank(message="This field is required")
	@Pattern(regexp="((0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-[12]\\d{3})",
			 message="Wrong date format")
	private String dateDebut;
   
	@NotBlank(message="This field is required")
	@Pattern(regexp="((0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-[12]\\d{3})",
			 message="Wrong date format")
	private String dateFin;
   

	public int idenseignant;


    public int idfiliere;


	public int getIdCoordination() {
		return idCoordination;
	}


	public void setIdCoordination(int idCoordination) {
		this.idCoordination = idCoordination;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public int getIdenseignant() {
		return idenseignant;
	}


	public void setIdenseignant(int idenseignant) {
		this.idenseignant = idenseignant;
	}


	public int getIdfiliere() {
		return idfiliere;
	}


	public void setIdfiliere(int idfiliere) {
		this.idfiliere = idfiliere;
	}
    
    
}
