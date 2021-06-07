package com.ensah.core.service.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ensah.core.dao.IMatiereDao;
import com.ensah.core.metier.Matiere;
import com.ensah.core.service.Interface.IMatiereService;

@Service
@Transactional
public class MatiereServiceImp implements IMatiereService{

	@Autowired
	private IMatiereDao  dao;
	
	@Override
	public void add(Matiere M) {
		dao.save(M);
	}

	@Override
	public void update(Matiere M) {
		dao.save(M);
	}

	@Override
	public void delete(Matiere M) {
		dao.delete(M);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Matiere> getAllMatiere() {
		return dao.findAll();
	}

	@Override
	public Matiere GetMatiereById(int id) {
		return dao.findById(id).get();
	}
}
