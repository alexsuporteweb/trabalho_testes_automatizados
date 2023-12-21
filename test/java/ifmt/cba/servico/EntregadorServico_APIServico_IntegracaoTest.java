package ifmt.cba.servico;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ifmt.cba.dto.EntregadorDTO;
import io.restassured.RestAssured;

public class EntregadorServico_APIServico_IntegracaoTest {

    @Test
    @DisplayName("Testa consulta a API de serviço buscar entregador por código")
    public void testeConsultaEntregadorPorCodigo(){
        RestAssured
        .given()
        .when()
            .get("http://localhost:8080/entregador/codigo/4")
        .then();
           
        }
    
    @Test
    @DisplayName("Testa a API de serviço de deletar entregador por codigo")
   public void testeDeletarEntregador(){
        RestAssured
        .given()
        .when()
            .delete("http://localhost:8080/entregador/7")
        .then()
            .statusCode(200);
   }
}
