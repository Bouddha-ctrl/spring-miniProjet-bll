package com.ensah.core.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.metier.Filiere;
import com.ensah.core.metier.Module;
import com.ensah.genericDao.GenericDao;

@Repository
public interface IFiliereDao extends GenericDao<Filiere,Integer>{

	 List<Filiere> findByTitreFiliereContaining(String titreFiliere);
	 List<Filiere> findByCodeFiliereContaining(String codeFiliere);
	 List<Filiere> findByAnneeaccreditation(int anneeaccreditation);
	 List<Filiere> findByAnneeFinaccreditation(int anneeFinaccreditation);

}
