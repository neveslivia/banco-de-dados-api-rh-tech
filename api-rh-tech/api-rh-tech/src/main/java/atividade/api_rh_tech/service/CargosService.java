package atividade.api_rh_tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.api_rh_tech.model.CargosModel;
import atividade.api_rh_tech.repository.CargosRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@Service
public class CargosService {

    @Autowired
    private CargosRepository cargoRepository;

    public List<CargosModel> listarTodos() {
        return cargoRepository.findAll();
    }

    public Optional<CargosModel> buscarPorId(Long id) {
        return cargoRepository.findById(id);
    }

    public CargosModel salvar(CargosModel cargo) {
        return cargoRepository.save(cargo);
    }

    public CargosModel atualizar(Long id, CargosModel novoCargo) {
        return cargoRepository.findById(id).map(cargo -> {
            cargo.setNome(novoCargo.getNome());
            cargo.setDescricao(novoCargo.getDescricao());
            return cargoRepository.save(cargo);
        }).orElseThrow(() -> new RuntimeException("Cargo não encontrado"));
    }

    public void excluir(Long id) {
        if (!cargoRepository.existsById(id)) {
            throw new RuntimeException("Cargo não encontrado");
        }
        cargoRepository.deleteById(id);
    }



}
