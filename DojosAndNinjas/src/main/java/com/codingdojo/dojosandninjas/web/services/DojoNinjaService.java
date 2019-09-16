package com.codingdojo.dojosandninjas.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.web.models.Dojo;
import com.codingdojo.dojosandninjas.web.models.Ninja;
import com.codingdojo.dojosandninjas.web.repositories.DojoRepo;
import com.codingdojo.dojosandninjas.web.repositories.NinjaRepo;

@Service
public class DojoNinjaService {
	private static DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	
	public DojoNinjaService(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		DojoNinjaService.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}

	public void addDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	
	public List<Dojo> getAllDojos() {
		return dojoRepo.findAll();
	}
	
	public static Dojo singleDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		else {
			return null;
		}
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
}