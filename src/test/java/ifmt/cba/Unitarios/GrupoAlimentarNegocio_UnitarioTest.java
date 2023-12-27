package ifmt.cba.Unitarios;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ifmt.cba.dto.GrupoAlimentarDTO;
import ifmt.cba.entity.GrupoAlimentar;
import ifmt.cba.negocio.GrupoAlimentarNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.GrupoAlimentarDAO;
import ifmt.cba.persistencia.ProdutoDAO;

public class GrupoAlimentarNegocio_UnitarioTest {
/**
 * 
 */
@Test
public  void validarOperacaoInclusaoComMockDAO1(){

    GrupoAlimentarDAO grupoAlimentarDAO;
    ProdutoDAO produtoDAO;
    GrupoAlimentarNegocio grupoAlimentarNegocio;

    GrupoAlimentarDTO grupoDTO = new GrupoAlimentarDTO();
    grupoDTO.setNome("Teste de Inclusão");

   
    grupoAlimentarDAO = Mockito.mock(GrupoAlimentarDAO.class);
    produtoDAO = Mockito.mock(ProdutoDAO.class);

    Assertions.assertDoesNotThrow(
        ()-> Mockito.when(grupoAlimentarDAO.buscarPorParteNome(grupoDTO.getNome()))
        .thenReturn(new ArrayList<GrupoAlimentar>()));
    
        grupoAlimentarNegocio = Assertions.assertDoesNotThrow(
        ()-> new GrupoAlimentarNegocio(grupoAlimentarDAO, produtoDAO));   

    Assertions.assertDoesNotThrow(()-> grupoAlimentarNegocio.inserir(grupoDTO));
    Assertions.assertDoesNotThrow(()
    -> Mockito.verify(grupoAlimentarDAO).incluir(new GrupoAlimentar()));
}

@Test
public void validarOperacaoAlterarGrupoAlimentarComMock(){

    GrupoAlimentarDAO grupoAlimentarDAO;
    ProdutoDAO produtoDAO;
    GrupoAlimentarNegocio grupoAlimentarNegocio;
    GrupoAlimentar grupoAlimentar = new GrupoAlimentar();

    grupoAlimentarDAO = Mockito.mock(GrupoAlimentarDAO.class);
    produtoDAO = Mockito.mock(ProdutoDAO.class);

    GrupoAlimentarDTO grupoDTO = new GrupoAlimentarDTO();
    grupoDTO.setNome("Teste de Alteração");
     Assertions.assertDoesNotThrow(
        ()-> Mockito.when(grupoAlimentarDAO.buscarPorCodigo(grupoDTO.getCodigo())).thenReturn(grupoAlimentar));
    grupoAlimentarNegocio = Assertions.assertDoesNotThrow(
        ()-> new GrupoAlimentarNegocio(grupoAlimentarDAO, produtoDAO));
    Assertions.assertDoesNotThrow(()-> grupoAlimentarNegocio.alterar(grupoDTO));
    Assertions.assertDoesNotThrow(()
    -> Mockito.verify(grupoAlimentarDAO).alterar(new GrupoAlimentar()));
    

}

@Test
public void validarOperacaoInclusaoComMockDAO2() {
    
    GrupoAlimentarDAO grupoAlimentarDAO ;
    ProdutoDAO produtoDAO;
    GrupoAlimentarNegocio grupoAlimentarNegocio;
    GrupoAlimentarDTO grupoDTO = new GrupoAlimentarDTO();
    grupoDTO.setNome("Te");
    grupoAlimentarDAO=Mockito.mock(GrupoAlimentarDAO.class);
    produtoDAO=Mockito.mock(ProdutoDAO.class);

    Assertions.assertDoesNotThrow(
        ()->Mockito.when(grupoAlimentarDAO.buscarPorParteNome(grupoDTO.getNome()))
        .thenReturn(new ArrayList<GrupoAlimentar>()));

        grupoAlimentarNegocio = Assertions.assertDoesNotThrow( 
        ()-> new GrupoAlimentarNegocio(grupoAlimentarDAO, produtoDAO));

        Assertions.assertThrows(NegocioException.class, ()-> grupoAlimentarNegocio. inserir(grupoDTO));

        Assertions.assertDoesNotThrow(
        ()->Mockito.verify(grupoAlimentarDAO, Mockito.never()). incluir(new GrupoAlimentar()));



}
}
