package ifmt.cba.TesteDeSistemas;

import java.util.Locale;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ifmt.cba.dto.EntregadorDTO;
import io.restassured.RestAssured;

public class CadastroEntregador_SistemaTest {
 
    Faker faker = new Faker(Locale.forLanguageTag("pt-br"));
    FakeValuesService fakevalues = new  FakeValuesService(Locale.getDefault(), new RandomService());
  
    @Test //Refere-se ao Use Storie 23
    @DisplayName("Testa a função do sistema de Cadastro de Entregadores - Use Storie 23")
    public void testCadastroEntregadores(){

      //Aqui faço o cadastro do entregador
      EntregadorDTO entregadorDTO = new EntregadorDTO();
      entregadorDTO.setNome(faker.name().fullName());
      entregadorDTO.setCPF(fakevalues.bothify("###.###.###-##"));
      entregadorDTO.setRG(fakevalues.bothify("#######-#"));;
      entregadorDTO.setTelefone(fakevalues.bothify("(##)9####-####"));;
      
      RestAssured
        .given()
          .log().all()
          .contentType("application/json")
          .body(entregadorDTO)
        .when()
          .post("http://localhost:8080/entregador/")
        .then()
          .log().all()
          .statusCode(200) // Aqui confirma a execução da função
            //Aqui é feito a confirmação da inclusão fazendo a comparação dos valores repassados.
           .body("nome[0]", Matchers.is(entregadorDTO.getNome()))
           .body("CPF[0]", Matchers.is(entregadorDTO.getCPF()))
           .body("RG[0]", Matchers.is(entregadorDTO.getRG()))
           .body("telefone[0]", Matchers.is(entregadorDTO.getTelefone()));

          }
}
