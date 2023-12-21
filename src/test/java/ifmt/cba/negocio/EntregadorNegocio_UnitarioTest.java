package ifmt.cba.negocio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.dto.EntregadorDTO;
import ifmt.cba.entity.Entregador;
import ifmt.cba.persistencia.EntregadorDAO; 


public class EntregadorNegocio_UnitarioTest {


@Test
public void validaEntregadorcomMock(){

    EntregadorDAO entregadorDAO;
    EntregadorNegocio entregadorNegocio;
    Entregador entregador = new Entregador();
    
    EntregadorDTO entregadorDTO = Mockito.mock(EntregadorDTO.class);
    Mockito.when(entregadorDTO.getNome()).thenReturn("Entregador de Tal");
    Mockito.when(entregadorDTO.getCPF()).thenReturn("88899988825");
    Mockito.when(entregadorDTO.getRG()).thenReturn("65464-8");
    Mockito.when(entregadorDTO.getTelefone()).thenReturn("65/55555-8888");

    entregadorDAO = Mockito.mock(EntregadorDAO.class);

    Assertions.assertDoesNotThrow(()
    -> Mockito.when(entregadorDAO.buscarPorCPF(entregadorDTO.getNome())).thenReturn(entregador));

    entregadorNegocio = Assertions.assertDoesNotThrow(
        ()-> new EntregadorNegocio(entregadorDAO));

    Assertions.assertDoesNotThrow(()-> entregadorNegocio.inserir(entregadorDTO));
    Assertions.assertDoesNotThrow(
        ()-> Mockito.verify(entregadorDAO).incluir(new Entregador()));


}

}
