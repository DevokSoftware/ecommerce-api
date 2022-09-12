package org.devok.productcatalog.service;


import org.devok.productcatalog.dto.ProductDTO;
import org.devok.productcatalog.mapper.ProductMapper;
import org.devok.productcatalog.mapper.ProductMapperImpl;
import org.devok.productcatalog.model.Product;
import org.devok.productcatalog.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class ProductCatalogServiceTests {
    private static final Long PRODUCT_ID = 1L;
    private static final String PRODUCT_NAME = "iPhone 12";
    private static final String NEW_PRODUCT_NAME = "iPhone 13";
    private static final String PRODUCT_DESCRIPTION = "That's a product.";
    private static final BigDecimal PRODUCT_PRICE = new BigDecimal(10);
    private static final String PRODUCT_MANUFACTURER = "Apple";
    private static final Integer PRODUCT_STOCK = 999;
    private static final boolean PRODUCT_VISIBLE = true;

    private static List<Product> products;
    private static Product product;

    private static ProductRepository productRepository;
    private static ProductCatalogServiceImpl productCatalogService;

    @BeforeAll
    static void setUp() {
        initializeProducts();
        productRepository = mock(ProductRepository.class);
        ProductMapper productMapper = new ProductMapperImpl();
        productCatalogService = new ProductCatalogServiceImpl(productMapper, productRepository);
    }

    @Test
    void getAllProducts() {
        Mockito.when(productRepository.findAll()).thenReturn(products);
        Set<ProductDTO> foundProducts = productCatalogService.getAllProducts();
        assertEquals(1, foundProducts.size());
    }

    @Test
    void createNewProduct() {
        ProductDTO productRequest = ProductDTO.builder()
                .name(NEW_PRODUCT_NAME)
                .price(new BigDecimal(10))
                .stock(20)
                .build();
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        productCatalogService.createProduct(productRequest);
        Mockito.verify(productRepository, times(1)).save(product);
    }

    @Test
    void updateProductStockAndPrice() {
        ProductDTO productRequest = ProductDTO.builder()
                .price(new BigDecimal(10))
                .stock(20)
                .build();
        Mockito.when(productRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(product));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        ProductDTO updatedProduct = productCatalogService.updateProduct(PRODUCT_ID, productRequest);
        Mockito.verify(productRepository, times(1)).save(product);
        assertEquals(product.getId(), updatedProduct.getId());
        assertEquals(20, updatedProduct.getStock());
        assertEquals(new BigDecimal(10), updatedProduct.getPrice());
    }

    @Test
    void deleteProduct() {
        Mockito.when(productRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(product));
        productCatalogService.deleteProduct(PRODUCT_ID);
        Mockito.verify(productRepository, times(1)).delete(product);
    }

    private static void initializeProducts(){
        product = new Product();
        product.setName(PRODUCT_NAME);
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setPrice(PRODUCT_PRICE);
        product.setManufacturer(PRODUCT_MANUFACTURER);
        product.setStock(PRODUCT_STOCK);
        product.setVisible(PRODUCT_VISIBLE);
        products = new ArrayList<>();
        products.add(product);
    }
}
