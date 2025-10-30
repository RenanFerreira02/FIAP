package br.fiap.jpa.web.controller;

import br.fiap.jpa.domain.Equipamento;
import br.fiap.jpa.service.EquipamentoService;
import br.fiap.jpa.web.dto.EquipamentoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipamento cadastrar(@RequestBody EquipamentoDTO equipamentoDTO) {
        return service.inserir(equipamentoDTO);
    }

}
