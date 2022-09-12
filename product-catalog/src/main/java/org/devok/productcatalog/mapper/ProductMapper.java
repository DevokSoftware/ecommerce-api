package org.devok.productcatalog.mapper;

import org.devok.productcatalog.dto.CategoryDTO;
import org.devok.productcatalog.dto.ProductDTO;
import org.devok.productcatalog.model.Product;
import org.devok.productcatalog.model.ProductCategory;
import org.devok.productcatalog.model.ProductCategoryKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "productCategories", expression = "java(mapProductCategoriesToEntity(productDTO.getId(), productDTO.getProductCategories()))")
    Product mapToProduct(ProductDTO productDTO);

    @Mapping(target = "productCategories", expression = "java(mapProductCategoriesToDto(product.getProductCategories()))")
    ProductDTO mapToProductDTO(Product product);

    default Set<ProductCategory> mapProductCategoriesToEntity(Long productId, Set<CategoryDTO> productCategoriesDTO) {
        Set<ProductCategory> productCategories = new HashSet<>();
        if (productCategoriesDTO != null) {
            for (CategoryDTO categoryDTO : productCategoriesDTO) {
                productCategories.add(new ProductCategory(new ProductCategoryKey(productId, categoryDTO.getId())));
            }
        }
        return productCategories;
    }

    default Set<CategoryDTO> mapProductCategoriesToDto(Set<ProductCategory> productCategories) {
        Set<CategoryDTO> categoryDTOs = new HashSet<>();
        if (productCategories != null) {
            for (ProductCategory productCategory : productCategories) {
                categoryDTOs.add(CategoryDTO.builder().id(productCategory.getId().getCategory()).build());
            }
        }
        return categoryDTOs;
    }
}
