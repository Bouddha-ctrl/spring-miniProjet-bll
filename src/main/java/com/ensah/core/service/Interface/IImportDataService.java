package com.ensah.core.service.Interface;

import java.io.File;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

public interface IImportDataService {

	public String importData(String rawJson);
}
