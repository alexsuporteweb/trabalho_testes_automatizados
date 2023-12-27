package ifmt.cba.TesteDeSistemas;

import java.util.Locale;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import ifmt.cba.dto.ClienteDTO;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AlteracaoCliente_SistemaTest {

    @Test
    @DisplayName("Teste a alteração de dados do cliente" +
                " Para realizar este teste, criamos um cliente, fazemos a busca "+
                "e após buscar seu código, é feita a alteração" +
                "referente a User Story nº 05")
    public void alterarDadosCliente(){
    Faker faker = new Faker(Locale.forLanguageTag("pt-br"));
    FakeValuesService fakevalues = new FakeValuesService(Locale.getDefault(), new RandomService());
    
    //Cadastrando o Cliente
    ClienteDTO clienteDTO = new ClienteDTO();
    clienteDTO.setNome(faker.name().fullName());
    clienteDTO.setCPF(fakevalues.bothify("###.###.###-##"));
    clienteDTO.setRG(fakevalues.bothify("#######-#"));
    clienteDTO.setLogradouro(faker.address().streetName());
    clienteDTO.setNumero(faker.number().digits(3));
    clienteDTO.setBairro("Bairro do(a) " +faker.name().firstName());
    clienteDTO.setTelefone(fakevalues.bothify("(##)9####-####"));
    clienteDTO.setPontoReferencia("Próximo ao Bar da(a) " + faker.name().fullName());
    RestAssured
    .given()
        .log().all()
        .contentType("application/json")
        .body(clienteDTO)
    .when()
        .post("http://localhost:8080/cliente")
        .then()
        .log().all()
        .statusCode(200);

    //Buscando o codigo do cliente através de seu nome
     Response resposta = RestAssured.request(Method.GET, "http://localhost:8080/cliente/nome/" + clienteDTO.getNome());
     JsonPath jsonPath = new JsonPath(resposta.asString());
     int codigo = jsonPath.getInt("codigo[0]");
     

    
     //Alterarando o endereço do cliente
     Response response = RestAssured.request(Method.GET, "http://localhost:8080/cliente/codigo/" + codigo);
     Assertions.assertEquals(200, response.getStatusCode());
     ClienteDTO cltDTO = response.getBody().as(ClienteDTO.class);
     cltDTO.setCodigo(codigo);
     cltDTO.setLogradouro(faker.address().streetName());
     cltDTO.setTelefone(fakevalues.bothify("(##)9####-####"));

     RestAssured
        .given()
            .log().all()
            .contentType("application/json")
            .body(cltDTO)
        .when()
            .put("http://localhost:8080/cliente/")
        .then()
            .log().all()
            .statusCode(200)
            .body("codigo", Matchers.is(Matchers.notNullValue()))
            .body("logradouro", Matchers.is(cltDTO.getLogradouro()))
            .body("telefone", Matchers.is(cltDTO.getTelefone()));
 
   }
}
