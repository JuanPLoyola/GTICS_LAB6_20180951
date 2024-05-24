package org.example.lab7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

    //final TecnicoRepository tecnicoRepository;

   // public TecnicosController(TecnicoRepository tecnicoRepository) {
   //     this.tecnicoRepository = tecnicoRepository;
//}

    @GetMapping(value={"/Index"})
    public String principal(){
        return "/GTICSF"; }




}