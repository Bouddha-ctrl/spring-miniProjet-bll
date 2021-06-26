package com.ensah.core.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ensah.core.dao.IMatiereDao;
import com.ensah.core.metier.Filiere;
import com.ensah.core.metier.Matiere;
import com.ensah.core.metier.Module;

import com.ensah.core.service.Interface.IMatiereService;
import com.ensah.core.service.Interface.IModuleService;

@Service
@Transactional
public class MatiereServiceImp implements IMatiereService{

	@Autowired
	private IMatiereDao  dao;
	
	
	@Override
	public void add(Matiere Mat ,Module Mod) {
		
		Mat.setModule(Mod);
		dao.save(Mat);
	}

	@Override
	public void update(Matiere NewModule) {
		
		Matiere DetachedMatiere = GetMatiereById(NewModule.getIdMatiere());
		DetachedMatiere.setCode(NewModule.getCode());
		DetachedMatiere.setNom(NewModule.getNom());
		dao.save(DetachedMatiere);
	}

	@Override
	public void delete(Matiere M) {
		dao.delete(M);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Matiere> getAllMatiere() {
		return dao.findAll();
	}

	@Override
	public Matiere GetMatiereById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Matiere> getSearch(String searchParam) {
		List<Matiere> list = new ArrayList<Matiere>();
		String[] attribute = searchParam.split(":", 2); //the pattern will be applied at most limit-1 times, the first :
		String searchBy = attribute[0];   
		String searchValue = attribute[1];
		
		switch(searchBy)
		{
			case "idMatiere":
				try {
				list.add(GetMatiereById(Integer.parseInt(searchValue)));
				}catch(Exception ex){}finally{};
				break;
			case "code":
				list = dao.findByCodeContaining(searchValue);
				break;
			case "nom":
				list = dao.findByNomContaining(searchValue);
				break;

			default:
				System.out.println("Error switch MatiereServiceImp.getSearch");
		}
		
			return list;
	}
}
