package com.nez.entities;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "employees")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Employee extends BaseAccount{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
