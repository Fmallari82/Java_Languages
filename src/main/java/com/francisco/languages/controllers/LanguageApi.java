package com.francisco.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.languages.models.Language;
import com.francisco.languages.services.LanguageService;

@RestController
@RequestMapping("/api")
public class LanguageApi {

	private final LanguageService languageServ;

	public LanguageApi(LanguageService languageServ) {
		this.languageServ = languageServ;
	}

	// Create
	@PostMapping("/languages")
	public Language createDonation(
			@RequestParam("name") String name, 
			@RequestParam("creator") String creator,
			@RequestParam("version") String version) { 
		Language newLanguage = new Language(
				name, 
				creator, 
				version);
		return languageServ.create(newLanguage);
	}

	// Read All
	@GetMapping("/languages")
	public List<Language> findAllLanguage() {
		return languageServ.getAll();
	}

	// Read one
	@GetMapping("/languages/{id}")
	public Language findOneLanguage(@PathVariable("id") Long id) {
		return languageServ.findOne(id);
	}

	//Update one
	@PutMapping("/languages/{id}")
	public Language findOneAndUpdate(
        @PathVariable("id") Long id, 
        @RequestParam("name") String name,
        @RequestParam("creator") String creator, 
        @RequestParam("version") String version) {
		return languageServ.update(
				id, 
				name, 
				creator, 
				version);
	}

	//Delete 
	@DeleteMapping("/languages/{id}")
	public void destroy(@PathVariable("id") Long id) {
		languageServ.deleteByID(id);
	}
}
