package com.ensah.core.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ensah.core.dao.INiveauDao;
import com.ensah.core.metier.Filiere;
import com.ensah.core.metier.Niveau;
import com.ensah.core.service.Interface.IFiliereService;
import com.ensah.core.service.Interface.INiveauService;
@Service
@Transactional
public class NiveauServiceImp implements INiveauService {


	@Autowired
	private INiveauDao  dao;
	
	
	@Override
	public void add(Niveau N, Filiere F) {
		
		N.setFiliere(F);
		dao.save(N);
		
		//or
		//F.addNiveaux(N);
		//Filiere_services.update(F);
		
	}

	@Override
	public void update(Niveau NewNiveau) {
		
		Niveau OldNiveau = GetNiveauById(NewNiveau.getIdNiveau());
		
		//Working
		  OldNiveau.setAlias(NewNiveau.getAlias());
		  OldNiveau.setTitre(NewNiveau.getTitre());
		  dao.save(OldNiveau);
		
		
		//PersistentObjectException
		/*NewNiveau.setFiliere(OldNiveau.getFiliere());
		NewNiveau.setModules(OldNiveau.getModules());*/
		//dao.save(NewNiveau);
		
	}

	@Override
	public void delete(Niveau N) {
		dao.delete(N);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Niveau> getAllNiveau() {
		return dao.findAll();
	}

	@Override
	public Niveau GetNiveauById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Niveau> getSearch(String searchParam) {
		List<Niveau> list = new ArrayList<Niveau>();
		String[] attribute = searchParam.split(":", 2); //the pattern will be applied at most limit-1 times, the first :
		String searchBy = attribute[0];   
		String searchValue = attribute[1];

		switch(searchBy)
		{
			case "idNiveau":
				try {
				list.add(GetNiveauById(Integer.parseInt(searchValue)));
				}catch(Exception ex){}finally{};
				break;
			case "alias":
				list = dao.findByAliasContaining(searchValue);
				break;
			case "titre":
				list = dao.findByTitreContaining(searchValue);
				break;

			default:
				System.out.println("Error switch NiveauServiceImp.getSearch");
		}
		
			return list;
	}

}
