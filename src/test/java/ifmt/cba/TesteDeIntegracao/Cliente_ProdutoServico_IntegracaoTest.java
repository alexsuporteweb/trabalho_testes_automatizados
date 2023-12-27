package ifmt.cba.TesteDeIntegracao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class Cliente_ProdutoServico_IntegracaoTest {
   
    
     @Test
    public void testeConsultarBuscarProdutoPorCodigo() {
        Response response = RestAssured.request(Method.GET, "http://localhost:8080/produto/codigo/1");
        Assertions.assertEquals(200, response.getStatusCode());
    }

   @Test
    public void testeConsultarBuscarProdutoPorNome() {
        Response response = RestAssured.request(Method.GET, "http://localhost:8080/produto/nome/batatadoce");
        Assertions.assertEquals(200, response.getStatusCode());

    }
    @Test
    public void testeConsultaEstoqueBaixo() {
        Response response = RestAssured.request(Method.GET, "http://localhost:8080/produto/estoquebaixo");
        Assertions.assertEquals(200, response.getStatusCode());

    } 
}
