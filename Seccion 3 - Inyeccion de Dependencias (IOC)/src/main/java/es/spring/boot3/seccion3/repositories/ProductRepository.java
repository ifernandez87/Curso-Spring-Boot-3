package es.spring.boot3.seccion3.repositories;

import java.util.List;

import es.spring.boot3.seccion3.models.Product;

public interface ProductRepository {

    public List<Product> findAll();

    Product findOne(Long id);

}
