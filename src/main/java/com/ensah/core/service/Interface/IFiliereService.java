package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Filiere;

public interface IFiliereService {
	
	public void add(Filiere E);
	
	public void update(Filiere e);
	
	public void delete(Filiere e);
	
	public void deleteById(int id) ;
	
	public List<Filiere> getAllFiliere();
	
	public Filiere GetFiliereById(int id);
	
}
