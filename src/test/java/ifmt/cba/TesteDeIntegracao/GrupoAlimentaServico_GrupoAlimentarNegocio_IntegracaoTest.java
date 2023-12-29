package ifmt.cba.TesteDeIntegracao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.negocio.GrupoAlimentarNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.GrupoAlimentarDAO;
import ifmt.cba.persistencia.ProdutoDAO;
import ifmt.cba.servico.GrupoAlimentarServico;

public class GrupoAlimentaServico_GrupoAlimentarNegocio_IntegracaoTest {


    @Test
    @DisplayName("Teste o metodo PesquisaPorCódigo da classe GrupoAlimentarNegocio")
    public void testePesquisaPorCodigo() throws NegocioException{

       GrupoAlimentarDAO grupoAlimentarDAO = Mockito.mock(GrupoAlimentarDAO.class);
       ProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);

        GrupoAlimentarNegocio grupoAlimentarNegocio = new GrupoAlimentarNegocio(grupoAlimentarDAO, produtoDAO);
    //    GrupoAlimentarServico grupoAlimentarServico = new GrupoAlimentarServico();

        
        Assertions.assertDoesNotThrow(
          ()->grupoAlimentarNegocio.buscarPorCodigo(0));


    }
    
}
