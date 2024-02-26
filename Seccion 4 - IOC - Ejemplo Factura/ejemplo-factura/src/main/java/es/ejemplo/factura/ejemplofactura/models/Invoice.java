package es.ejemplo.factura.ejemplofactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Component
// Varias Aplicaciones dentro de un mismo contexto (Tomcat) vs Singleton
@ApplicationScope
// @JsonIgnoreProperties({"targetSource","advisors"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired()
    @Qualifier("default")
    private List<Item> items;

    @PostConstruct()
    public void init() {
        System.out.println("Creating Invoce component");
        System.out.println(client);
        System.out.println(description);
        System.out.println(items);
    }

    @PreDestroy()
    public void destroy() {
        System.out.println("Remove Invoce component");
    }

    public int getTotal() {
        return items.stream()
                .map(item -> item.getImport())
                .reduce(0, (sum, importe) -> sum + importe);
    }

}
