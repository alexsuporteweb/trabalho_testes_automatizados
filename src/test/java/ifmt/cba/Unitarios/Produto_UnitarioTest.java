package ifmt.cba.Unitarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.entity.GrupoAlimentar;
import ifmt.cba.entity.Produto;

public class Produto_UnitarioTest {

    @Test
    public void validarProdutoComMock(){    

    GrupoAlimentar grupoAlimentar = Mockito.mock(GrupoAlimentar.class);
   
     Mockito.when(grupoAlimentar.validar()).thenReturn("");      
        
        Produto produto = new Produto();       
        produto.setNome("Arroz");
        produto.setCustoUnidade(5F);
        produto.setEstoque(50);
        produto.setEstoqueMinimo(10);
        produto.setGrupoAlimentar(grupoAlimentar);
        
  
       String resultado = produto.validar();
       Assertions.assertEquals("", resultado);
        
    }

}
