package ifmt.cba.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TipoPreparo_UnitarioTest {

    @Test
    public void validarTipoPreparo(){

        TipoPreparo tipoPreparo = new TipoPreparo();
        tipoPreparo.setDescricao("Este produto é assado");

        String resultado = tipoPreparo.validar();
        Assertions.assertEquals("", resultado);
        

    }
    
}
