package com.ensah.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ensah.core.dao.IFiliereDao;
import com.ensah.core.metier.Filiere;
import com.ensah.core.service.Interface.IImportDataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ImportData implements IImportDataService{
	@Autowired
	private IFiliereDao  dao;
	
	public String importData(String rawJson) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<Filiere> listFiliere = objectMapper.readValue(rawJson, new TypeReference<List<Filiere>>(){});

			for(int i = 0;i<listFiliere.size();i++) {

				dao.save(listFiliere.get(i));

			}
		}catch(ConstraintViolationException CVE) {
			return "ConstraintViolationException";
		}catch (Exception e) {
			return "Wrong json format or Strange  attributs";
		}
		return "Les elements sont bien ajoutées !";
	}
	

}
