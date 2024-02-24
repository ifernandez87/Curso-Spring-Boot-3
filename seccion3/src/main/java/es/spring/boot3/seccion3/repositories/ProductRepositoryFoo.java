package es.spring.boot3.seccion3.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.spring.boot3.seccion3.models.Product;

//Dar preferencia de Instanciación en el contexto de Spring
// @Primary
@Repository
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(Product.builder().id(1L).name("Producto unico").price(599L).build());
    }

    @Override
    public Product findOne(Long id) {
        return Product.builder().id(id).name("Producto unico").price(599L).build();
    }

}
