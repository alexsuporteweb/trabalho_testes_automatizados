package ifmt.cba.Unitarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.entity.Cardapio;
import ifmt.cba.entity.PreparoProduto;

import java.util.List;
import java.util.ArrayList;


public class Cardapio_UnitarioTest {

@Test
public void validarCardapiocomMock(){

   PreparoProduto preparo = Mockito.mock(PreparoProduto.class);
   Mockito.when(preparo.getNome()).thenReturn("Couve");
   List <PreparoProduto> preparoProduto = new ArrayList<PreparoProduto>();
   preparoProduto.add(0, preparo);
     
    Cardapio cardapio = new Cardapio();
    cardapio.setNome("Feijoada");
    cardapio.setDescricao("Feijoada com pertences de porco");
    cardapio.setListaPreparoProduto(preparoProduto);

   String resultado = cardapio.validar();
   Assertions.assertEquals("",resultado);

}
}