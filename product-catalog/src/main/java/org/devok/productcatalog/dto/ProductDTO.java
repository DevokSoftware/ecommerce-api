package org.devok.productcatalog.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private Set<CategoryDTO> productCategories;
    private String description;
    private String manufacturer;
    private byte[] image;
    private BigDecimal price;
    private int stock;
    private OffsetDateTime createdDate;
}
