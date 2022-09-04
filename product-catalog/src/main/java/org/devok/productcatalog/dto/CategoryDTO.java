package org.devok.productcatalog.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    private byte[] image;
    private OffsetDateTime createdDate;
}
