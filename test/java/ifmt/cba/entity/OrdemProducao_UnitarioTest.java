package ifmt.cba.entity;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.dto.EstadoOrdemProducaoDTO;

public class OrdemProducao_UnitarioTest {
    
    @Test
    public void validarOrdemProducaoComMock(){
        OrdemProducao ordemProducao = new OrdemProducao();
        LocalDate data = LocalDate.of(2023,12,9);
        
        ItemOrdemProducao itemOrdemProducao = Mockito.mock(ItemOrdemProducao.class);
        Mockito.when(itemOrdemProducao.getQuantidadePorcao()).thenReturn(5);
        List<ItemOrdemProducao> item = new ArrayList<ItemOrdemProducao>();
        item.add(itemOrdemProducao);
        
        Cardapio cardapio = Mockito.mock(Cardapio.class);
        Mockito.when(cardapio.getNome()).thenReturn("Feijão");

        EstadoOrdemProducaoDTO estadoOrdemProducaoDTO = EstadoOrdemProducaoDTO.PROCESSADA;

       
        ordemProducao.setListaItens(item);
        ordemProducao.setDataProducao(data);
        ordemProducao.setCardapio(cardapio);
        ordemProducao.setEstado(estadoOrdemProducaoDTO);

        String resultado = ordemProducao.validar();
        Assertions.assertEquals("", resultado);





    }
}