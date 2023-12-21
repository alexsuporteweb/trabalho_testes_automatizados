package ifmt.cba.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PreparoProduto_UnitarioTest {

    @Test
    public void validarPreparoProdutoComMock(){
        
        Produto produto = Mockito.mock(Produto.class);
        Mockito.when(produto.getNome()).thenReturn("Arroz");

        TipoPreparo tipoPreparo = Mockito.mock(TipoPreparo.class);
        Mockito.when(tipoPreparo.getDescricao()).thenReturn("Cozinhar por 10 minutos");

        PreparoProduto preparoProduto = new PreparoProduto();
        preparoProduto.setProduto(produto);
        preparoProduto.setTipoPreparo(tipoPreparo);
        preparoProduto.setTempoPreparo(15);
        preparoProduto.setValorPreparo(5.0f);

        String resultado = preparoProduto.validar();
        Assertions.assertEquals("", resultado);

    }
    
}
