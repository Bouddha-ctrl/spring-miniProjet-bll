package com.ensah.core.service.Implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.dao.ICoordinationDao;
import com.ensah.core.dao.IEnseignantDao;
import com.ensah.core.dao.IFiliereDao;
import com.ensah.core.metier.Coordination;
import com.ensah.core.metier.Enseignant;
import com.ensah.core.metier.Filiere;
import com.ensah.core.model.CoordinationModel;
import com.ensah.core.service.Interface.ICoordinationService;
import com.ensah.core.service.Interface.IEnseignantService;
import com.ensah.core.service.Interface.IFiliereService;

@Service
@Transactional
public class CoordinationServiceImp implements ICoordinationService{
	
	@Autowired
	private ICoordinationDao dao;
	
	@Autowired
	private IFiliereDao Filiere_dao;
	
	@Autowired
	private IEnseignantDao Enseigant_dao;
	
	@Override
	public void add(CoordinationModel CM) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Filiere f = Filiere_dao.getById(CM.getIdfiliere());
		Enseignant e = Enseigant_dao.getById(CM.getIdenseignant());
		Coordination C = new Coordination();
		
		try {
			C.setDateDebut(sdf.parse(CM.getDateDebut()));
			C.setDateFin(sdf.parse(CM.getDateFin()));
		} catch (ParseException e1) {
			System.out.println("error parsing string to date CoordinationServiceIml.add");
			e1.printStackTrace();
		}
		
		C.setFiliere(f);
		C.setCoordonateur(e);
		
		dao.save(C);
	}

	@Override
	public void update(Coordination e) {
	}

	@Override
	public void delete(Coordination e) {
		dao.delete(e);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Coordination> getAllCoordination() {
		return dao.findAll();
	}

	@Override
	public Coordination GetCoordinationById(int id) {
		return dao.findById(id).get();
	}
	
}
