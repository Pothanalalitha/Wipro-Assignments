package com.example.wipro.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wipro.entities.Product;

public interface productRepository extends JpaRepository<Product,Long> 
{

}
