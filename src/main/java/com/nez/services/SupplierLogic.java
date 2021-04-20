package com.nez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nez.entities.Product;
import com.nez.entities.Supplier;
import com.nez.repository.SupplierRepository;

@Component
public class SupplierLogic {
	@Autowired
	SupplierRepository supplierRepo;

	@Autowired
	ProductLogic productLogic;
	
	public List<Supplier> getAllSuppliers() {
		return supplierRepo.findAll();
	}

	public Supplier getSupplierById(int id) {
		return supplierRepo.findById(id);
	}

	public Supplier saveSupplier(Supplier supplier) {
		if(supplier.getId() == null) {
			supplier = generateCode(supplier);
		}
		return supplierRepo.save(supplier);
	}

	public boolean deleteSupplier(int id) {
		Supplier supplier = supplierRepo.getOne(id);
		if(supplier == null) return false;
		List<Product> products = productLogic.getProductBySupplierId(id);
		for(Product p : products) {
			p.setSupplier(null);
		}
		supplierRepo.delete(supplier);
		return true;
	}

	public Supplier generateCode(Supplier supplier) {
		if (supplier == null) return null;
		return supplier;
	}
}
