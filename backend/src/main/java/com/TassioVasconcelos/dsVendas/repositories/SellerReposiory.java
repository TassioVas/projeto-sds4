package com.TassioVasconcelos.dsVendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TassioVasconcelos.dsVendas.entities.Seller;

public interface SellerReposiory extends JpaRepository<Seller, Long> {

	

}
