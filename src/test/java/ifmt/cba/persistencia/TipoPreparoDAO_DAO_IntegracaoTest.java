package ifmt.cba.persistencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;


import ifmt.cba.entity.TipoPreparo;

public class TipoPreparoDAO_DAO_IntegracaoTest {

    @Test
    public void testOperacaoInclusaoTipoPreparo(){
    TipoPreparoDAO tipoPreparoDAO = Assertions.assertDoesNotThrow(
        ()-> new TipoPreparoDAO(FabricaEntityManager.getEntityManagerProducao()));
        TipoPreparo tipoPreparo = new TipoPreparo();
        tipoPreparo.setDescricao("Cozinhar Banho Maria");

        tipoPreparoDAO.beginTransaction();
        Assertions.assertDoesNotThrow(
            ()-> tipoPreparoDAO.incluir(tipoPreparo));
        tipoPreparoDAO.commitTransaction();
        
   
    }   
    @Test
    @DisplayName("Teste lista de prepraro por parte do nome e retorna uma lista caso haja")
    public void testeListaTipoPreparo(){
        TipoPreparoDAO tipoPreparoDAO = Assertions.assertDoesNotThrow(
            ()-> new TipoPreparoDAO(FabricaEntityManager.getEntityManagerProducao()));
        TipoPreparo tipoPreparo = new TipoPreparo();
        tipoPreparo.setDescricao("Cozinhar Banho Maria");
        tipoPreparoDAO.beginTransaction();
        Assertions.assertDoesNotThrow(
            ()-> tipoPreparoDAO.incluir(tipoPreparo));
        tipoPreparoDAO.commitTransaction();
        List<TipoPreparo> lista = Assertions.assertDoesNotThrow(
            ()-> tipoPreparoDAO.buscarPorParteDescricao("Cozinha"));
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void testeConsultaPorCodigo(){
        TipoPreparoDAO tipoPreparoDAO = Assertions.assertDoesNotThrow(
            ()-> new TipoPreparoDAO(FabricaEntityManager.getEntityManagerProducao()));

        tipoPreparoDAO.beginTransaction();
        Assertions.assertDoesNotThrow(()->tipoPreparoDAO.buscarPorCodigo(1));
        tipoPreparoDAO.commitTransaction();
    }
    @Test
    public void testeBuscarporDescricao(){

        TipoPreparoDAO tipoPreparoDAO = Assertions.assertDoesNotThrow(
            ()-> new TipoPreparoDAO(FabricaEntityManager.getEntityManagerProducao()));
        tipoPreparoDAO.beginTransaction();
        Assertions.assertDoesNotThrow(
            ()->tipoPreparoDAO.buscarPorParteDescricao("Cozinha"));
        tipoPreparoDAO.commitTransaction();   
    }
}
