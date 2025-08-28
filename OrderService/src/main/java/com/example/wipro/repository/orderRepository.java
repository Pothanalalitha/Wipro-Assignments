package com.example.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wipro.entities.Order;

public interface orderRepository extends JpaRepository<Order,Long> {

}
