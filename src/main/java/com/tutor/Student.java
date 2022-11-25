package com.tutor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int id;	
	private String name;	
	private String city;	
	
	private Certificate certi;
	
	//cunstruc all	
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	//super class	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	//getters setters class Certificate
	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	//Overide > toStriing
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id +" : "+this.name+" : "+this.city;
	}
	

}
