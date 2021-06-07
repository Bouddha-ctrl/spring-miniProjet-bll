package com.ensah.core.service.Interface;

import java.util.List;

import com.ensah.core.metier.Module;

public interface IModuleService {
	
	public void add(Module M);
	
	public void update(Module M);
	
	public void delete(Module M);
	
	public void deleteById(int id) ;
	
	public List<Module> getAllModule();
	
	public Module GetModuleById(int id);
}
