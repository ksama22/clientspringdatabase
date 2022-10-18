package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controler {
	@Autowired // = new StudentRepository()
	ClientRepository clientRepo;
	
	
	@GetMapping("/")
	public String getHome() {
		return "<!DOCTYPE html><html lang=\"en\"><head><title>Document</title></head><body><ul><li><a href='/h2-console'>Database</a></li><li><a href='/clients'>Clients</a></li><li><a href='/clients/1'>Clients/id</a></li></ul></body></html>";
	}
	
	@GetMapping("clients")
	public Iterable <Client> getStudents() {
		List<Client> st1List = clientRepo.findAll();
		return st1List;
		//studentList = GenerateFakeData.generateStudents();
		//return studentList;
	}
	
	
	@GetMapping("clients/{nId}")
	public Optional<Client> getStudent(@PathVariable int nId) {
		Client st1 = clientRepo.findById(nId).get();
	    Optional<Client> opt = Optional.ofNullable(st1);
		return opt;
		// studentList = GenerateFakeData.generateStudents();
		// return studentList.get(nId);
	}
	
	
	@PostMapping(value= "clients/modify")
	public Client altaClient(@RequestBody Client client) {
		//Save modifica no inserta nuevos
		clientRepo.save(client);
		return client;
		
	}
	/*
	//No me va con @PutMapping
	@GetMapping("clients/add")
	public Client modificaClient(@RequestBody Client client) {
		//Save modifica no inserta nuevos
		clientRepo.save(client);
		//Postman {"id":5,"nom":"Raquel","surname":"Pulido"}
		return client;
		
	}*/
	
	@GetMapping("clients/delete/{nId}")
	public String deleteClient(@PathVariable int nId) {
		Client st1 = clientRepo.findById(nId).get();
		clientRepo.deleteById(nId);
		String htmlHardcode ="<br><a href='/'>Retorna<a/>"; 
		return "Deleted "+st1.toString()+htmlHardcode;
		
	}
}
