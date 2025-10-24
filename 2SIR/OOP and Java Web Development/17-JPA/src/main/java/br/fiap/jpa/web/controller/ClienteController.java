package br.fiap.jpa.web.controller;

import br.fiap.jpa.domain.Cliente;
import br.fiap.jpa.service.ClienteService;
import br.fiap.jpa.web.dto.ClienteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody ClienteDTO clienteDTO) {
        return service.cadastrar(clienteDTO);
    }


    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> listarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
