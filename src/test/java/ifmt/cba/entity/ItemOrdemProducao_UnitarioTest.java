package ifmt.cba.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ItemOrdemProducao_UnitarioTest {
    
    @Test
    public void validarItemOrdemProducaoComMock(){

        ItemOrdemProducao itemOrdemProducao = new ItemOrdemProducao();
        
        PreparoProduto preparoProduto = Mockito.mock(PreparoProduto.class);
        Mockito.when(preparoProduto.getNome()).thenReturn("Couve");
        itemOrdemProducao.setQuantidadePorcao(50);
        itemOrdemProducao.setPreparoProduto(preparoProduto);

        String resultado = itemOrdemProducao.validar();
        Assertions.assertEquals("", resultado);


    }
}
