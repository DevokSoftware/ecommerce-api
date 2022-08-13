package org.devok.productcatalog.service;

import org.devok.productcatalog.model.Product;
import org.devok.productcatalog.resource.ProductCatalogRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogService {
    public void createProduct(ProductCatalogRequest productCatalogRequest) {
        Product product = Product.builder().name(productCatalogRequest.name()).build();
    }
}
