package com.estudos.testes.unitarios.testeapi;

import org.flywaydb.core.Flyway;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TesteApiHttpStatusPessoa {
	
	@Autowired
	private Flyway flyway;
	

	@LocalServerPort
	private int port;
	
	/*
	 * Esta anotação serve para informar que antes dos testes, esse método deve ser executado.
	 * Isso facilita caso seja necessário qualquer configuração como porta e controladores.
	 */
	@Before
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/api/estudos-testes/v1/pessoas";
		
		flyway.migrate();  // Este comando faz com que a rotina da biblioteca flywaydb seja executada, garantindo assim que os testes
						   // não precisem ser executados numa determinada ordem.
	}
	
	/*
	 * Método usado para chamadas de teste de API, com ela é possível testar as chamadas do método HTTP 
	 * Necessário incluit a biblioteca Assured no poom
	 */
	@Test
	public void testarLocalizarPessoaStatus200() {
				
		RestAssured.given()
			.accept(ContentType.JSON)
		.when()
			.get() //tipo da requisição que queremos que ele faço
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	/*
	 * Método usado para chamadas de teste de API, com ela é possível testar as chamadas do método HTTP 
	 * Necessário incluit a biblioteca Assured no poom
	 */
	@Test
	public void deveConterDuasPessoas() {
				
		RestAssured.given()
			.accept(ContentType.JSON)
		.when()
			.get() //tipo da requisição que queremos que ele faço
		.then()
			.body("", Matchers.hasSize(2)); // biblioteca para escrever expressões com regras de correspondência este retorna a quantidade de registros do response
			//.body("name", Matchers.hasItems("Jojo","Maluzinha"));  // este compara com exatamente os intens retornados informando os campos e seus valores
	}
	
	/*
	 * Método de teste semelhante ao get, mas no caso verifica se o retorno é um 201 created
	 */
	@Test
	public void deveRetornar201() {
				
		RestAssured.given()
			.body("{ \"nome\": \"Gustavo\" }")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post() //tipo da requisição que queremos que ele faço
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	/*
	 * Teste criado para exemplificar uma consulta uzando @PathViriable
	 */
	@Test
	public void deveConterUmaPessoa() {
				
		RestAssured.given()
			.pathParam("pessoaId", 7)
			.accept(ContentType.JSON)
		.when()
			.get("/{pessoaId}") //tipo da requisição que queremos que ele faço
		.then()
			.statusCode(HttpStatus.OK.value());
			//.body("name", Matchers.hasItems("Jojo","Maluzinha"));  // este compara com exatamente os intens retornados informando os campos e seus valores
	}
}
