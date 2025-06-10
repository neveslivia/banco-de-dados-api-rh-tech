package atividade.api_rh_tech.service;

import java.util.List;

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
    CargosRepository cargosRepository;

    public CargosModel cadastrarCargo(CargosModel cargosModel){
        return cargosRepository.save(cargosModel);
    }

    public List< CargosModel> listarCargos(){
        return cargosRepository.findAll();
    }

    public CargosModel buscarCargosPorId(Long id){
        return cargosRepository.findById(id).orElse(null);
    }

    public CargosModel atualizarCargos(Long id, CargosModel cargoAtualizado){
        CargosModel cargoExixtente = buscarCargosPorId(id);

        cargoExixtente.setNome(cargoAtualizado.getNome());
        cargoExixtente.setDescricao(cargoAtualizado.getDescricao());
        return cargosRepository.save(cargoAtualizado);
    }
    public void deletarCargo(Long id){
        cargosRepository.deleteById(id);
    }




}
