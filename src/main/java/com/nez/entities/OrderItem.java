package com.nez.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "Order_items")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem extends BaseEntity{
	@ManyToOne(optional = true)
	@JoinColumn(name = "product_id")
	private Product product;
	@DecimalMin(value = "0")
	private int quantity;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
