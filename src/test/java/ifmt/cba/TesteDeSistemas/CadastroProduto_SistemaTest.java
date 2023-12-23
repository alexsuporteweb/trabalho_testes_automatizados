package ifmt.cba.TesteDeSistemas;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ifmt.cba.dto.GrupoAlimentarDTO;
import ifmt.cba.dto.ProdutoDTO;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import com.google.gson.Gson;

public class CadastroProduto_SistemaTest {
   
    @Test // Teste da Use Store nº 01
    @DisplayName("Teste a inclusão do Produto referente ao teste de sistema - Use Storie 01")
    public void testInclusaoProduto() {
        
        Response Response = RestAssured.request(Method.GET, "http://localhost:8080/grupoalimentar/codigo/3");
        Assertions.assertEquals(200, Response.getStatusCode());
        
        Gson gson = new Gson();
        GrupoAlimentarDTO grupoAlimentarDTO = gson.fromJson(Response.getBody().asString(), GrupoAlimentarDTO.class);
        // Aqui é cadastrado um produto
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Carne de Porco Assada 07");
        produtoDTO.setCustoUnidade(20);
        produtoDTO.setEstoque(30);
        produtoDTO.setEstoqueMinimo(500);
        produtoDTO.setValorEnergetico(100);
        produtoDTO.setGrupoAlimentar(grupoAlimentarDTO);

        RestAssured
            .given()
                .log().all()
                .contentType("application/json")
                .body(produtoDTO)
            .when()
                .post("http://localhost:8080/produto/")
            .then()
                .log().all()
                .statusCode(200) //Aqui confirma a inclusão do produto
                //Aqui é confirmado alguns dados enviados do novo produto
                .body("nome[0]", Matchers.is(produtoDTO.getNome()))
                .body("estoque[0]", Matchers.is(produtoDTO.getEstoque()));
              
    }
}
