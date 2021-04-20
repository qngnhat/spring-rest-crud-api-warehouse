package com.nez.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

@Entity
@Table(name = "products")
public class Product extends NamedEntity{
	
	private String photo;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	@DecimalMin(value = "0")
	private int unitInStock;
	
	@DecimalMin(value = "0")
	private int price;
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
}
