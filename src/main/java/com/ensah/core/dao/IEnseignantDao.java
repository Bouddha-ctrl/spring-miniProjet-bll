package com.ensah.core.dao;

import org.springframework.stereotype.Repository;

import com.ensah.core.metier.Enseignant;
import com.ensah.genericDao.GenericDao;

@Repository

public interface IEnseignantDao extends GenericDao<Enseignant,Integer>{

}
