package ifmt.cba.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Colaborador_UnitarioTest {

    @Test
    public void validarDadosCorretosColaborador(){

        Colaborador colaborador = new Colaborador();
        colaborador.setNome("Colaborador de Tal");
        colaborador.setRG("55464-6");
        colaborador.setCPF("12345678901");
        colaborador.setTelefone("65.99999-5555");

        String resultado = colaborador.validar();
        Assertions.assertEquals("", resultado);

    }
}
