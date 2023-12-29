package ifmt.cba.TesteDePerformance;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.util.Locale;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import ifmt.cba.dto.EntregadorDTO;
import io.restassured.RestAssured;

import java.time.Duration;



public class InserirEntregador_PerformanceTest {
    
    Faker faker = new Faker(Locale.forLanguageTag("pt-br"));
    FakeValuesService fakevalues = new  FakeValuesService(Locale.getDefault(), new RandomService());
   
    @Test
    @DisplayName("Teste de tempo para inserir um Entregador com uma base de dados com mais de 500000 entregadores cadastrados")
    public void testCadastroEntregadoresPerformace(){
  
       
        EntregadorDTO entregadorDTO = new EntregadorDTO();
        entregadorDTO.setNome(faker.name().fullName());
        entregadorDTO.setCPF(fakevalues.bothify("###.###.###-##"));
        entregadorDTO.setRG(fakevalues.bothify("#######-#"));;
        entregadorDTO.setTelefone(fakevalues.bothify("(##)9####-####"));;
        
        assertTimeout(Duration.ofMillis(5000), () -> {
        RestAssured
          .given()
            .log().all()
            .contentType("application/json")
            .body(entregadorDTO)
          .when()
            .post("http://localhost:8080/entregador/")
          .then()
            .log().all()
            .statusCode(200)
            .body("codigo[0]", Matchers.is(Matchers.notNullValue())); // Aqui confirma a execução da função
            });
    } 
      
      
    }



