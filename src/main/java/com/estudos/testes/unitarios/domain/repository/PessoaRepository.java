package com.estudos.testes.unitarios.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estudos.testes.unitarios.domain.entity.PessoaEntity;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntity, Long> {

}
