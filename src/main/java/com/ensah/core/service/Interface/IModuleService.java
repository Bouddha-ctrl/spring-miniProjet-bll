package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Module;
import com.ensah.core.metier.Niveau;

public interface IModuleService {
	
	public void add(Module M, Niveau N);
	
	public void update(Module M);
	
	public void delete(Module M);
	
	public void deleteById(int id) ;
	
	public List<Module> getAllModule();
	
	public Module GetModuleById(int id);
	
	public List<Module> getSearch(String searchParam);

}
