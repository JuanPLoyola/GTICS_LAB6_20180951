package org.example.lab7.controller;


import org.example.lab7.repository.UsuarioRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

    final UsuarioRepositorio usuarioRepositorio;

    public IndexController(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @GetMapping(value={"/Index"})
    public String principal(){
        return "/navbar"; }


}