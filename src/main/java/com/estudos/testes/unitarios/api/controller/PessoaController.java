package com.estudos.testes.unitarios.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estudos.testes.unitarios.domain.entity.PessoaEntity;
import com.estudos.testes.unitarios.domain.service.PessoaService;

@RequestMapping("/pessoas")
@RestController
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<PessoaEntity>> listar(){
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listar());
	}
	
	@PostMapping()
	public ResponseEntity<PessoaEntity> salvar(@Valid @RequestBody PessoaEntity pessoaEntity){
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.salvar(pessoaEntity));
	}
}
