package ifmt.cba.TesteDePerformace;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Locale;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import ifmt.cba.dto.ClienteDTO;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class AlteracaoDadosDeCliente_PerformaceTest {
    
    Faker faker = new Faker(Locale.forLanguageTag("pt-br"));
    FakeValuesService fakevalues = new FakeValuesService(Locale.getDefault(), new RandomService());
    
    @Test
    @DisplayName("Testa a alteração de dados do cliente com massa de dados de 500000 cliente" +
                  "O clinte é escolhido aleatoriamente na geração de codigo valido")
    public void alteradoDadosDeClientePerformace(){
     int codigo = faker.number().numberBetween(1, 213);
     Response response = RestAssured.request(Method.GET, "http://localhost:8080/cliente/codigo/" + codigo);
     Assertions.assertEquals(200, response.getStatusCode());
     ClienteDTO cltDTO = response.getBody().as(ClienteDTO.class);
     cltDTO.setCodigo(codigo);
     cltDTO.setLogradouro(faker.address().streetName());
     cltDTO.setTelefone(fakevalues.bothify("(##)9####-####"));
    
     assertTimeout(Duration.ofMillis(200), () -> {
     RestAssured
        .given()
            .log().all()
            .contentType("application/json")
            .body(cltDTO)
        .when()
            .put("http://localhost:8080/cliente/")
        .then()
            .log().all()
            .statusCode(200)
            .body("codigo", Matchers.is(Matchers.notNullValue()))
            .body("logradouro", Matchers.is(cltDTO.getLogradouro()))
            .body("telefone", Matchers.is(cltDTO.getTelefone()));
     });
 
   }
}
