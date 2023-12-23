package ifmt.cba.ArquiivosDeTestes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Testando {

    @Test
    public void testandorecuperacao(){
     Response resposta = RestAssured.request(Method.GET, "http://localhost:8080/entregador/nome/Entregador 02");

     JsonPath jsonPath = new JsonPath(resposta.asString());
     int cod = jsonPath.getInt("codigo[0]");

    Assertions.assertEquals(4, cod);

        //Assertions.assertEquals(cod, jsonPath.getString("nome"));
    }
    
}
