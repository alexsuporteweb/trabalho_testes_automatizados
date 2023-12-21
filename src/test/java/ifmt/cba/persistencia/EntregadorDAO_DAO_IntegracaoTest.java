package ifmt.cba.persistencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ifmt.cba.entity.Entregador;

public class EntregadorDAO_DAO_IntegracaoTest {

    @Test
    public void testeOperacaoInclusaoIntegracaoBanco(){
        EntregadorDAO entregadorDAO = Assertions.assertDoesNotThrow(
        ()-> new EntregadorDAO(FabricaEntityManager.getEntityManagerProducao()));
    
        Entregador entregador = new Entregador();
        entregador.setNome("Entegador 02");
        entregador.setCPF("854.996.885-85");
        entregador.setRG("55849-5");
        entregador.setTelefone("65.9888-8855");

        entregadorDAO.beginTransaction();
        Assertions.assertDoesNotThrow(()->entregadorDAO.incluir(entregador));
        entregadorDAO.commitTransaction();

    }

    @Test
    public void testeConsultaPorCodigo(){
        EntregadorDAO entregadorDAO = Assertions.assertDoesNotThrow(
        ()-> new EntregadorDAO(FabricaEntityManager.getEntityManagerTeste()));

        entregadorDAO.beginTransaction();
        Assertions.assertDoesNotThrow(()->entregadorDAO.buscarPorCodigo(1));
        entregadorDAO.commitTransaction();

    }
    
     @Test
    public void testeConsultaPorParteNome(){
        EntregadorDAO entregadorDAO = Assertions.assertDoesNotThrow(
        ()-> new EntregadorDAO(FabricaEntityManager.getEntityManagerTeste()));

        entregadorDAO.beginTransaction();
        Assertions.assertDoesNotThrow(()->entregadorDAO.buscarPorParteNome("Entre"));
        entregadorDAO.commitTransaction();

    }

     @Test
    public void testeConsultaPorCPF(){
        EntregadorDAO entregadorDAO = Assertions.assertDoesNotThrow(
        ()-> new EntregadorDAO(FabricaEntityManager.getEntityManagerTeste()));

        entregadorDAO.beginTransaction();
        Assertions.assertDoesNotThrow(()->entregadorDAO.buscarPorCPF("234.432.567-85"));
        entregadorDAO.commitTransaction();
    }

    @Test
    public void testeExclusaoEntregador(){
        Entregador entregador = new Entregador();
        EntregadorDAO entregadorDAO = Assertions.assertDoesNotThrow(
        ()-> new EntregadorDAO(FabricaEntityManager.getEntityManagerTeste()));

        entregadorDAO.beginTransaction();
        Assertions.assertDoesNotThrow(()->entregadorDAO.excluir(entregador));
        entregadorDAO.commitTransaction();
    }

}
