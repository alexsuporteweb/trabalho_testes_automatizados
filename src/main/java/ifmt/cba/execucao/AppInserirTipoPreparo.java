package ifmt.cba.execucao;

import ifmt.cba.dto.TipoPreparoDTO;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.negocio.TipoPreparoNegocio;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.persistencia.TipoPreparoDAO;

public class AppInserirTipoPreparo {
    public static void main(String[] args) {

        try {
            TipoPreparoDAO tipoPreparoDAO = new TipoPreparoDAO(
                    FabricaEntityManager.getEntityManagerProducao());
            TipoPreparoNegocio tipoPreparoNegocio = new TipoPreparoNegocio(tipoPreparoDAO);
    
            TipoPreparoDTO tipoPreparoDTO = new TipoPreparoDTO();
            tipoPreparoDTO.setDescricao("assar por 25 minutos");
            tipoPreparoNegocio.inserir(tipoPreparoDTO);

        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    }
}
