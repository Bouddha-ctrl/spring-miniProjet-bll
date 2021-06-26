package com.ensah.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.metier.Module;
import com.ensah.core.metier.Niveau;
import com.ensah.genericDao.GenericDao;

@Repository
public interface IModuleDao extends GenericDao<Module,Integer>{

	 List<Module> findByTitreContaining(String titre);
	 List<Module> findByCodeContaining(String code);

}
