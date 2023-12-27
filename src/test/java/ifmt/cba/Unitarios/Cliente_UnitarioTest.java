package ifmt.cba.Unitarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ifmt.cba.entity.Cliente;

public class Cliente_UnitarioTest {


    @Test
    public void validarClienteDadosCorretos(){

        Cliente cliente = new Cliente();
        cliente.setNome("Java Hibernate do Mock");
        cliente.setRG("5848596-3");
        cliente.setCPF("11122233344455");
        cliente.setTelefone("65.99999-2222");
        cliente.setLogradouro("Rua da Alegria do Java");
        cliente.setNumero("21");
        cliente.setBairro("Bairro do Mock");
        cliente.setPontoReferencia("Perto do bar do Mockito");

        String resultado = cliente.validar();
        Assertions.assertEquals("",resultado);
    }

    @Test
    public void naoValidarClienteComCPFNull(){
        
        Cliente cliente = new Cliente();
        cliente.setNome("Java Hibernate do Mock");
        cliente.setRG("5848596-3");
        cliente.setCPF("");
        cliente.setTelefone("65.99999-2222");
        cliente.setLogradouro("Rua da Alegria do Java");
        cliente.setNumero("21");
        cliente.setBairro("Bairro do Mock");
        cliente.setPontoReferencia("Perto do bar do Mockito");

        String resultado = cliente.validar();
        Assertions.assertEquals("CPF invalido",resultado);


    }
}
