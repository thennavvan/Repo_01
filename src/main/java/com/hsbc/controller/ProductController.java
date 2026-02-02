// java
package com.hsbc.controller;

import com.hsbc.entity.Product;
import com.hsbc.exception.ResourceNotFoundException;
import com.hsbc.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> products = productService.findAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productid}")
    public ResponseEntity<Product> findProductById(@PathVariable("productid") int productid) {
        Product product = productService.findProduct(productid);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        if (product == null) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Product must not be null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Product name must not be empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        try {
            Product saved = productService.saveProduct(product);
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Product saved successfully");
            body.put("product", saved);
            return ResponseEntity.status(HttpStatus.CREATED).body(body);
        } catch (IllegalArgumentException iae) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Invalid product data");
            body.put("error", iae.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        } catch (Exception e) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Failed to save product");
            body.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

    @PutMapping("/{productid}")
    public ResponseEntity<Object> updateProduct(@PathVariable("productid") int productid,
                                                @RequestBody Product product) {
        if (product == null) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Product must not be null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Product name must not be empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        try {
            Product updated = productService.updateProduct(productid, product);
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Product updated successfully");
            body.put("product", updated);
            return ResponseEntity.ok(body);
        } catch (ResourceNotFoundException rnfe) {
            throw rnfe;
        } catch (IllegalArgumentException iae) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Invalid product data");
            body.put("error", iae.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        } catch (Exception e) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Failed to update product");
            body.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

    @DeleteMapping("/{productid}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productid") int productid) {
        try {
            productService.deleteProduct(productid);
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Product deleted successfully");
            return ResponseEntity.ok(body);
        } catch (ResourceNotFoundException rnfe) {
            throw rnfe;
        } catch (Exception e) {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Failed to delete product");
            body.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }
}