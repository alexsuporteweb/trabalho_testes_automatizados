package ifmt.cba.servico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class ClienteServico_APIServico_IntegracaoTest {

    @Test
    @DisplayName("Testa consulta a API de serviço buscar cliente por código")
    public void testeConsultaClientePorCodigo(){
        RestAssured
        .given()
        .when()
            .get("http://localhost:8080/cliente/codigo/1")
        .then();
           
        }

    @Test
    @DisplayName("Testa a API de serviço de deletar cliente por codigo")
   public void testeDeletarClientePorCodigo(){
        RestAssured
        .given()
        .when()
            .delete("http://localhost:8080/cliente/2")
        .then()
            .statusCode(200);
   }
    
}
