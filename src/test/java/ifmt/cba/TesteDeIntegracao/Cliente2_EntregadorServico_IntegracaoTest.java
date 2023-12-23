package ifmt.cba.TesteDeIntegracao;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;




public class Cliente2_EntregadorServico_IntegracaoTest {

    @Test
    public void testeConsultarBuscarEntregadorPorCodigo() {
        Response response = RestAssured.request(Method.GET, "http://localhost:8080/entregador/codigo/2");
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
    