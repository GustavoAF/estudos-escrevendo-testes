package com.estudos.testes.unitarios.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.testes.unitarios.domain.entity.PessoaEntity;
import com.estudos.testes.unitarios.domain.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public List<PessoaEntity> listar(){
		
		return (List<PessoaEntity>) pessoaRepository.findAll();
	}
	
	public PessoaEntity salvar (PessoaEntity pessoaEntity) {
		
		return pessoaRepository.save(pessoaEntity);
	}
	
	public Optional<PessoaEntity> buscaPorId(Long idPessoa) {
		
		return pessoaRepository.findById(idPessoa);
	}
	
	

}
