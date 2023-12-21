package ifmt.cba.negocio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import ifmt.cba.dto.GrupoAlimentarDTO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.GrupoAlimentarDAO;
import ifmt.cba.persistencia.ProdutoDAO;

public class GrupoAlimentarNegocio_GrupoAlimentarDAO_IntegracaoTest {

@Test
public void inserirGrupoAlimentar(){
   // GrupoAlimentarDAO grupoAlimentarDAO = Mockito.mock(GrupoAlimentarDAO.class);
    //ProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);
    GrupoAlimentarDAO grupoAlimentarDAO = Assertions.assertDoesNotThrow(
        ()-> new GrupoAlimentarDAO(FabricaEntityManager.getEntityManagerTeste()));
   
    ProdutoDAO produtoDAO = Assertions.assertDoesNotThrow(
    ()->new ProdutoDAO(FabricaEntityManager.getEntityManagerTeste()));

    GrupoAlimentarNegocio grupoAlimentarNegocio = Assertions.assertDoesNotThrow(
        ()-> new GrupoAlimentarNegocio(grupoAlimentarDAO, produtoDAO));
   
    GrupoAlimentarDTO grupoAlimentarDTO = Mockito.mock(GrupoAlimentarDTO.class);
   //
    Mockito.when(grupoAlimentarDTO.getNome()).thenReturn("Proteina");
   
    System.out.println(grupoAlimentarDTO.getNome());

    Assertions.assertDoesNotThrow(
        ()-> grupoAlimentarNegocio.inserir(grupoAlimentarDTO));
    List<GrupoAlimentarDTO> lista = Assertions.assertDoesNotThrow(
        ()->grupoAlimentarNegocio.pesquisaParteNome("Prot"));
        System.out.println(lista);
    Assertions.assertFalse(lista.isEmpty());
 
} 
    
@Test
public void testeDeGrupoAlimentarNaoEncontrado(){

    GrupoAlimentarDAO grupoAlimentarDAO = Assertions.assertDoesNotThrow(
        ()-> new GrupoAlimentarDAO(FabricaEntityManager.getEntityManagerTeste()));
    ProdutoDAO produtoDAO = Assertions.assertDoesNotThrow(
        ()->new ProdutoDAO(FabricaEntityManager.getEntityManagerTeste()));
    GrupoAlimentarNegocio grupoAlimentarNegocio = Assertions.assertDoesNotThrow(
        ()-> new GrupoAlimentarNegocio(grupoAlimentarDAO, produtoDAO));
          
    GrupoAlimentarDTO grupoAlimentarDTO = Mockito.mock(GrupoAlimentarDTO.class);
    Mockito.when(grupoAlimentarDTO.getNome()).thenReturn("Cereal");

    List<GrupoAlimentarDTO> lista = Assertions.assertDoesNotThrow(
    ()-> grupoAlimentarNegocio.pesquisaParteNome("Prot"));
        Assertions.assertTrue(lista.isEmpty());
}

@Test
public void exclusaoGrupoAlimentar(){
    GrupoAlimentarDAO grupoAlimentarDAO = Assertions.assertDoesNotThrow(
        ()-> new GrupoAlimentarDAO(FabricaEntityManager.getEntityManagerTeste()));
    ProdutoDAO produtoDAO = Assertions.assertDoesNotThrow(
        ()->new ProdutoDAO(FabricaEntityManager.getEntityManagerTeste()));
    GrupoAlimentarNegocio grupoAlimentarNegocio = Assertions.assertDoesNotThrow(
        ()-> new GrupoAlimentarNegocio(grupoAlimentarDAO, produtoDAO));
    GrupoAlimentarDTO grupoAlimentarDTO = new GrupoAlimentarDTO();
    
    grupoAlimentarDTO.setNome("Teste de Integração ...");
    Assertions.assertDoesNotThrow(
        ()-> grupoAlimentarNegocio.inserir(grupoAlimentarDTO));
    Assertions.assertDoesNotThrow(
        ()-> grupoAlimentarNegocio.excluir(1));
    List<GrupoAlimentarDTO> lista = Assertions.assertDoesNotThrow(
        ()-> grupoAlimentarNegocio.pesquisaParteNome("Teste de Integração ..."));
        Assertions.assertTrue(lista.isEmpty()); 
    }
}
