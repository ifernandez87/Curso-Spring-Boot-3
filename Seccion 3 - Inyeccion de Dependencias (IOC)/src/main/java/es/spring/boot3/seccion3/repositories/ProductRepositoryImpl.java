package es.spring.boot3.seccion3.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import es.spring.boot3.seccion3.models.Product;

// Ciclo de vida unico por peticióm.
@RequestScope
// Ciclo de vida de la sesion Http (Lo que dura el navegador)
// @SessionScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(Product.builder().id(1L).name("product1").price(100L).build(),
                Product.builder().id(2L).name("product2").price(200L).build(),
                Product.builder().id(3L).name("product3").price(300L).build(),
                Product.builder().id(4L).name("product4").price(400L).build());
    }

    /**
     * Find all elements.
     *
     * @return All elements of Arrays.
     */
    public List<Product> findAll() {
        return this.data;
    }

    /**
     * Find product by unique identifier.
     *
     * @param id Unique product identifier.
     * @return Product.
     */
    public Product findOne(Long id) {
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
