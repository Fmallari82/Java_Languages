package com.francisco.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.francisco.languages.models.Language;
import com.francisco.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	// adding the language repository as a dependency
	private final LanguageRepository languageRepo;

	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}

	// returns all the Languages
	public List<Language> getAll() {
		return languageRepo.findAll();
	}

	// creates a language
	public Language create(Language language) {
		return languageRepo.save(language);
	}

	// retrieves a language
	public Language findOne(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	public Language update(
			Long id, 
			String name, 
			String creator,  
			String version) {
		Language languageToBeUpdated = new Language(
				id, 
				name, 
				creator,  
				version);
		return languageRepo.save(languageToBeUpdated);
	}
	public Language update(Language language) {
		return languageRepo.save(language);
	}
	
	public String deleteByID(Long id) {
		languageRepo.deleteById(id);
		return "you deleted the record with the id of: " + id;
	}
//----------------For Lookify assignment----------------------
	public Object searchLanguage(String search) {
		return languageRepo.findByNameContaining(search);
}
}

