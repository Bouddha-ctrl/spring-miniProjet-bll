package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Filiere;
import com.ensah.core.metier.Niveau;


public interface INiveauService {

	public void add(Niveau N, Filiere F);
	
	public void update(Niveau N);
	
	public void delete(Niveau N);
	
	public void deleteById(int id) ;
	
	public List<Niveau> getAllNiveau();
	
	public Niveau GetNiveauById(int id);
	
	public List<Niveau> getSearch(String searchParam);
	
}
