package com.estudos.testes.unitarios.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
@Entity
@Table(name = "Pessoa")
public class PessoaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotNull
	@Column(name = "nome")
	String nome;
	
	@Column(name = "sobrenome")
	String sobreNome;
	
	@Column(name = "rua")
	String rua;
	
	@Column(name = "numero")
	String numero;
	
	@Column(name = "cep")
	String cep;
	
	@Column(name = "cpf")
	String cpf;

}
