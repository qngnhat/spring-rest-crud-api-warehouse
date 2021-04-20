package com.nez.supplier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {
	@Autowired
	SupplierRepository supplierRepo;

	@GetMapping("suppliers")
	public List<Supplier> showResourcesSupplierLists() {
		return supplierRepo.findAll();
	}

	@GetMapping("supplier/{supplierId}")
	public Optional<Supplier> showResourcesSupplier(@PathVariable("supplierId") int id) {
		return supplierRepo.findById(id);
	}

	@PostMapping("supplier")
	public Supplier addSupplier(@RequestBody Supplier supplier) {
		supplierRepo.save(supplier);
		return supplier;
	}

	@PutMapping("supplier")
	public Supplier updateSupplier(@RequestBody Supplier supplier) {
		supplierRepo.save(supplier);
		return supplier;
	}

	@DeleteMapping("supplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int id) {
		Supplier supplier = supplierRepo.getOne(id);
		supplierRepo.delete(supplier);
		return "deleted";
	}
}

