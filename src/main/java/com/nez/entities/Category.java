package com.nez.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends NamedEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
