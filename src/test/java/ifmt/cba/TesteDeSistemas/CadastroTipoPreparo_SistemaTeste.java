package ifmt.cba.TesteDeSistemas;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ifmt.cba.dto.TipoPreparoDTO;
import io.restassured.RestAssured;

public class CadastroTipoPreparo_SistemaTeste {

    @Test
    @DisplayName("Teste a inclusão do TipoPreparo referente ao teste de sistema - Use Storie nº. 03")
    public void testInclusaoProduto() {
        TipoPreparoDTO tipoPreparoDTO = new TipoPreparoDTO();
        tipoPreparoDTO.setDescricao("Deixar assando por 66 minutos");
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
                .body("codigo", Matchers.is(Matchers.notNullValue()))
                .body("descricao", Matchers.is(Matchers.notNullValue())); 
    }
}
