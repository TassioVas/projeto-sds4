package com.TassioVasconcelos.dsVendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TassioVasconcelos.dsVendas.dto.SellerDTO;
import com.TassioVasconcelos.dsVendas.entities.Seller;
import com.TassioVasconcelos.dsVendas.repositories.SellerReposiory;

@Service
public class SellerService {
	
	
	@Autowired
	private SellerReposiory repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	
}
