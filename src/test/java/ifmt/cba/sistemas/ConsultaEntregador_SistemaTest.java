package ifmt.cba.sistemas;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ifmt.cba.dto.EntregadorDTO;
import io.restassured.RestAssured;

public class ConsultaEntregador_SistemaTest {

  
    @Test //Refere-se ao Use Storie 23
    @DisplayName("Testa a função do sistemade consulta Entregadores")
    public void testConsultaEntregadores(){

      EntregadorDTO entregadorDTO = new EntregadorDTO();
      entregadorDTO.setNome("Entregador 10");
      entregadorDTO.setCPF("111.111.222-11");
      entregadorDTO.setRG("55555-5");
      entregadorDTO.setTelefone("65.99999-99999");
      
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
          .body("codigo",Matchers.is(Matchers.notNullValue()));








      RestAssured
        .given()
        .when()
          .get("http://localhost:8080/entregador/nome/entregador")
       .then()
          .statusCode(200)
          
          //.body("codigo", Matchers.is(4))
          //.body("nome", Matchers.is("Entregador 10"))
          //.body("CPF", Matchers.is("234.432.477-12"))
          //.body("RG", Matchers.is("456859-1"))
          //.body("telefone", Matchers.is("65 99999-7200"));
    }
    
}

