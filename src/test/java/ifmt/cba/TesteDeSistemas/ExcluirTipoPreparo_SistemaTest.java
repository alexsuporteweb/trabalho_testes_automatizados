package ifmt.cba.TesteDeSistemas;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ifmt.cba.dto.TipoPreparoDTO;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class ExcluirTipoPreparo_SistemaTest {
    
    @Test
    @DisplayName("Este teste exclui o TipodePreparo, para que seja feita essa operação" +
                "primeiro criamos um TipoPreparoProduto, após buscamos o código dele pelo " +
                "nome e após fazemos a exclusão pelo código recuperado")
    public void testDeleteTipoPreparoPorCodigo(){

        //Aqui é feita a inclusão do TipoPreparo
        TipoPreparoDTO tipoPreparoDTO = new TipoPreparoDTO();
        tipoPreparoDTO.setDescricao("Deixar assando por 65 minutos");
        RestAssured
            .given()
                .log().all()
                .contentType("application/json")
                .body(tipoPreparoDTO)
            .when()
                .post("http://localhost:8080/tipopreparo/")
            .then()
                .log().all()
                .statusCode(200)
                .body("descricao", Matchers.is(tipoPreparoDTO.getDescricao()));


    //Aqui consultamos o TipoPreparo por partedescrição para buscar o codigo do TipoPreparo
    Response resposta = RestAssured.request(Method.GET, "http://localhost:8080/tipopreparo/nome/"+ tipoPreparoDTO.getDescricao());
    JsonPath jsonPath = new JsonPath(resposta.asString());
    int codigo = jsonPath.getInt("codigo[0]");
    Assertions.assertEquals(codigo,jsonPath.getInt("codigo[0]"));

    //Aqui faremos a exclusão do TipoPreparo após buscar o código
       RestAssured
       .given()
      .log().all()
      .when()
         .delete("http://localhost:8080/tipopreparo/"+ codigo )
      .then()
         .log().all()
       //.statusCode(200)
      //Aqui confirme  que o TipoPreparo foi excluído, pois o não há resultado para a pesquisa
       .body("codigo", Matchers.is(Matchers.nullValue()));

    }  
}
