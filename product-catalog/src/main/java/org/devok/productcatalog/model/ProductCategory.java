package org.devok.productcatalog.model;

import javax.persistence.*;

@Entity
public class ProductCategory {
    @EmbeddedId
    ProductCategoryKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    Category category;
}
