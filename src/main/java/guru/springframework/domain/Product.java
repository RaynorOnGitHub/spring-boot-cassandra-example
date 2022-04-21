package guru.springframework.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
@Table
public class Product {

    @PrimaryKey
    private UUID id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public Product(UUID id, String description, BigDecimal price, String imageUrl) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    public Product() {
        this(UUID.randomUUID(), "", BigDecimal.valueOf(0), "");
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
