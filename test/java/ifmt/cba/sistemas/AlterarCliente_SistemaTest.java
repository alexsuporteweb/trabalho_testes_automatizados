package ifmt.cba.sistemas;

import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import ifmt.cba.dto.ClienteDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AlterarCliente_SistemaTest {

    /**
     * 
     */
    @Test
    public void alterarClientePorCodigo(){

         ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setCodigo(3);
            clienteDTO.setNome("Cliente Alterado");
            clienteDTO.setCPF("111.111.111-11");
            clienteDTO.setRG("65464-8");
            clienteDTO.setTelefone("65 92587-0241");
            clienteDTO.setLogradouro("Rua das Flores");
            clienteDTO.setNumero("25");
            clienteDTO.setPontoReferencia("bar");
            clienteDTO.setBairro("Três Barras");

      RestAssured
      .given()
      
      .contentType(ContentType.JSON)
      //.body("{\"codigo\" : 2, \"nome\": \"Cliente alterado\"}")
      .body(clienteDTO)
      .when()
      .put("http://localhost:8080/cliente/")
      .then()
      .log() .all()
      .statusCode(200)
      .body("nome", Matchers.is("Cliente Alterado"));

      


        
    }

    
}
