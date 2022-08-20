package org.devok.productcatalog.mapper;

import org.devok.productcatalog.dto.ProductDTO;
import org.devok.productcatalog.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product mapToProduct(ProductDTO productDTO);

    ProductDTO mapToProductDTO(Product product);

}
