package atividade.api_rh_tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import atividade.api_rh_tech.model.CargosModel;
import atividade.api_rh_tech.service.CargosService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/rh/cargos")
public class CargosController {

    @Autowired
    CargosService cargosService;


    @PostMapping
    public CargosModel registrarCargo(@RequestBody CargosModel cargos) {
        return cargosService.salvar(cargos);
    }
    

    @GetMapping
    public List<CargosModel> buscarCargos() {
        return cargosService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargosModel> buscarCragosId(@PathVariable Long id) {
    return cargosService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}



    @PutMapping("/{id}")
    public CargosModel atualizarCargo(@PathVariable Long id, @RequestBody CargosModel cargo) {
        return cargosService.atualizar(id, cargo);
    }

    @DeleteMapping("/{id}")
    public void deletarCargo(@PathVariable Long id){
        cargosService.excluir(id);
    }
    


}
