package com.example.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //taula db
public class Client {
	  @Id //clau taula de la db
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String surname;
	public Client() {
		super();
		this.id = 0;
		this.nom = "";
		this.surname = "";
	}
	
	public Client(int id, String nom, String surname) {
		super();
		this.id = id;
		this.nom = nom;
		this.surname = surname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", surname=" + surname + "]";
	}
	

}
