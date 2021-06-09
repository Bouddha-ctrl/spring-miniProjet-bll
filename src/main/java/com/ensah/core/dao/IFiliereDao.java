package com.ensah.core.dao;


import org.springframework.stereotype.Repository;
import com.ensah.core.metier.Filiere;
import com.ensah.genericDao.GenericDao;

@Repository
public interface IFiliereDao extends GenericDao<Filiere,Integer> {

}
