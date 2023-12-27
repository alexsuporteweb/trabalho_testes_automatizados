package ifmt.cba.Unitarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ifmt.cba.entity.Colaborador;

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
