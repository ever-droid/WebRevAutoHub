package com.revautohub.backend.product.service.impl;

import com.revautohub.backend.product.dto.ProductRequestDTO;
import com.revautohub.backend.product.dto.ProductResponseDTO;
import com.revautohub.backend.product.entity.Product;
import com.revautohub.backend.product.repository.ProductRepository;
import com.revautohub.backend.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    //Repository used to interact with the database
    private final ProductRepository productRepository;

    //Constructor injection
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //Receive product data from frontend, save it into database,
    //then return the saved product
    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){

        //Create a new product entity
        Product product = new Product();

        //Transfer data from DTO to entity
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setStockQuantity(productRequestDTO.getStockQuantity());
        product.setImageUrl(productRequestDTO.getImageUrl());
        product.setCategory(productRequestDTO.getCategory());

        //Save product to database
        Product savedProduct = productRepository.save(product);

        //Create response DTO
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        //Transfer saved entity data into response DTO
        responseDTO.setId(savedProduct.getId());
        responseDTO.setName(savedProduct.getName());
        responseDTO.setDescription(savedProduct.getDescription());
        responseDTO.setPrice(savedProduct.getPrice());
        responseDTO.setStockQuantity(savedProduct.getStockQuantity());
        responseDTO.setImageUrl(savedProduct.getImageUrl());
        responseDTO.setCategory(savedProduct.getCategory());
        responseDTO.setCreatedAt(savedProduct.getCreatedAt());

        return responseDTO;

    }

    //Retrieve all products from database
    @Override
    public List<ProductResponseDTO> getAllProducts() {

        List<Product> products =productRepository.findAll();

        return products.stream().map(product -> {

            ProductResponseDTO responseDTO = new ProductResponseDTO();

            responseDTO.setId(product.getId());
            responseDTO.setName(product.getName());
            responseDTO.setDescription(product.getDescription());
            responseDTO.setPrice(product.getPrice());
            responseDTO.setStockQuantity(product.getStockQuantity());
            responseDTO.setImageUrl(product.getImageUrl());
            responseDTO.setCategory(product.getCategory());
            responseDTO.setCreatedAt(product.getCreatedAt());

            return responseDTO;

        }).collect(Collectors.toList());

    }

    //Retrieve one product using product ID
    @Override
    public ProductResponseDTO getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setId(product.getId());
        responseDTO.setName(product.getName());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setStockQuantity(product.getStockQuantity());
        responseDTO.setImageUrl(product.getImageUrl());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setCreatedAt(product.getCreatedAt());

        return responseDTO;
    }

    // Update an existing product
    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setStockQuantity(productRequestDTO.getStockQuantity());
        product.setImageUrl(productRequestDTO.getImageUrl());
        product.setCategory(productRequestDTO.getCategory());

        Product updatedProduct = productRepository.save(product);

        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setId(updatedProduct.getId());
        responseDTO.setName(updatedProduct.getName());
        responseDTO.setDescription(updatedProduct.getDescription());
        responseDTO.setPrice(updatedProduct.getPrice());
        responseDTO.setStockQuantity(updatedProduct.getStockQuantity());
        responseDTO.setImageUrl(updatedProduct.getImageUrl());
        responseDTO.setCategory(updatedProduct.getCategory());
        responseDTO.setCreatedAt(updatedProduct.getCreatedAt());

        return responseDTO;
    }

    // Delete product using ID
    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }



}
