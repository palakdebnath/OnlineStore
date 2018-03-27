package com.online.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.online.store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	
	/*@Query("select * from Product where productDescription like %:key%")
	public List<Product> getSelectedProd(@Param("key") String key);
*/
}
