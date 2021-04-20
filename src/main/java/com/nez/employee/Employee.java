package com.nez.employee;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.nez.model.BaseAccount;

@Entity
@Table(name = "employees")
public class Employee extends BaseAccount{
	
}
