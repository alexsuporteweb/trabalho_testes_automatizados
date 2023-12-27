package ifmt.cba.ArquiivosDeTestes;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ifmt.cba.persistencia.PersistenciaException;
import io.restassured.RestAssured;

public class ConsultaEntregador_SistemaTest {

    String entregador="Entregador 5";
  
    @Test //Refere-se ao Use Storie 23
    @DisplayName("Testa a função do sistemade consulta Entregadores")
    public void testConsultaEntregadores() throws PersistenciaException{




      RestAssured
        .given()
        .when()
          //.get("http://localhost:8080/entregador/nome/"+entregador)
          .get("http://localhost:8080/entregador/nome/Entregador 5")
       .then()
          .statusCode(200)
          
          .body("codigo[0]", Matchers.is(6));
          
         // .body("nome", Matchers.is("Entregador 5"))
        //  .body("CPF", Matchers.is("234.432.477-12"))
        //  .body("RG", Matchers.is("456859-1"))
        //  .body("telefone", Matchers.is("65 99999-7200"));
  
  
          
        }
    
}


