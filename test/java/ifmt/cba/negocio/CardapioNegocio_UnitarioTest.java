package ifmt.cba.negocio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.dto.CardapioDTO;
import ifmt.cba.entity.Cardapio;
import ifmt.cba.persistencia.CardapioDAO;

public class CardapioNegocio_UnitarioTest {
    
    @Test
    public void validarOperacaodeInclusaoCardapioComMock(){

      CardapioDAO cardapioDAO;
      CardapioNegocio cardapioNegocio;
      
      CardapioDTO cardapioDTO = new CardapioDTO();
      cardapioDTO.setNome("Teste de Inclusão Cardápio");

      cardapioDAO = Mockito.mock(CardapioDAO.class);

      cardapioNegocio = Assertions.assertDoesNotThrow(
        ()->new CardapioNegocio(cardapioDAO));
        Assertions.assertDoesNotThrow(()-> cardapioNegocio.inserir(cardapioDTO));
        Assertions.assertDoesNotThrow(()
        ->Mockito.verify(cardapioDAO).incluir(new Cardapio()));

    }
}
