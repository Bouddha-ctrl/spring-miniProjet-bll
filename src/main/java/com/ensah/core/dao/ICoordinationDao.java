package com.ensah.core.dao;

import org.springframework.stereotype.Repository;

import com.ensah.core.metier.Coordination;
import com.ensah.core.metier.Enseignant;
import com.ensah.genericDao.GenericDao;

@Repository
public interface ICoordinationDao extends GenericDao<Coordination,Integer>{

}
