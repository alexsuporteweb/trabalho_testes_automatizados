package ifmt.cba.TesteDeIntegracao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class Cliente_EntregadorServico_IntegracaoTest {

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
    @Test
    public void testeConsultarBuscarEntregadorPorCodigo() {
        Response response = RestAssured.request(Method.GET, "http://localhost:8080/entregador/codigo/20");
        Assertions.assertEquals(200, response.getStatusCode());
    }

   @Test
    public void testeConsultarBuscarEntregadorPorNome() {
        Response response = RestAssured.request(Method.GET, "http://localhost:8080/entregador/nome/entregador");
        Assertions.assertEquals(200, response.getStatusCode());

    }
    @Test
    public void testeDeletarEntregadorCodigo() {
        Response response = RestAssured.request(Method.DELETE, "http://localhost:8080/entregador/2");
        Assertions.assertEquals(200, response.getStatusCode());

    }  
}
