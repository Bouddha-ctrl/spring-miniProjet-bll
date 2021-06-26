package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Coordination;
import com.ensah.core.model.CoordinationModel;

public interface ICoordinationService {

	public void add(CoordinationModel C);
	
	public void update(Coordination e);
	
	public void delete(Coordination e);
	
	public void deleteById(int id) ;
	
	public List<Coordination> getAllCoordination();
	
	public Coordination GetCoordinationById(int id);
	
}
