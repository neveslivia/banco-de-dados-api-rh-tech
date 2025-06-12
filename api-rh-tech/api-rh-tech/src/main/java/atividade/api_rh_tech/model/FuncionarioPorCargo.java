package atividade.api_rh_tech.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "funcionarios_por_cargo")
public class FuncionarioPorCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private FuncionariosModel funcionario;

    @ManyToOne
    private CargosModel cargo;

    private String detalhes;
    private LocalDate dataInicio;
    private LocalDate dataFim;
   

}
