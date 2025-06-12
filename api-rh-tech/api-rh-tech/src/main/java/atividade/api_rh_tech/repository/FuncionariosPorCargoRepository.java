package atividade.api_rh_tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import atividade.api_rh_tech.model.FuncionarioPorCargo;

public interface FuncionariosPorCargoRepository extends JpaRepository<FuncionarioPorCargo,Long> {
    List<FuncionarioPorCargo> findByCargoId(Long cargoId);
    List<FuncionarioPorCargo> findByFuncionarioId(Long funcionarioId);

}
