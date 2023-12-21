package ifmt.cba.negocio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import ifmt.cba.dto.EntregadorDTO;
import ifmt.cba.persistencia.EntregadorDAO;
import ifmt.cba.persistencia.FabricaEntityManager;

public class EntregadorNegocio_EntregadorDAO_IntegracaoTest {
    
@Test
public void inserirEntregador(){

    EntregadorDAO entregadorDAO = Assertions.assertDoesNotThrow(
        ()-> new EntregadorDAO(FabricaEntityManager.getEntityManagerTeste()));
    EntregadorNegocio entregadorNegocio = Assertions.assertDoesNotThrow(
        ()-> new EntregadorNegocio(entregadorDAO));
    EntregadorDTO entregadorDTO = new EntregadorDTO();
    entregadorDTO.setNome("Entregador de Tal");
    entregadorDTO.setRG("55464-6");
    entregadorDTO.setCPF("12345678901");
    entregadorDTO.setTelefone("65.99999-5555");
    Assertions.assertDoesNotThrow(
        ()-> entregadorNegocio.inserir(entregadorDTO));
     List<EntregadorDTO> lista = Assertions.assertDoesNotThrow(
        ()-> entregadorNegocio.pesquisaParteNome("Entregador de tal"));
    Assertions.assertFalse(lista.isEmpty());
    }

@Test
public void listarPorParteDeNome(){

    EntregadorDAO entregadorDAO = Assertions.assertDoesNotThrow(
        ()-> new EntregadorDAO(FabricaEntityManager.getEntityManagerTeste()));
    EntregadorNegocio entregadorNegocio = Assertions.assertDoesNotThrow(
        ()-> new EntregadorNegocio(entregadorDAO));
    EntregadorDTO entregadorDTO = new EntregadorDTO(); //criar um entregador
    entregadorDTO.setNome("Entregador de Tal");
    entregadorDTO.setRG("55464-6");
    entregadorDTO.setCPF("12345678901");
    entregadorDTO.setTelefone("65.99999-5555");
    Assertions.assertDoesNotThrow(
        ()-> entregadorNegocio.inserir(entregadorDTO));
    List<EntregadorDTO> lista = Assertions.assertDoesNotThrow(
        ()-> entregadorNegocio.pesquisaParteNome("Entrega")); //passa parte do nome
    Assertions.assertFalse(lista.isEmpty());   
       
    }

@Test
public void exclusaoEntregador(){

    EntregadorDAO entregadorDAO = Assertions.assertDoesNotThrow(
        ()-> new EntregadorDAO(FabricaEntityManager.getEntityManagerTeste()));
    EntregadorNegocio entregadorNegocio = Assertions.assertDoesNotThrow(
        ()-> new EntregadorNegocio(entregadorDAO));
    EntregadorDTO entregadorDTO = new EntregadorDTO();
    entregadorDTO.setNome("Entregador de Tal");
    entregadorDTO.setRG("55464-6");
    entregadorDTO.setCPF("12345678901");
    entregadorDTO.setTelefone("65.99999-5555");
    Assertions.assertDoesNotThrow(
        ()-> entregadorNegocio.inserir(entregadorDTO));
    Assertions.assertDoesNotThrow(
        ()-> entregadorNegocio.excluir(1)); 
    List<EntregadorDTO> lista = Assertions.assertDoesNotThrow(
        ()-> entregadorNegocio.pesquisaParteNome("Entrega")); //passa parte do nome
    Assertions.assertTrue(lista.isEmpty()); 
 
}
}