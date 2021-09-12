package com.TassioVasconcelos.dsVendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TassioVasconcelos.dsVendas.controllers.SaleSuccesDTO;
import com.TassioVasconcelos.dsVendas.controllers.SaleSumDTO;
import com.TassioVasconcelos.dsVendas.dto.SaleDTO;
import com.TassioVasconcelos.dsVendas.entities.Sale;
import com.TassioVasconcelos.dsVendas.repositories.SaleReposiory;
import com.TassioVasconcelos.dsVendas.repositories.SellerReposiory;

@Service
public class SaleService {
	
	
	@Autowired
	private SaleReposiory repository;
	
	@Autowired
	private SellerReposiory sellerrepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageble){
		sellerrepository.findAll();
		Page<Sale> result = repository.findAll(pageble);
		
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccesDTO> succesGroupedBySeller() {
		return repository.succesGroupedBySeller();
	}
}
