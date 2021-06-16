package com.ensah.core.service.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.dao.ICoordinationDao;
import com.ensah.core.metier.Coordination;
import com.ensah.core.metier.Enseignant;
import com.ensah.core.metier.Filiere;
import com.ensah.core.service.Interface.ICoordinationService;
import com.ensah.core.service.Interface.IEnseignantService;
import com.ensah.core.service.Interface.IFiliereService;

@Service
@Transactional
public class CoordinationServiceImp implements ICoordinationService{
	
	@Autowired
	private ICoordinationDao dao;
	
	@Autowired
	private IFiliereService Filiere_services;
	
	@Autowired
	private IEnseignantService Enseigant_services;
	
	@Override
	public void add(Coordination D,int idFiliere, int idEnseignant) {
		
		Filiere f = Filiere_services.GetFiliereById(idFiliere);
		Enseignant e = Enseigant_services.GetEnseignantById(idEnseignant);
		
		D.setFiliere(f);
		D.setCoordonateur(e);
		
		dao.save(D);
	}

	@Override
	public void update(Coordination e) {
	}

	@Override
	public void delete(Coordination e) {
		
	}

	@Override
	public void deleteById(int id) {
		
	}

	@Override
	public List<Coordination> getAllCoordination() {
		return dao.findAll();
	}

	@Override
	public Coordination GetCoordinationById(int id) {
		return dao.findById(id).get();
	}
	
}
