package com.estudos.testes.unitarios;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EstudosTestesUnitariosApplicationTestsIT {

/**	
 * @Autowired
	PessoaService pessoaService;
	
	@Test 
	public void testarCadastroPessoaComSucesso() {
		//CenárioS
		PessoaEntity pessoa = new PessoaEntity();
		
		pessoa.setCep("32220000");
		pessoa.setCpf("38587312260");
		pessoa.setNome("Dona Lourdes");
		pessoa.setNumero("153");
		pessoa.setRua("Padre");
		pessoa.setSobreNome("Almeida");
		
		//Ação
		 pessoa = pessoaService.salvar(pessoa);	
		 
		//Validação
		assertThat(pessoa).isNotNull();
		assertThat(pessoa.getId()).isNotNull();
		assertThat(pessoaService).isNotNull();		
	}	

	@Test(expected = ConstraintViolationException.class)
	public void testarCadastroPessoaSemNome() {
		PessoaEntity pessoa = new PessoaEntity();
		
		pessoa.setCep("32220000");
		pessoa.setCpf("38587312260");
		pessoa.setNumero("153");
		pessoa.setRua("Padre");
		pessoa.setSobreNome("Almeida");

		pessoa = pessoaService.salvar(pessoa);	
	}
*/	
}
