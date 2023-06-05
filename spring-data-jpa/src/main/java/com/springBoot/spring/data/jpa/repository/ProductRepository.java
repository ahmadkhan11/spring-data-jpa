package com.springBoot.spring.data.jpa.repository;

import com.springBoot.spring.data.jpa.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,String> {

}
