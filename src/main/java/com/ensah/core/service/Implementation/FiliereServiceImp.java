package com.ensah.core.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import com.ensah.core.dao.IFiliereDao;
import com.ensah.core.metier.Filiere;
import com.ensah.core.metier.Module;
import com.ensah.core.service.Interface.IFiliereService;

@Service
@Transactional
public class FiliereServiceImp implements IFiliereService{

	@Autowired
	private IFiliereDao  dao;
	
	@Override
	public void add(Filiere E) {
		dao.save(E);
	}

	@Override
	public void update(Filiere E) {
		dao.save(E);
	}

	@Override
	public List<Filiere> getAllFiliere() {
		return dao.findAll();
	}

	@Override
	public Filiere GetFiliereById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Filiere e) {
		dao.delete(e);
	}
	
	@Override
	public void deleteById(int id)  {
		dao.deleteById(id);
	}

	@Override
	public List<Filiere> getSearch(String searchParam) {
		List<Filiere> list = new ArrayList<Filiere>();
		String[] attribute = searchParam.split(":", 2); //the pattern will be applied at most limit-1 times, the first :
		String searchBy = attribute[0];   
		String searchValue = attribute[1];
		
		switch(searchBy)
		{
			case "idFiliere":
				try {
				list.add(GetFiliereById(Integer.parseInt(searchValue)));
				}catch(Exception ex){}finally{};
				break;
			case "titreFiliere":
				list = dao.findByTitreFiliereContaining(searchValue);
				break;
			case "codeFiliere":
				list = dao.findByCodeFiliereContaining(searchValue);
				break;
			case "anneeaccreditation":
				try {
					list = dao.findByAnneeaccreditation(Integer.parseInt(searchValue));
				}catch(Exception ex){}finally{};
				break;
			case "anneeFinaccreditation":
				try {
					list = dao.findByAnneeFinaccreditation(Integer.parseInt(searchValue));
				}catch(Exception ex){}finally{};
				break;

			default:
				System.out.println("Error switch FiliereServiceImp.getSearch");
		}
		
			return list;
	}

	
}
