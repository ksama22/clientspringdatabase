package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controler {
	@Autowired // = new StudentRepository()
	ClientRepository clientRepo;
	
	
	@GetMapping("clients")
	public List<Client> getStudents() {
		List<Client> st1List = clientRepo.findAll();
		return st1List;
		//studentList = GenerateFakeData.generateStudents();
		//return studentList;
	}
	
	
	@GetMapping("clients/{nId}")
	public Client getStudent(@PathVariable int nId) {
		Client st1 = clientRepo.findById(nId).get();
		return st1;
		// studentList = GenerateFakeData.generateStudents();
		// return studentList.get(nId);
	}
}
