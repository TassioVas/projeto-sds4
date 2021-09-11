package com.TassioVasconcelos.dsVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TassioVasconcelos.dsVendas.entities.Sale;

public interface SaleReposiory extends JpaRepository<Sale, Long> {

	

}
