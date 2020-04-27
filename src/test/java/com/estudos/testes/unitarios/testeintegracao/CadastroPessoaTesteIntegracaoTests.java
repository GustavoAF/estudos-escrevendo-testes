package com.estudos.testes.unitarios.testeintegracao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.estudos.testes.unitarios.domain.entity.PessoaEntity;
import com.estudos.testes.unitarios.domain.service.PessoaService;

/*
 * Anotações usadas para fornecer o carregamento do contexto do Spring 
 * para que seja possível usar os recuros como Injeção de Dependência.
 * Importante anotar as duas abaixo
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class CadastroPessoaTesteIntegracaoTests {
	/*
	 * testes de integracao nao podem ser executados no build, para evitar que isso aconteça
	 * devemos incluir o plugin Maven Failsafe no poom do projeto, além disso temos que incluir nas classes
	 * de teste de integração, o sufixo IT. Essa é uma convenção necessária para o plugin.
	 * Fazendo isso e executando os testes pelo maven, os testes de integração não seram executados pelo comando
	 * mvn test. Para executar os testes de integração deve-se usar o comando mvn verify.
	 * Outro ponto importante é lembrar que caso essa classe seja executada pelo Maven, o build não será
	 * criado, porque o maven irá não irá validar os testes baixo retornando IllegalState.
	 * Para que seja executado com sucesso, esses meétodos de teste devem ser executados no classe principal do projeto de Test.
	 */
	@Autowired
	PessoaService pessoaService;
	
	@Test //Anotação que indica que esse método é um metódo de Teste. Deve ser usado a anotação da classe org.junit.Test
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
	/*
	 * Propriedade expected usada para avisar o teste que será gerado uma excessão, para isso devemos
	 * informar qual excessão.Desse modo, o teste é realizado com sucesso.
	 */
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
}
