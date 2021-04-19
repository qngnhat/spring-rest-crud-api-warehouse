package com.nez.customer;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customers {
	private List<Customer> customers;

	@XmlElement
	public List<Customer> getCustomers() {
		if (customers == null) {
			customers = new ArrayList<>();
		}
		return customers;
	}
}
