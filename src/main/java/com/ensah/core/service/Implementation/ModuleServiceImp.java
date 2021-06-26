package com.ensah.core.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ensah.core.dao.IModuleDao;
import com.ensah.core.metier.Module;
import com.ensah.core.metier.Niveau;
import com.ensah.core.service.Interface.IModuleService;
import com.ensah.core.service.Interface.INiveauService;

@Service
@Transactional
public class ModuleServiceImp implements IModuleService{

	
	@Autowired
	private IModuleDao  dao;
	

	@Override
	public void add(Module M, Niveau N) {
		M.setNiveau(N);
		dao.save(M);
	}

	@Override
	public void update(Module NewModule) {
		
		Module OldModule = GetModuleById(NewModule.getIdModule());
		OldModule.setCode(NewModule.getCode());
		OldModule.setTitre(NewModule.getTitre());
		
		dao.save(OldModule);
	}

	@Override
	public void delete(Module M) {
		dao.delete(M);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);

	}

	@Override
	public List<Module> getAllModule() {
		return dao.findAll();
	}

	@Override
	public Module GetModuleById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Module> getSearch(String searchParam) {
		List<Module> list = new ArrayList<Module>();
		String[] attribute = searchParam.split(":", 2); //the pattern will be applied at most limit-1 times, the first :
		String searchBy = attribute[0];   
		String searchValue = attribute[1];
		
		switch(searchBy)
		{
			case "idModule":
				try {
				list.add(GetModuleById(Integer.parseInt(searchValue)));
				}catch(Exception ex){}finally{};
				break;
			case "code":
				list = dao.findByCodeContaining(searchValue);
				break;
			case "titre":
				list = dao.findByTitreContaining(searchValue);
				break;

			default:
				System.out.println("Error switch ModuleServiceImp.getSearch");
		}
		
			return list;
	}

}
