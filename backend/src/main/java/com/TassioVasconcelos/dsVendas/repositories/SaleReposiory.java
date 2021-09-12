package com.TassioVasconcelos.dsVendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TassioVasconcelos.dsVendas.controllers.SaleSuccesDTO;
import com.TassioVasconcelos.dsVendas.controllers.SaleSumDTO;
import com.TassioVasconcelos.dsVendas.entities.Sale;

public interface SaleReposiory extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.TassioVasconcelos.dsVendas.controllers.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.TassioVasconcelos.dsVendas.controllers.SaleSuccesDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccesDTO> succesGroupedBySeller();
}
