package com.breno.mergulhojava.rh.rhapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.breno.mergulhojava.rh.rhapi.model.Funcionario;
import com.breno.mergulhojava.rh.rhapi.service.FuncionarioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // 201 created
	public Funcionario cadastrar(@RequestBody Funcionario funcionario) {
		log.info(funcionario.toString());
		return funcionarioService.salvar(funcionario);
	}

	@GetMapping
	public List<Funcionario> listarTodos() {
		return funcionarioService.bucarTodosFuncionarios();
	}

	@GetMapping("/{funcionarioId}")
	public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long funcionarioId) {
		return funcionarioService.buscarFuncionarioPorId(funcionarioId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{funcionarioId}")
	public ResponseEntity<Void> detelar(@PathVariable Long funcionarioId) {				
		if(funcionarioService.deletarPorId(funcionarioId)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //204
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();			
	}
	
	@PutMapping("/{funcionarioId}")
	public ResponseEntity<Funcionario> atualizarCompleta(@PathVariable Long funcionarioId,
			@RequestBody Funcionario funcionarioRequest) {
		
		if(!funcionarioService.existeFuncionario(funcionarioId)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRequest.setId(funcionarioId);
		Funcionario funcionarioAtualizado = funcionarioService.salvar(funcionarioRequest);		
		
		return ResponseEntity.ok(funcionarioAtualizado);
	}	
	
	@PatchMapping("/{funcionarioId}")
	public ResponseEntity<Funcionario> atualizarParcial(@PathVariable Long funcionarioId,
			@RequestBody Map<String, Object> camposAtualizados) {
		
		Funcionario funcionarioAtualizado = funcionarioService.atualizarParcial(funcionarioId, camposAtualizados);
		
		if (funcionarioAtualizado != null) {
			return ResponseEntity.ok(funcionarioAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
