package com.ensah.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.metier.Matiere;
import com.ensah.core.metier.Module;
import com.ensah.genericDao.GenericDao;

@Repository
public interface IMatiereDao  extends GenericDao<Matiere,Integer>{

	 List<Matiere> findByNomContaining(String nom);
	 List<Matiere> findByCodeContaining(String code);

}
