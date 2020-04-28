package com.estudos.testes.unitarios.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estudos.testes.unitarios.domain.entity.PessoaEntity;
import com.estudos.testes.unitarios.domain.service.PessoaService;

/*
 * Este projeto exemplo faz uso da biblioteca Flyway.
 * Essa bibliotera deve ser informada no arquivo poom.xml, e sua funcionalidade se baseia em controlar as versões do banco de dados.
 * Nada nos impede que para desenvolvimento e protótipos usemos o arquivo import.sql para inserir os dados e as propriedades
 * spring.jpa.generate-ddl=true e spring.jpa.hibernate.ddl-auto=create para gerar o banco, mas em se tratando de produção e complexidade
 * é altamente recomendável que se use essa ferramenta por se tratar de uma maneira robusta e profissional de tratar a problema.
 * 
 * Para utilizar esta funcionalidade execute os passos abaixo:
 * 1 - Insira a dependencia no arquivo poom.xml
 * 2 - crie uma pasta chamada db dentro de src/main/resources
 * 3 - dentro da pasta db crie outra pasta chamada migration
 * 4 - dentro dessa pasta crie um arquivo com seu nome da seguinte nomenclatura V001__descricao (onde V deve ser maiusculo seguido do numero seguido
 *     de dois anderlines e uma breve descricao). Dentro desse arquivo insira o DDL referente as tabelas do seu sistema.
 * 5 - Após criar as tabelas é preciso popula-las, para isso crie uma pasta dentro de db chamada testdata, essa pasta será um processo para
 *     testes e desenvolvimento. Não é uma boa prática colocar os inserts junto com o ddl, mas o flyway tem uma funcionalidade onde após executar
 *     o migrate, ele executa um processo chamado After Migrate, buscando arquivos com o nome padrão afterMigrate.sql. Dentro dele insera os inserts necessarios.
 * 6 - Precisamos informar a biblioteca o diretório que se encontram os arquivos, uma vez que o ddl esta na pasga pdrão mas o after migrate nao.
 *     Para isso  vá no arquivo application.properties e insira a propriedade spring.flyway.location, informando o diretório que estão os arquivos, 
 *     ficando da seguinte maneira, spring.flyway.location=classpath:db/migration,classpath:db/testdata.
 *     
 * Também é possivel criar mais de uma rotina migration podendo ser possível ter uma base de dados exclusiva para os testes. 
 * Para isso basta cnofigurar um application.properties reservado para os testes, e inserir a propriedade @TestPropertySource na classe que deseja
 * fazer o teste, ficando como o seguinte exemplo @TestPropertySource("/application-test.properties")
 * 
 */

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
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(pessoaEntity));
	}
	
	@GetMapping("/{pessoaId}")
	public ResponseEntity<Optional<PessoaEntity>> buscaPorId(@PathVariable Long pessoaId){
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscaPorId(pessoaId));
	}
}
