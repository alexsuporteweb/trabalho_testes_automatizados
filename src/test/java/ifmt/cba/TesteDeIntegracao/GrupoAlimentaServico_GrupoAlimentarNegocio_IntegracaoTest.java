package ifmt.cba.TesteDeIntegracao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import ifmt.cba.servico.GrupoAlimentarServico;

public class GrupoAlimentaServico_GrupoAlimentarNegocio_IntegracaoTest {


    @Test
    @DisplayName("Teste o metodo PesquisaPorCódigo da classe GrupoAlimentarNegocio")
    public void testePesquisaPorCodigo(){

        GrupoAlimentarServico grupoAlimentarServico = new GrupoAlimentarServico();

        Assertions.assertDoesNotThrow(
            ()->grupoAlimentarServico.buscarGrupoAlimentarPorCodigo(0));


    }
    
}
