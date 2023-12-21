package ifmt.cba.execucao;

import ifmt.cba.dto.EntregadorDTO;
import ifmt.cba.negocio.EntregadorNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.EntregadorDAO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PersistenciaException;

public class AppInserirEntregador {
    public static void main(String[] args) {

        try {
            EntregadorDAO entregadorDAO = new EntregadorDAO(
                    FabricaEntityManager.getEntityManagerProducao());
            EntregadorNegocio entregadorNegocio = new EntregadorNegocio(entregadorDAO);
    
            EntregadorDTO entregadorDTO = new EntregadorDTO();
            entregadorDTO.setNome("Entregador da Silva");
            entregadorDTO.setTelefone("65 99999-7200");
            entregadorDTO.setRG("456859-1");
            entregadorDTO.setCPF("534.432.877-12");

            entregadorNegocio.inserir(entregadorDTO);

        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    }
}
