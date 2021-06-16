package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Enseignant;

public interface IEnseignantService {

	public void add(Enseignant E);
	
	public void update(Enseignant e);
	
	public void delete(Enseignant e);
	
	public void deleteById(int id) ;
	
	public List<Enseignant> getAllEnseignant();
	
	public Enseignant GetEnseignantById(int id);	
}
