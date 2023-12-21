package ifmt.cba.sistemas;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ifmt.cba.dto.TipoPreparoDTO;
import io.restassured.RestAssured;

public class CadastroTipoPreparo_SistemaTeste {

    @Test // Teste da Use Store nº 03
    @DisplayName("Teste a inclusão do Tipo Preparo referente ao teste de sistema")
    public void testInclusaoProduto() {
              

        TipoPreparoDTO tipoPreparoDTO = new TipoPreparoDTO();
        tipoPreparoDTO.setDescricao("Deixar assando por 25 minutos");

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
                .body("codigo", Matchers.is(Matchers.notNullValue()));
    
    }
}
