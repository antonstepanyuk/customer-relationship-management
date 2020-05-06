package by.itstep.crm.entities;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "products")
//@PrimaryKeyJoinColumn(name="product_type_id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(optional = true, cascade = ALL)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;
    private String type;
    private double price;
    private double discount;

    public Product() {
    }

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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
