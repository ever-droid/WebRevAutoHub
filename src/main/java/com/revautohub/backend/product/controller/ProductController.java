package com.revautohub.backend.product.controller;

import com.revautohub.backend.product.dto.ProductRequestDTO;
import com.revautohub.backend.product.dto.ProductResponseDTO;
import com.revautohub.backend.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Service used to handle product business logic
    private final ProductService productService;

    // Constructor injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Receive product data from frontend, send it to service for saving,
    // and return the saved product
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestBody ProductRequestDTO productRequestDTO) {

        ProductResponseDTO savedProduct = productService.createProduct(productRequestDTO);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Get all products from the database
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

        List<ProductResponseDTO> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    // Get one product using its ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {

        ProductResponseDTO product = productService.getProductById(id);

        return ResponseEntity.ok(product);
    }

    // Receive updated product data from frontend, send it to service,
    // and return the updated product
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO productRequestDTO) {

        ProductResponseDTO updatedProduct =
                productService.updateProduct(id, productRequestDTO);

        return ResponseEntity.ok(updatedProduct);
    }

    // Delete one product using its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

}
