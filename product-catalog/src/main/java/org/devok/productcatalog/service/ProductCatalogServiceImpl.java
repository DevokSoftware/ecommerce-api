package org.devok.productcatalog.service;

import lombok.RequiredArgsConstructor;
import org.devok.productcatalog.dto.ProductDTO;
import org.devok.productcatalog.mapper.ProductMapper;
import org.devok.productcatalog.model.Product;
import org.devok.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.mapToProduct(productDTO);
        return productMapper.mapToProductDTO(productRepository.save(product));
    }

    @Override
    public Set<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
         return productList.stream().map(x -> productMapper.mapToProductDTO(x)).collect(Collectors.toSet());
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = fetchProductById(productId);
        return productMapper.mapToProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product product = fetchProductById(productId);
        Product updateProduct = productMapper.mapToProduct(productDTO);
        return productMapper.mapToProductDTO(productRepository.save(product.update(updateProduct)));
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = fetchProductById(productId);
        productRepository.delete(product);
    }

    private Product fetchProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent()) {
            //TODO Custom Exception
            throw new RuntimeException();
        }
        return product.get();
    }
}
