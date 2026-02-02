/*package com.hsbc.service;

import com.hsbc.entity.Product;
import com.hsbc.exception.InvalidIDException;
import com.hsbc.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public Product findProduct(int id) throws Exception{
        Optional<Product> optionalProduct = productRepo.findById(id);
        Product product = optionalProduct.orElseThrow(
                ()->new InvalidIDException("Id is not valid"+id)

        );
        return product;
    }
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }
    public Product updateProduct(Product product) throws Exception {
        findProduct(product.getId());
        return productRepo.save(product);
    }
    public Product deleteProduct(int id) throws Exception{
        //find product with id
        Product product = findProduct(id);
        //delete by id
        productRepo.deleteById(id);
        //return the found product
        return product;
    }

    public List<Product> findAllProduct(){
        return productRepo.findAll();
    }

    public List<Product> getProductsByName(String name) {
        return productRepo.findByName(name);
    }

    public List<Product> findProductByName(String name){
        List<Product> products = productRepo.findByName(name);
        return products;
    }

    public List<Product> findByPartialName(String name){
        List<Product> products = productRepo.findByPartialName(name);
        return products;
    }
}*/

// java
package com.hsbc.service;

import com.hsbc.entity.Product;
import com.hsbc.exception.ResourceNotFoundException;
import com.hsbc.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product saveProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        return productRepo.save(product);
    }

    public Product findProduct(int id) throws ResourceNotFoundException {
        return productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    public Product addProduct(Product product) {
        return saveProduct(product);
    }

    public Product updateProduct(int id, Product product) throws ResourceNotFoundException {
        Product existing = findProduct(id);
        // ensure saved entity uses the requested id
        product.setId(existing.getId());
        return productRepo.save(product);
    }

    public void deleteProduct(int id) throws ResourceNotFoundException {
        // will throw ResourceNotFoundException if not present
        findProduct(id);
        productRepo.deleteById(id);
    }

    public List<Product> findAllProduct() {
        return productRepo.findAll();
    }

    public List<Product> getProductsByName(String name) {
        return productRepo.findByName(name);
    }

    public List<Product> findProductByName(String name) {
        return productRepo.findByName(name);
    }

    public List<Product> findByPartialName(String name) {
        return productRepo.findByPartialName(name);
    }
}

