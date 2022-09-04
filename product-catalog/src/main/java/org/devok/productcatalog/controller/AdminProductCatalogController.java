package org.devok.productcatalog.controller;

import lombok.extern.slf4j.Slf4j;
import org.devok.productcatalog.dto.ProductDTO;
import org.devok.productcatalog.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

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
    public Response createProduct(@RequestBody ProductDTO productDTO) {
        log.debug("Creating product: {}", productDTO);
        ProductDTO createdProduct = productCatalogService.createProduct(productDTO);
        return Response.status(Response.Status.CREATED).entity(createdProduct).build();
    }

    @PutMapping("/{productId}")
    public Response updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDTO productDTO) {
        log.debug("Updating product with id {}: {}", productId, productDTO);
        ProductDTO updatedProduct = productCatalogService.updateProduct(productId, productDTO);
        return Response.status(Response.Status.OK).entity(updatedProduct).build();
    }

    @DeleteMapping("/{productId}")
    public Response deleteProduct(@PathVariable("productId") Long productId) {
        log.debug("Deleting product with id {}.", productId);
        productCatalogService.deleteProduct(productId);
        return Response.status(Response.Status.OK).build();
    }
}
