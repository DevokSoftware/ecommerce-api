package org.devok.productcatalog.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductCategoryKey implements Serializable {
    @Column(name = "product_id")
    Long product;

    @Column(name = "category_id")
    Long category;
}
