package es.spring.boot3.seccion3.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Product implements Cloneable {

    private Long id;
    private String name;
    private Long price;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return Product.builder().id(id).name(name).price(price).build();
        }
    }

}
