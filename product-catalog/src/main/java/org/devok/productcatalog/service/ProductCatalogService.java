package org.devok.productcatalog.service;

import org.devok.productcatalog.dto.ProductDTO;

import java.util.Set;

public interface ProductCatalogService {
    ProductDTO createProduct(ProductDTO productDTO);
    Set<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long productId);
    ProductDTO updateProduct(Long productId, ProductDTO productDTO);
    void deleteProduct(Long productId);
}
