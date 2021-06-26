package com.ensah.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensah.core.metier.Niveau;
import com.ensah.genericDao.GenericDao;

@Repository
public interface INiveauDao extends GenericDao<Niveau,Integer>{

	 List<Niveau> findByAliasContaining(String alias);
	 List<Niveau> findByTitreContaining(String titre);
	  
}
