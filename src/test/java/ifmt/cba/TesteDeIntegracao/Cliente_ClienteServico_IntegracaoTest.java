package ifmt.cba.TesteDeIntegracao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class Cliente_ClienteServico_IntegracaoTest {

    @Test
    @DisplayName("Testa consulta a API de serviço buscar cliente por código")
    public void testeConsultaClientePorCodigo(){
        RestAssured
        .given()
        .when()
            .get("http://localhost:8080/cliente/codigo/1")
        .then()
        .statusCode(200);   
        }

    @Test
    @DisplayName("Testa a API de serviço de deletar cliente por codigo")
   public void testeDeletarClientePorCodigo(){
        RestAssured
        .given()
        .when()
            .delete("http://localhost:8080/cliente/14")
        .then()
            .statusCode(200);
   }
    
}
