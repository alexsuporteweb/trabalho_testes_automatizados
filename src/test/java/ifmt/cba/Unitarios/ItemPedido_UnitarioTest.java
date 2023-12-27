package ifmt.cba.Unitarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.entity.ItemPedido;
import ifmt.cba.entity.PreparoProduto;

public class ItemPedido_UnitarioTest {

    @Test
    public void validarItemPedidoComMock(){

    ItemPedido itemPedido = new ItemPedido();
    itemPedido.setQuantidadePorcao(20);

    PreparoProduto preparo = Mockito.mock(PreparoProduto.class);
    Mockito.when(preparo.getNome()).thenReturn("Couve");
    itemPedido.setPreparoProduto(preparo);
       
    String resultado = itemPedido.validar();
    Assertions.assertEquals("", resultado);

    }
    
}
