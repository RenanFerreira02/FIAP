package br.fiap.jpa.service;

import br.fiap.jpa.domain.Cliente;
import br.fiap.jpa.domain.Equipamento;
import br.fiap.jpa.repository.ClienteRepository;
import br.fiap.jpa.repository.EquipamentoRepository;
import br.fiap.jpa.web.dto.EquipamentoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.NoSuchElementException;

@Service
public class EquipamentoService {

    private final ClienteRepository clienteRepository;

    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(ClienteRepository clienteRepository, EquipamentoRepository equipamentoRepository) {
        this.clienteRepository = clienteRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    @PostMapping
    public Equipamento inserir(EquipamentoDTO dto) {

        var cliente = clienteRepository.findById(dto.getCliente().getId())
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));

        var equipamento = new Equipamento();

        equipamento.setTipo(dto.getTipo());

        equipamento.setMarca(dto.getMarca());

        equipamento.setModelo(dto.getModelo());

        equipamento.setNumeroSerie(dto.getNumeroSerie());

        equipamento.setDataCadastro(dto.getDataCadastro());

        equipamento.setCliente(cliente);

        return equipamentoRepository.save(equipamento);
    }
}
