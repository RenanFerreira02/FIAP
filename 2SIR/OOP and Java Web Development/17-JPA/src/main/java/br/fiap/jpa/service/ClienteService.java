package br.fiap.jpa.service;

import br.fiap.jpa.domain.Cliente;
import br.fiap.jpa.repository.ClienteRepository;
import br.fiap.jpa.web.dto.ClienteDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

}
