package ifmt.cba.negocio;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ifmt.cba.dto.TipoPreparoDTO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.TipoPreparoDAO;


public class TipoPreparoNegocio_TipoPreparoDAO_UnitarioTest {

    @Test
    public void inserirTipoPreparo(){
    TipoPreparoDAO tipoPreparoDAO = Assertions.assertDoesNotThrow(
        ()-> new TipoPreparoDAO(FabricaEntityManager.getEntityManagerTeste()));
    TipoPreparoNegocio tipoPreparoNegocio = Assertions.assertDoesNotThrow(
        ()-> new TipoPreparoNegocio(tipoPreparoDAO));
    TipoPreparoDTO tipoPreparoDTO = new TipoPreparoDTO();
    tipoPreparoDTO.setDescricao("Cozinha Banho Maria");
    Assertions.assertDoesNotThrow(
        ()-> tipoPreparoNegocio.inserir(tipoPreparoDTO));
    List<TipoPreparoDTO> lista = Assertions.assertDoesNotThrow(
        ()-> tipoPreparoNegocio.pesquisaParteDescricao("Cozinh"));
    Assertions.assertFalse(lista.isEmpty());

    }  

    @Test
    public void testeTipoPreparoNaoEncontrado(){
        TipoPreparoDAO tipoPreparoDAO = Assertions.assertDoesNotThrow(
        ()-> new TipoPreparoDAO(FabricaEntityManager.getEntityManagerTeste()));
    TipoPreparoNegocio tipoPreparoNegocio = Assertions.assertDoesNotThrow(
        ()-> new TipoPreparoNegocio(tipoPreparoDAO));
    TipoPreparoDTO tipoPreparoDTO = new TipoPreparoDTO();
    tipoPreparoDTO.setDescricao("Cozinha Banho Maria");
    Assertions.assertDoesNotThrow(
        ()-> tipoPreparoNegocio.inserir(tipoPreparoDTO));
    List<TipoPreparoDTO> lista = Assertions.assertDoesNotThrow(
        ()-> tipoPreparoNegocio.pesquisaParteDescricao("Assado"));
    Assertions.assertTrue(lista.isEmpty());

    }

    @Test
    public void exclusaoTipoPreparo(){
        TipoPreparoDAO tipoPreparoDAO = Assertions.assertDoesNotThrow(
        ()-> new TipoPreparoDAO(FabricaEntityManager.getEntityManagerTeste()));
    TipoPreparoNegocio tipoPreparoNegocio = Assertions.assertDoesNotThrow(
        ()-> new TipoPreparoNegocio(tipoPreparoDAO));
    TipoPreparoDTO tipoPreparoDTO = new TipoPreparoDTO();
    tipoPreparoDTO.setDescricao("Cozinha Banho Maria");
    Assertions.assertDoesNotThrow(
        ()-> tipoPreparoNegocio.inserir(tipoPreparoDTO));
    Assertions.assertDoesNotThrow(
        ()-> tipoPreparoNegocio.excluir(1));
    
    List<TipoPreparoDTO> lista = Assertions.assertDoesNotThrow(
        ()-> tipoPreparoNegocio.pesquisaParteDescricao("Cozinha Banho Maria"));
    Assertions.assertTrue(lista.isEmpty());
    }


}
