package com.nez.order;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import com.nez.model.BaseEntity;
import com.nez.product.Product;

@Entity
@Table(name = "Order_items")
public class OrderItem extends BaseEntity{
	@ManyToOne(optional = true)
	@JoinColumn(name = "order_id")
	private Order order;
	@ManyToOne(optional = true)
	@JoinColumn(name = "product_id")
	private Product product;
	@DecimalMin(value = "0")
	private int quantity;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
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
