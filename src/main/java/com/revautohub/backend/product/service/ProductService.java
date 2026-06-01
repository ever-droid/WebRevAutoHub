package com.revautohub.backend.product.service;

import com.revautohub.backend.product.dto.ProductRequestDTO;
import com.revautohub.backend.product.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    /*Receive product from the frontend, save it into the database,
     and return the same product*/
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    //Retrieve all products
    List<ProductResponseDTO> getAllProducts();

    //Update an existing product
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);

    //Retrieve a single product using its ID
    ProductResponseDTO getProductById(Long id);

    //Delete a product using its ID
    void deleteProduct(Long id);


}
