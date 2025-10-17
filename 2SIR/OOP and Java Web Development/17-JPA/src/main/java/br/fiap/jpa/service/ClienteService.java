package br.fiap.jpa.service;

import br.fiap.jpa.domain.Cliente;
import br.fiap.jpa.repository.ClienteRepository;
import br.fiap.jpa.web.dto.ClienteDTO;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;


    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        cliente.setNome(clienteDTO.getNome());

        cliente.setTelefone(clienteDTO.getTelefone());

        cliente.setEmail(clienteDTO.getEmail());

        cliente.setSenha(clienteDTO.getSenha());

        return repository.save(cliente);
    }

}
