package es.ejemplo.manejo.excepciones.models.domain;

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
public class User {

    private Long id;
    private String name;
    private String lastname;

    private Role role;

}
