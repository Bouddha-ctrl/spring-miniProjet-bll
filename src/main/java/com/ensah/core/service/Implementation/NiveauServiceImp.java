package com.ensah.core.service.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ensah.core.dao.INiveauDao;
import com.ensah.core.metier.Filiere;
import com.ensah.core.metier.Niveau;
import com.ensah.core.service.Interface.IFiliereService;
import com.ensah.core.service.Interface.INiveauService;
@Service
@Transactional
public class NiveauServiceImp implements INiveauService {


	@Autowired
	private INiveauDao  dao;
	
	@Autowired
	private IFiliereService Filiere_services;
	
	@Override
	public void add(Niveau N, Filiere F) {
		
		F.addNiveaux(N);

		Filiere_services.update(F);
	}

	@Override
	public void update(Niveau NewNiveau) {
		
		Niveau OldNiveau = GetNiveauById(NewNiveau.getIdNiveau());
		
		OldNiveau.setAlias(NewNiveau.getAlias());
		OldNiveau.setTitre(NewNiveau.getTitre());
		
		dao.save(OldNiveau);
	}

	@Override
	public void delete(Niveau N) {
		dao.delete(N);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Niveau> getAllNiveau() {
		return dao.findAll();
	}

	@Override
	public Niveau GetNiveauById(int id) {
		return dao.findById(id).get();
	}

}
