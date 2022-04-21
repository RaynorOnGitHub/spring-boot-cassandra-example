package guru.springframework.repositories;

import guru.springframework.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepositoryTest {

    private final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100.00);
    private final String ANY_PRODUCT_DESCRIPTION = "a cool product";
    private final String DUMMY_IMAGE_URL = "http://an-imageurl.com/image1.jpg";
    private Product product;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        product = new Product();
        product.setDescription(ANY_PRODUCT_DESCRIPTION);
        product.setImageUrl(DUMMY_IMAGE_URL);
        product.setPrice(BIG_DECIMAL_100);
    }

    @AfterEach
    public void tearDown() {
        if (Optional.ofNullable(product.getId()).isPresent() && productRepository.existsById(product.getId())) {
            productRepository.deleteById(product.getId());
        }
    }

    @Test
    void testExistingProduct_whenSearchWithId_thenProductIsFound() {
        // arrange
        productRepository.save(product);
        // action
        Product fetchProduct = productRepository.findById(product.getId()).orElse(null);
        // assert
        assertNotNull(fetchProduct);

        assertEquals(ANY_PRODUCT_DESCRIPTION, fetchProduct.getDescription());
        assertEquals(BIG_DECIMAL_100.compareTo(fetchProduct.getPrice()), 0);
        assertEquals(DUMMY_IMAGE_URL, fetchProduct.getImageUrl());
    }
}