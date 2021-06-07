package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Matiere;

public interface IMatiereService {

	public void add(Matiere M);
	
	public void update(Matiere M);
	
	public void delete(Matiere M);
	
	public void deleteById(int id) ;
	
	public List<Matiere> getAllMatiere();
	
	public Matiere GetMatiereById(int id);
}
