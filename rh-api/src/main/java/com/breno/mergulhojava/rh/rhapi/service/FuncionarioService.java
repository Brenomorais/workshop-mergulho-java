package com.breno.mergulhojava.rh.rhapi.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breno.mergulhojava.rh.rhapi.model.Funcionario;
import com.breno.mergulhojava.rh.rhapi.repository.FuncionarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario salvar(Funcionario funcionario) {
		log.info("Salvando funcionario.");

		return funcionarioRepository.save(funcionario);		
	}

	public List<Funcionario> bucarTodosFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	public Optional<Funcionario> buscarFuncionarioPorId(Long funcionarioId) {		
		return  funcionarioRepository.findById(funcionarioId);		
	}

	public boolean deletarPorId(Long funcionarioId) {
		Optional<Funcionario> funcioanrioOptional = buscarFuncionarioPorId(funcionarioId);
		boolean ret = funcioanrioOptional.isPresent();
		if(ret) {
			Funcionario funcionario = funcioanrioOptional.get();
			funcionarioRepository.delete(funcionario);			
		}
		return ret;
	}
	
	public boolean existeFuncionario(Long funcionarioId) {
		return funcionarioRepository.existsById(funcionarioId);
	}
	
	
	public Funcionario atualizarParcial(Long id, Map<String, Object> camposAtualizados) throws IllegalArgumentException {
		Optional<Funcionario> contaOptioanl = funcionarioRepository.findById(id);
		
		if(!contaOptioanl.isPresent()) {
			 throw new IllegalArgumentException("Funcionario não encontrada.");
		}
		
		Funcionario contaExistente = contaOptioanl.get();
		
        ObjectMapper objectMapper = new ObjectMapper();
        //atualiza o reader com a instancia da contaExistente
        ObjectReader reader = objectMapper.readerForUpdating(contaExistente);
        
        Funcionario contaAtualizado = new Funcionario();
		try {
			//atualiza instancia do objeto existe com a instacia do objeto atualizado
			contaAtualizado = reader.readValue(objectMapper.writeValueAsString(camposAtualizados));
		} catch (JsonProcessingException e) {
			log.error("Erro na atualizacao parcial: ", e.getMessage());
			throw new IllegalArgumentException("Falha na atualização");			
		}        
        return funcionarioRepository.save(contaAtualizado);		
	}


}
