package es.ejemplo.factura.ejemplofactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@RequestScope
// @JsonIgnoreProperties({"targetSource","advisors"})
public class Client {

    @Value("${client.name}")
    private String name;

    @Value("${client.lastname}")
    private String lastname;
}
