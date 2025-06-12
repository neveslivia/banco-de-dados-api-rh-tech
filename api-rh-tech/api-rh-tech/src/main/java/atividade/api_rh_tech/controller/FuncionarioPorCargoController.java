package atividade.api_rh_tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import atividade.api_rh_tech.model.FuncionarioPorCargo;
import atividade.api_rh_tech.service.FuncionariosPorCargoService;
@RestController
@RequestMapping("/funcionarios-por-cargo")
public class FuncionarioPorCargoController {

     @Autowired
    private FuncionariosPorCargoService service;

    @GetMapping
    public List<FuncionarioPorCargo> listar(
        @RequestParam(required = false) Long cargoId,
        @RequestParam(required = false) Long funcionarioId
    ) {
        if (cargoId != null) return service.filtrarPorCargo(cargoId);
        if (funcionarioId != null) return service.filtrarPorFuncionario(funcionarioId);
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public FuncionarioPorCargo detalhar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Vínculo não encontrado"));
    }

    @PostMapping
    public FuncionarioPorCargo criar(@RequestBody FuncionarioPorCargo fpc) {
        return service.criar(fpc);
    }

    @PutMapping("/{id}")
    public FuncionarioPorCargo atualizar(@PathVariable Long id, @RequestBody FuncionarioPorCargo fpc) {
        return service.atualizar(id, fpc);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}
