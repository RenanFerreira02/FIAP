package br.fiap.jpa.repository;

import br.fiap.jpa.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Optional<Cliente> findByEmail(String email);

}
