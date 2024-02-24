package es.spring.boot3.seccion3.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.spring.boot3.seccion3.models.Product;

@Primary
@Repository
public class ProductRepositoryJson implements ProductRepository {

    private List<Product> list;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.list = Arrays.asList(mapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return this.list;
    }

    @Override
    public Product findOne(Long id) {
        return this.list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
