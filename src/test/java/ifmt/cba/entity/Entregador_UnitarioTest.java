package ifmt.cba.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Entregador_UnitarioTest {

     @Test
    public void validarDadosCorretosEntregador(){

        Entregador entregador = new Entregador();
        entregador.setNome("Entregador de Tal");
        entregador.setRG("55464-6");
        entregador.setCPF("12345678901");
        entregador.setTelefone("65.99999-5555");

        String resultado = entregador.validar();
        Assertions.assertEquals("", resultado);
    }
    
    @Test
    public void testValidarNomeInvalido() {
        Entregador entregador = new Entregador();
        entregador.setNome("En");
        entregador.setRG("55464-6");
        entregador.setCPF("12345678901");
        entregador.setTelefone("65.99999-5555");
        String resultadoValidacao = entregador.validar();
        assertEquals("Nome invalido", resultadoValidacao, "A validação deve falhar para nome inválido");
    }
}
