package org.devok.productcatalog.model;

import javax.persistence.*;

@Entity
public class ProductCategory {
    @EmbeddedId
    private ProductCategoryKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private  Category category;

    public ProductCategory() {
    }

    public ProductCategory(ProductCategoryKey id) {
        this.id = id;
    }

    public ProductCategoryKey getId() {
        return id;
    }
}
