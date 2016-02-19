package com.banamex.afore.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.banamex.afore.eureka.model.People;
import com.banamex.afore.eureka.service.PeopleService;

@Controller
@RequestMapping("/people")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPeople(@RequestBody People people, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating People " + people.getSoeid());
		System.out.println("Creating People " + people.getNombre());
		System.out.println("Creating People " + people.getApellidoPaterno());
		
		peopleService.addPeople(people);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(people.getSoeid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody People getPeople(@PathVariable String id, ModelMap model) {
		return peopleService.getPeopleById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody People updatePeople(@RequestBody People people, UriComponentsBuilder ucBuilder) {
		return peopleService.updatePeople(people);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<People
	> getAllPeople(ModelMap model) {
		return peopleService.getAllPeople();
	}

}
