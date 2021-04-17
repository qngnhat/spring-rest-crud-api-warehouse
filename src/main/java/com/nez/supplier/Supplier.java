package com.nez.supplier;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.nez.model.Person;

@Entity
@Table(name = "suppliers")
public class Supplier extends Person{
	private String address;
	private String city;
	private String telephone;
	
}
