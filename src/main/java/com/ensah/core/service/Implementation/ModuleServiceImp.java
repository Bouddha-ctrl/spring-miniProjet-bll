package com.ensah.core.service.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ensah.core.dao.IModuleDao;
import com.ensah.core.metier.Module;
import com.ensah.core.metier.Niveau;
import com.ensah.core.service.Interface.IModuleService;
import com.ensah.core.service.Interface.INiveauService;

@Service
@Transactional
public class ModuleServiceImp implements IModuleService{

	
	@Autowired
	private IModuleDao  dao;
	
	@Autowired
	private INiveauService Niveau_services;
	
	@Override
	public void add(Module M, Niveau N) {
		N.addModules(M);
		
		Niveau_services.update(N);
	}

	@Override
	public void update(Module NewModule) {
		
		Module OldModule = GetModuleById(NewModule.getIdModule());
		OldModule.setCode(NewModule.getCode());
		OldModule.setTitre(NewModule.getTitre());
		
		dao.save(OldModule);
	}

	@Override
	public void delete(Module M) {
		dao.delete(M);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);

	}

	@Override
	public List<Module> getAllModule() {
		return dao.findAll();
	}

	@Override
	public Module GetModuleById(int id) {
		return dao.findById(id).get();
	}

}
