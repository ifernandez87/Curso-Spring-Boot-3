package es.spring.boot3.seccion3.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import es.spring.boot3.seccion3.models.Product;
import es.spring.boot3.seccion3.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Value("${config.price.tax:1.25d}")
    public Double priceTax;

    // @Autowired
    // public void setRepository(@Qualifier("productList") ProductRepository
    // repository) {
    // this.repository = repository;
    // }

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * priceTax;
            return Product.builder().id(p.getId()).name(p.getName()).price(priceImp.longValue()).build();
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findOne(id);
    }

}
