package org.devok.productcatalog.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "product")
    private Set<ProductCategory> productCategories;
    private String description;
    private String manufacturer;
    private byte[] image;
    private BigDecimal price;
    private Integer stock;
    private Boolean visible;
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(Set<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Product update(Product updateProduct){
        if(updateProduct.getVisible() != null){
            this.visible = updateProduct.getVisible();
        }
        if(updateProduct.getProductCategories() != null){
            this.productCategories = updateProduct.getProductCategories();
        }
        if(updateProduct.getDescription() != null){
            this.description = updateProduct.getDescription();
        }
        if(updateProduct.getImage() != null){
            this.image = updateProduct.getImage();
        }
        if(updateProduct.getManufacturer() != null){
            this.manufacturer = updateProduct.getManufacturer();
        }
        if(updateProduct.getName() != null){
            this.name = updateProduct.getName();
        }
        if(updateProduct.getPrice() != null){
            this.price = updateProduct.getPrice();
        }
        if(updateProduct.getStock() != null){
            this.stock = updateProduct.getStock();
        }
        return this;
    }
}
