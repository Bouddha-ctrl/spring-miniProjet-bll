package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Coordination;

public interface ICoordinationService {

	public void add(Coordination E,int idFiliere, int idEnseignant);
	
	public void update(Coordination e);
	
	public void delete(Coordination e);
	
	public void deleteById(int id) ;
	
	public List<Coordination> getAllCoordination();
	
	public Coordination GetCoordinationById(int id);
	
}
