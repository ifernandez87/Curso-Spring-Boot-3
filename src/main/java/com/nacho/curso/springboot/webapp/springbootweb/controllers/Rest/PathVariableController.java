package com.nacho.curso.springboot.webapp.springbootweb.controllers.Rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nacho.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

@RestController
@RequestMapping("/api/pathVariable")
public class PathVariableController {
    // En
    @Autowired
    private Environment environment;

    // Se pueden inyectar el @Value por metodo o en clase
    @Value("${config.username}")
    private String username;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> listOfValues2;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String listOfValuesString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Value("${config.code}")
    private Integer code;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable(name = "message") String message) {
        return ParamDto.builder().message(message).build();
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVariable(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", Integer.valueOf(environment.getProperty("config.code")));
        json.put("code3", (environment.getProperty("config.code", Long.class)));
        json.put("listOfValues", listOfValues);
        json.put("listOfValues2", listOfValues2);
        json.put("listOfValuesString", listOfValuesString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        json.put("code", code);
        return json;
    }

}
