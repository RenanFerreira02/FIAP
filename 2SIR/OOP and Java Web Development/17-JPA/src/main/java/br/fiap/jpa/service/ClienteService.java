package br.fiap.jpa.service;

import br.fiap.jpa.domain.Cliente;
import br.fiap.jpa.domain.Equipamento;
import br.fiap.jpa.repository.ClienteRepository;
import br.fiap.jpa.repository.EquipamentoRepository;
import br.fiap.jpa.web.config.SenhaConfig;
import br.fiap.jpa.web.dto.ClienteDTO;
import br.fiap.jpa.web.dto.EquipamentoDTO;
import br.fiap.jpa.web.dto.LoginDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    private final EquipamentoRepository equipRepository;

    private final SenhaConfig senhaConfig;

    public ClienteService(ClienteRepository repository, EquipamentoRepository equipRepository, SenhaConfig senhaConfig) {
        this.repository = repository;
        this.equipRepository = equipRepository;
        this.senhaConfig = senhaConfig;
    }

    public Cliente cadastrar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        cliente.setNome(clienteDTO.getNome());

        cliente.setTelefone(clienteDTO.getTelefone());

        cliente.setEmail(clienteDTO.getEmail());

        cliente.setSenha(senhaConfig.encoder().encode(clienteDTO.getSenha()));

        return repository.save(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Equipamento> listarEquipamentoPorCliente(Long id) {
        return equipRepository.findByClienteId(id);
    }

    public boolean autenticar(LoginDTO dto) {
        return repository.findByEmail(dto.getEmail())
                .map(c -> senhaConfig.encoder().matches(dto.getSenha(), c.getSenha()) ).orElse(false);
    }
}
