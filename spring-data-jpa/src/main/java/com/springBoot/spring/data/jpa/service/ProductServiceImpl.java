package com.springBoot.spring.data.jpa.service;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.springBoot.spring.data.jpa.entity.Product;
import com.springBoot.spring.data.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  ProductRepository productRepository;

  @Override
  public List<Product> getProductList() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product getProductById(String id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product Not Found :" + id));
  }

  @Override
  public Product updateProduct(String id, Product product) {
    productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"+id));
    product.setId(id);
    return productRepository.save(product);
  }

  @Override
  public void deleteProduct(String id) {
    productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product Not Found :"+id));
    productRepository.deleteById(id);
  }
}
