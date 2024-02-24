package es.spring.boot3.seccion3.services;

import java.util.List;

import es.spring.boot3.seccion3.models.Product;

public interface ProductService {

    /**
     * Find All elements.
     *
     * @return All elements.
     */
    List<Product> findAll();

    /**
     * Find one element with unique identifier.
     *
     * @param id Unique identifier.
     * @return Product.
     */
    Product findById(Long id);

}
