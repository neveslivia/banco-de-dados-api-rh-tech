package atividade.api_rh_tech.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.api_rh_tech.model.FuncionariosModel;
import atividade.api_rh_tech.repository.FuncionariosRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Service
public class FuncionariosService {

    @Autowired
    FuncionariosRepository funcionariosRepository;

    public FuncionariosModel cadastrarFuncionario(FuncionariosModel funcionario){
        return funcionariosRepository.save(funcionario);
    }
    
    public List<FuncionariosModel> listarFuncionarios(){
        return funcionariosRepository.findAll();
    }
    public FuncionariosModel buscarFuncionarioPorId(Long id){
        return funcionariosRepository.findById(id).orElse(null);

    }

    public FuncionariosModel atualizarFuncionario(Long id,FuncionariosModel funcionarioAtualizado){
        FuncionariosModel funcionarioExistente = buscarFuncionarioPorId(id);
        funcionarioExistente.setNome(funcionarioAtualizado.getNome());
        funcionarioExistente.setEmail(funcionarioAtualizado.getEmail());
        funcionarioExistente.setSenha(funcionarioAtualizado.getSenha());
        funcionarioExistente.setCep(funcionarioAtualizado.getCep());
        funcionarioExistente.setEndereco(funcionarioAtualizado.getEndereco());
        funcionarioExistente.setNumero(funcionarioAtualizado.getNumero());
        funcionarioExistente.setBairro(funcionarioAtualizado.getBairro());
        funcionarioExistente.setCidade(funcionarioAtualizado.getCidade());
        funcionarioExistente.setEstado(funcionarioAtualizado.getEstado());
        return funcionariosRepository.save(funcionarioExistente);
    }

    public void deletarFuncionario(Long id){
        funcionariosRepository.deleteById(id);
    }


}
