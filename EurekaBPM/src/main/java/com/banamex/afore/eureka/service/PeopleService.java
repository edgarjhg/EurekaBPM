package com.banamex.afore.eureka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banamex.afore.eureka.model.People;

@Service("peopleService")
public class PeopleService {
	
	List<People> list = new ArrayList<People>();
	
	public PeopleService(){
		People people = new People();
		people.setNombre("12");
		people.setSoeid("eh64914");
		people.setApellidoPaterno("Hinojosa");
		list.add(people);
	}
	
	public void addPeople(People people){
		list.add(people);
	}
	
	public People getPeopleById(String id){		
		People people = new People();
		people.setNombre(id);
		people.setSoeid("eh64914");
		people.setApellidoPaterno("Hinojosa");
		return people;
	}
	
	public People updatePeople(People people){		
		System.out.println("Se actualiza: "+people.getSoeid());
		return people;
	}
	
	public List<People> getAllPeople(){		
		return list;
	}

}
