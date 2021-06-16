package com.ensah.core.service.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.dao.IEnseignantDao;
import com.ensah.core.metier.Enseignant;
import com.ensah.core.service.Interface.IEnseignantService;

@Service
@Transactional
public class EnseignantServiceImp implements IEnseignantService {

	@Autowired
	private IEnseignantDao dao;
	
	@Override
	public void add(Enseignant E) {
		
	}

	@Override
	public void update(Enseignant e) {
		
	}

	@Override
	public void delete(Enseignant e) {
		
	}

	@Override
	public void deleteById(int id) {

	}

	@Override
	public List<Enseignant> getAllEnseignant() {
		return dao.findAll();
	}

	@Override
	public Enseignant GetEnseignantById(int id) {
		return dao.findById(id).get();
	}

}
