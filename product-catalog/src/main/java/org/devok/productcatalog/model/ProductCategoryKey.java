package org.devok.productcatalog.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductCategoryKey implements Serializable {

    public ProductCategoryKey(){}
    public ProductCategoryKey(Long product, Long category) {
        this.product = product;
        this.category = category;
    }

    @Column(name = "product_id")
    private Long product;

    @Column(name = "category_id")
    private Long category;

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
