package ifmt.cba.Unitarios;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.dto.CardapioDTO;
import ifmt.cba.dto.PreparoProdutoDTO;
import ifmt.cba.entity.Cardapio;
import ifmt.cba.negocio.CardapioNegocio;
import ifmt.cba.persistencia.CardapioDAO;


public class CardapioNegocio_UnitarioTest {
    
    @Test
    public void validarOperacaodeInclusaoCardapioComMock(){

      CardapioDAO cardapioDAO;
      CardapioNegocio cardapioNegocio;
    
      PreparoProdutoDTO preparoDTO = Mockito.mock(PreparoProdutoDTO.class);
      Mockito.when(preparoDTO.getNome()).thenReturn("milho");
      List <PreparoProdutoDTO> preparoProdutoDTO = new ArrayList<PreparoProdutoDTO>();
      preparoProdutoDTO.add(0, preparoDTO);

      CardapioDTO cardapioDTO = Mockito.mock(CardapioDTO.class);     
      Mockito.when(cardapioDTO.getNome()).thenReturn("Arroz a grega");
      Mockito.when(cardapioDTO.getDescricao()).thenReturn("Arroz com milho, uva passas e outros");
      Mockito.when(cardapioDTO.getListaPreparoProdutoDTO()).thenReturn(preparoProdutoDTO);

  


      //PreparoProdutoDTO preparoProdutoDTO = Mockito.mock(PreparoProdutoDTO.class);
      //Mockito.when(preparoProdutoDTO.getNome())



      cardapioDAO = Mockito.mock(CardapioDAO.class);

      cardapioNegocio = Assertions.assertDoesNotThrow(
        ()->new CardapioNegocio(cardapioDAO));
        Assertions.assertDoesNotThrow(()-> cardapioNegocio.inserir(cardapioDTO));
        Assertions.assertDoesNotThrow(()
        ->Mockito.verify(cardapioDAO).incluir(new Cardapio()));

    }
}
