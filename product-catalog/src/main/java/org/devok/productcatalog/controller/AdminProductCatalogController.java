package org.devok.productcatalog.controller;

import lombok.extern.slf4j.Slf4j;
import org.devok.productcatalog.dto.ProductDTO;
import org.devok.productcatalog.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin/product-catalog")
public class AdminProductCatalogController {
    private final ProductCatalogService productCatalogService;

    @Autowired
    public AdminProductCatalogController(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        log.debug("Creating product: {}", productDTO);
        ProductDTO createdProduct = productCatalogService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDTO productDTO) {
        log.debug("Updating product with id {}: {}", productId, productDTO);
        ProductDTO updatedProduct = productCatalogService.updateProduct(productId, productDTO);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);

    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable("productId") Long productId) {
        log.debug("Deleting product with id {}.", productId);
        productCatalogService.deleteProduct(productId);
    }
}
