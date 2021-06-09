package com.ensah.core.service.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import com.ensah.core.dao.IFiliereDao;
import com.ensah.core.metier.Filiere;
import com.ensah.core.service.Interface.IFiliereService;

@Service
@Transactional
public class FiliereServiceImp implements IFiliereService{

	@Autowired
	private IFiliereDao  dao;
	
	@Override
	public void add(Filiere E) {
			dao.save(E);
	}

	@Override
	public void update(Filiere E) {
		dao.save(E);
	}

	@Override
	public List<Filiere> getAllFiliere() {
		return dao.findAll();
	}

	@Override
	public Filiere GetFiliereById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Filiere e) {
		dao.delete(e);
	}
	
	@Override
	public void deleteById(int id)  {
		dao.deleteById(id);
	}

	
}
