package ifmt.cba.negocio;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.dto.GrupoAlimentarDTO;
import ifmt.cba.entity.GrupoAlimentar;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.GrupoAlimentarDAO;
import ifmt.cba.persistencia.ProdutoDAO;

public class Nao_Usar_GrupoAlimentarNegocioTest {

 @Test
 public void validarOperacaoInclusaoSemMockDAO1 () {

    GrupoAlimentarDAO grupoAlimentarDAO ;
    ProdutoDAO produtoDAO ;
    GrupoAlimentarNegocio grupoAlimentarNegocio ;

    grupoAlimentarDAO = Assertions.assertDoesNotThrow (() -> new GrupoAlimentarDAO (FabricaEntityManager.getEntityManagerProducao ()));
    produtoDAO = Assertions.assertDoesNotThrow (() -> new ProdutoDAO (FabricaEntityManager.getEntityManagerProducao ()));

    grupoAlimentarNegocio = Assertions.assertDoesNotThrow (() -> new GrupoAlimentarNegocio (grupoAlimentarDAO , produtoDAO)) ;

    GrupoAlimentarDTO grupoDTO = new GrupoAlimentarDTO () ;
    grupoDTO.setNome(" Teste de Inclusao ") ; // GrupoAlimentar valido , vai ate o banco

    Assertions.assertDoesNotThrow (() -> grupoAlimentarNegocio.inserir(grupoDTO)) ;
}

@Test
public void validarOperacaoInclusaoSemMockDAO2() {

    GrupoAlimentarDAO grupoAlimentarDAO ;
    ProdutoDAO produtoDAO ;
    GrupoAlimentarNegocio grupoAlimentarNegocio;

    grupoAlimentarDAO = Assertions.assertDoesNotThrow (() -> new GrupoAlimentarDAO (FabricaEntityManager.getEntityManagerProducao()));
    produtoDAO = Assertions.assertDoesNotThrow (() -> new ProdutoDAO (FabricaEntityManager.getEntityManagerProducao()));

    grupoAlimentarNegocio = Assertions.assertDoesNotThrow (() -> new GrupoAlimentarNegocio (grupoAlimentarDAO , produtoDAO)) ;

    GrupoAlimentarDTO grupoDTO = new GrupoAlimentarDTO () ;
    grupoDTO.setNome ("Te") ; // Grupo alimemtarinvalido , para na regra de negocio e nao chega no banco

    // recebe uma excecao de validcao , nao inclui
    Assertions.assertThrows (NegocioException.class, ()-> grupoAlimentarNegocio.inserir (grupoDTO));
}

    @Test
    public void validarOperacaoInclusaoComMockDAO1() {

    GrupoAlimentarDAO grupoAlimentarDAO ;
    ProdutoDAO produtoDAO ;
    GrupoAlimentarNegocio grupoAlimentarNegocio;

    // GrupoAlimentar valido , mas nao chega no banco pois DAO foi mockado
    GrupoAlimentarDTO grupoDTO = new GrupoAlimentarDTO () ;
    grupoDTO.setNome(" Teste de Inclusao 2 ");

    grupoAlimentarDAO = Mockito.mock(GrupoAlimentarDAO.class) ; // mocka do DAO
    produtoDAO = Mockito.mock(ProdutoDAO.class) ; // mocka do DAO

    // Mockito.when(grupoAlimentarDAO.incluir(grupo)).thenReturn(void); // nao mocka metodo void

    Assertions.assertDoesNotThrow(() -> Mockito.when (grupoAlimentarDAO.buscarPorParteNome(grupoDTO.getNome ()))
    .thenReturn(new ArrayList <GrupoAlimentar > ()));

    grupoAlimentarNegocio = Assertions.assertDoesNotThrow (() -> new GrupoAlimentarNegocio (grupoAlimentarDAO , produtoDAO)) ;

    Assertions.assertDoesNotThrow (() -> grupoAlimentarNegocio.inserir (grupoDTO));

    // verifica se o metodo void foi chamado uma vez
    Assertions.assertDoesNotThrow (() ->Mockito.verify (grupoAlimentarDAO).incluir(new GrupoAlimentar ()));
    }

    @Test
    public void validarOperacaoInclusaoComMockDAO2() {

    GrupoAlimentarDAO grupoAlimentarDAO ;
    ProdutoDAO produtoDAO ;
    GrupoAlimentarNegocio grupoAlimentarNegocio;

    // GrupoAlimentar invalido, nao chega a invocar o metodo incluir do DAO
    GrupoAlimentarDTO grupoDTO = new GrupoAlimentarDTO () ;
    grupoDTO.setNome("Te") ;

    grupoAlimentarDAO = Mockito.mock(GrupoAlimentarDAO.class) ; // mocka do DAO
    produtoDAO = Mockito.mock(ProdutoDAO.class) ; // mocka do DAO

    // Mockito.when(grupoAlimentarDAO.incluir(grupo)).thenReturn (void) ; // nao mocka metodo void

    Assertions.assertDoesNotThrow (() -> Mockito.when (grupoAlimentarDAO.buscarPorParteNome (grupoDTO.getNome ())).thenReturn (new ArrayList <GrupoAlimentar > ()));

    grupoAlimentarNegocio = Assertions.assertDoesNotThrow (() -> new GrupoAlimentarNegocio (grupoAlimentarDAO , produtoDAO)) ;

    // espera uma excecao de validacao dos dados
    Assertions.assertThrows (NegocioException.class , () -> grupoAlimentarNegocio.inserir (grupoDTO)) ;

    // verifica se o metodo void NAO foi chamado
    Assertions.assertDoesNotThrow (() ->Mockito.verify (grupoAlimentarDAO , Mockito.never ()).incluir(new GrupoAlimentar ()));
    }

}
