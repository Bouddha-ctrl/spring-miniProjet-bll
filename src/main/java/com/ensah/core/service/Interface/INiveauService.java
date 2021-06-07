package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Niveau;


public interface INiveauService {

public void add(Niveau N);
	
	public void update(Niveau N);
	
	public void delete(Niveau N);
	
	public void deleteById(int id) ;
	
	public List<Niveau> getAllNiveau();
	
	public Niveau GetNiveauById(int id);
	
}
