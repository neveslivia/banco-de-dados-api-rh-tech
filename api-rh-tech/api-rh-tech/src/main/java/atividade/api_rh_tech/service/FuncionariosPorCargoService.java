package atividade.api_rh_tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.api_rh_tech.model.FuncionarioPorCargo;
import atividade.api_rh_tech.repository.FuncionariosPorCargoRepository;

@Service
public class FuncionariosPorCargoService {
       @Autowired
    private FuncionariosPorCargoRepository repository;

    public FuncionarioPorCargo criar(FuncionarioPorCargo vinculo) {
        return repository.save(vinculo);
    }

    public List<FuncionarioPorCargo> listarTodos() {
        return repository.findAll();
    }

    public Optional<FuncionarioPorCargo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public FuncionarioPorCargo atualizar(Long id, FuncionarioPorCargo novoVinculo) {
        return repository.findById(id).map(vinculo -> {
            vinculo.setFuncionario(novoVinculo.getFuncionario());
            vinculo.setCargo(novoVinculo.getCargo());
            vinculo.setDetalhes(novoVinculo.getDetalhes());
            vinculo.setDataInicio(novoVinculo.getDataInicio());
            vinculo.setDataFim(novoVinculo.getDataFim());
            return repository.save(vinculo);
        }).orElseThrow(() -> new RuntimeException("Vínculo não encontrado"));
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Vínculo não encontrado");
        }
        repository.deleteById(id);
    }

    public List<FuncionarioPorCargo> filtrarPorCargo(Long cargoId) {
        return repository.findByCargoId(cargoId);
    }

    public List<FuncionarioPorCargo> filtrarPorFuncionario(Long funcionarioId) {
        return repository.findByFuncionarioId(funcionarioId);
    }

}
