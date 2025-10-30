package br.fiap.jpa.web.dto;

import br.fiap.jpa.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EquipamentoDTO {

    private Long id;

    private Cliente cliente;

    private String marca;

    private String modelo;

    private String tipo;

    private String numeroSerie;

    private LocalDate dataCadastro;


}
