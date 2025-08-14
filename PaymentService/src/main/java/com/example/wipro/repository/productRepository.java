package com.example.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wipro.entities.Payment;
@Repository
public interface productRepository extends JpaRepository<Payment,Long> {

}
