package org.devok.productcatalog.controller;

import lombok.extern.slf4j.Slf4j;
import org.devok.productcatalog.dto.ProductDTO;
import org.devok.productcatalog.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/product-catalog")
public class ProductCatalogController {
    private final ProductCatalogService productCatalogService;

    @Autowired
    public ProductCatalogController(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @GetMapping
    public Response getAllProducts() {
        log.debug("Getting all products.");
        Set<ProductDTO> productsList = productCatalogService.getAllProducts();
        return Response.status(Response.Status.OK).entity(productsList).build();
    }

    @GetMapping("/{productId}")
    public Response getProductById(@PathVariable("productId") Long productId) {
        log.debug("Getting all products.");
        ProductDTO product = productCatalogService.getProductById(productId);
        return Response.status(Response.Status.OK).entity(product).build();
    }
}
