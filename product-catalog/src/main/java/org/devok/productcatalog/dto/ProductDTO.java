package org.devok.productcatalog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    @JsonProperty("productId")
    private Long id;
    private String name;
    @JsonProperty("categories")
    private Set<CategoryDTO> productCategories;
    private String description;
    private String manufacturer;
    private byte[] image;
    private BigDecimal price;
    private int stock;
    private OffsetDateTime createdDate;
}
