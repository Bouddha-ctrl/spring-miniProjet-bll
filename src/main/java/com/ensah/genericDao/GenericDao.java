package com.ensah.genericDao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericDao<T, ID extends Serializable> extends JpaRepository<T, ID>{

}
