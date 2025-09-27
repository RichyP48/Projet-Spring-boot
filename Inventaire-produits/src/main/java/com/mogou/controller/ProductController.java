package com.mogou.controller;

import com.mogou.model.Product;
import com.mogou.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "API for managing products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Get all products", description = "Returns a list of all products in the inventory.")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/low-stock")
    @Operation(summary = "Get low stock products", description = "Returns a list of products with quantity less than 5.")
    public List<Product> getLowStockProducts() {
        return productService.getLowStockProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID", description = "Returns a single product by its ID.")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Adds a new product to the inventory.")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing product", description = "Updates the details of an existing product by its ID.")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Deletes a product from the inventory by its ID.")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}