package es.ejemplo.manejo.excepciones.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Error {

    private String message;

    private String error;

    private int status;

    private Date date;

}
