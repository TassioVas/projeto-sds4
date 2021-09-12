package com.TassioVasconcelos.dsVendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TassioVasconcelos.dsVendas.dto.SaleDTO;
import com.TassioVasconcelos.dsVendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);	
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> list = service.amountGroupedBySeller();	
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/succes-by-seller")
	public ResponseEntity<List<SaleSuccesDTO>> succesGroupedBySeller(){
		List<SaleSuccesDTO> list = service.succesGroupedBySeller();	
		return ResponseEntity.ok(list);
	}

}
