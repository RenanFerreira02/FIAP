package br.fiap.__Spring_Boot_Aula2.controller;

import br.fiap.__Spring_Boot_Aula2.service.ConversorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    private final ConversorService service;

    public Controller(ConversorService service) {
        this.service = service;
    }

    @PostMapping("/msg")
    public String msg(@RequestParam String nome, Model model) {
        model.addAttribute("nome", nome);

        return "index";
    }

    @PostMapping("/converter")
    public String converter(@RequestParam double temp, Model model) {

        double fahrenheit = service.converteFahrenheit(temp);

        model.addAttribute("temp", fahrenheit);

        return "index";
    }
}
