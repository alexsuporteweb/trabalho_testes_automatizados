package ifmt.cba.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrupoAlimentar_UnitarioTest {

    @Test
    public void  validarGrupoAlimentarNomeMaiorQue03Letras(){

        GrupoAlimentar grupoAlimentar = new GrupoAlimentar();
        grupoAlimentar.setNome("Legumes");
        String resultado = grupoAlimentar.validar();
        Assertions.assertEquals("",resultado);

    }
    @Test
    public void  negarValidacaoGrupoAlimentarNomeMenorQue03Letras(){

        GrupoAlimentar grupoAlimentar = new GrupoAlimentar();
        grupoAlimentar.setNome("Le");
        String resultado = grupoAlimentar.validar();
        Assertions.assertEquals("Nome nao valido",resultado);

    }
}
