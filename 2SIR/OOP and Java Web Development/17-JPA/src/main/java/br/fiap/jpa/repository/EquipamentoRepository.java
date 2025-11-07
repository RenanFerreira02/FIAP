package br.fiap.jpa.repository;

import br.fiap.jpa.domain.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    public List<Equipamento> findByClienteId(Long idCliente);
}
