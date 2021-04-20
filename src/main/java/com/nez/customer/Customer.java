package com.nez.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import com.nez.model.Person;

@Entity
@Table(name = "customers")
public class Customer extends Person {
	@Column(name = "address")
	@NotEmpty
	private String address;
	@Column(name = "city")
	@NotEmpty
	private String city;
	@Column(name = "telephone")
	@NotEmpty
	@Digits(fraction = 0, integer = 10)
	private String telephone;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Customer [address=" + address + ", city=" + city + ", telephone=" + telephone + "]";
	}
	
}
