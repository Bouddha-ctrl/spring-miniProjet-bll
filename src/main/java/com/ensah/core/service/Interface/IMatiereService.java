package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Matiere;
import com.ensah.core.metier.Module;


public interface IMatiereService {

	public void add(Matiere Mat, Module Mod);
	
	public void update(Matiere M);
	
	public void delete(Matiere M);
	
	public void deleteById(int id) ;
	
	public List<Matiere> getAllMatiere();
	
	public Matiere GetMatiereById(int id);
	
	public List<Matiere> getSearch(String searchParam);

}
