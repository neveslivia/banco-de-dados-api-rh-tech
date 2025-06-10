package atividade.api_rh_tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import atividade.api_rh_tech.model.FuncionariosModel;
import atividade.api_rh_tech.service.FuncionariosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/rh/funcionarios")
public class FuncionariosController {

    @Autowired
    FuncionariosService funcionariosService;

    @PostMapping
    public FuncionariosModel registrarFuncionario(@RequestBody FuncionariosModel funcionario) {
        return funcionariosService.cadastrarFuncionario(funcionario);
    }
    

    @GetMapping
    public List<FuncionariosModel> buscarFuncionarios() {
        return funcionariosService.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public FuncionariosModel buscarFuncionarioPorId(@PathVariable Long id) {
        return funcionariosService.buscarFuncionarioPorId(id);
    }

    @PutMapping("/{id}")
    public FuncionariosModel atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionariosModel funcionario) {
        return funcionariosService.atualizarFuncionario(id, funcionario);
    }

    @DeleteMapping("{id}")
    public void deletarFuncionario(Long id){
        funcionariosService.deletarFuncionario(id);

    }

    
    


}
