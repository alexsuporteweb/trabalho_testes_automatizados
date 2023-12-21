package ifmt.cba.execucao;

import ifmt.cba.dto.ClienteDTO;
import ifmt.cba.negocio.ClienteNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.ClienteDAO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PedidoDAO;
import ifmt.cba.persistencia.PersistenciaException;

public class AppInserirCliente {
    public static void main(String[] args) {

        try {
            ClienteDAO clienteDAO = new ClienteDAO(
                    FabricaEntityManager.getEntityManagerProducao());
            PedidoDAO pedidoDAO = new PedidoDAO(FabricaEntityManager.getEntityManagerProducao());
            ClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO, pedidoDAO);
    
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNome("Cliente da Fé");
            clienteDTO.setCPF("854.345.607-50");
            clienteDTO.setRG("234567-9");
            clienteDTO.setTelefone("65 99985-7070");
            clienteDTO.setLogradouro("Rua das lamentações flores");
            clienteDTO.setNumero("50");
            clienteDTO.setPontoReferencia("ao lado do bar");
            clienteDTO.setBairro("CPA III");
            clienteNegocio.inserir(clienteDTO);

            ClienteDTO clienteDTO2 = new ClienteDTO();
            clienteDTO2.setNome("Java da Silva");
            clienteDTO2.setCPF("874.698.659-89");
            clienteDTO2.setRG("28559-7");
            clienteDTO2.setTelefone("65 98899-1070");
            clienteDTO2.setLogradouro("Rua do Mock");
            clienteDTO2.setNumero("17");
            clienteDTO2.setPontoReferencia("Proximo ao Bar do Python");
            clienteDTO2.setBairro("Mockito");
            clienteNegocio.inserir(clienteDTO2);

        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    }
}
