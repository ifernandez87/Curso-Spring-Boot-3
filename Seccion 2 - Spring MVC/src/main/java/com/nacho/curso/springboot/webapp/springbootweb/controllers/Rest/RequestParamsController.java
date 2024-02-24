package com.nacho.curso.springboot.webapp.springbootweb.controllers.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nacho.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.nacho.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Valor por defecto") String message) {
        return ParamDto.builder().message(message).build();
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam() String text, @RequestParam Integer code) {
        return ParamMixDto.builder().message(text).code(code).build();
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        String code = request.getParameter("code");
        String text = request.getParameter("text");
        return ParamMixDto.builder().message(text).code(Integer.parseInt(code)).build();
    }

}
