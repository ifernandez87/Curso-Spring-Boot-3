package es.ejemplo.interceptores.seccion7.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/app")
public class FooController {

    @GetMapping("/home")
    public ResponseEntity<?> foo(HttpServletRequest httpServletRequest) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("title", "Bienvenidos al sistema de atencion!");
        data.put("time", new Date());
        data.put("message", httpServletRequest.getAttribute("message"));
        return ResponseEntity.ok(data);
    }
}
