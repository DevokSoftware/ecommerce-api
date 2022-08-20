package org.devok.productcatalog.service;

import org.devok.productcatalog.dto.ProductDTO;
import org.devok.productcatalog.mapper.ProductMapper;
import org.devok.productcatalog.model.Product;
import org.devok.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(ProductDTO productDTO) {
        Product product = productMapper.mapToProduct(productDTO);
        productRepository.save(product);
    }
}
