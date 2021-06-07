package com.ensah.core.dao;

import org.springframework.stereotype.Repository;

import com.ensah.core.metier.Matiere;
import com.ensah.genericDao.GenericDao;

@Repository
public interface IMatiereDao  extends GenericDao<Matiere,Integer>{

}
