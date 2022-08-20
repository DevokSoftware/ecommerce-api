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
@RequestMapping("/product-catalog")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogService productCatalogService;

    @PostMapping
    public void createProduct(@RequestBody ProductDTO productDTO) {
        log.debug("Creating product: {}", productDTO);
        productCatalogService.createProduct(productDTO);
    }

    @GetMapping
    public ResponseEntity<String> getProductCatalog() {
        return ResponseEntity.status(HttpStatus.OK).body("HELLO WORLD!!");
    }
}
