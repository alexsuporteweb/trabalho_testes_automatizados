package ifmt.cba.negocio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ifmt.cba.dto.ClienteDTO;
import ifmt.cba.entity.Cliente;
import ifmt.cba.persistencia.ClienteDAO;
import ifmt.cba.persistencia.PedidoDAO;

public class ClienteNegocio_UnitarioTest {

    @Test
    public void validarInserirClienteComMock(){
    ClienteNegocio clienteNegocio;
    ClienteDAO clienteDao;
    PedidoDAO pedidoDAO = Mockito.mock(PedidoDAO.class);
   
    ClienteDTO clienteDTO = Mockito.mock(ClienteDTO.class);
    Mockito.when(clienteDTO.getNome()).thenReturn("Nome");
    Mockito.when(clienteDTO.getRG()).thenReturn("5545646-4");
    Mockito.when(clienteDTO.getCPF()).thenReturn("88899966699");
    Mockito.when(clienteDTO.getTelefone()).thenReturn("65.99999-5555");  
    Mockito.when(clienteDTO.getLogradouro()).thenReturn("Rua dos Mocks");
    Mockito.when(clienteDTO.getNumero()).thenReturn("20");
    Mockito.when(clienteDTO.getBairro()).thenReturn("Bairro da Persistência");
    Mockito.when(clienteDTO.getPontoReferencia()).thenReturn("Próximo ao bar do Python");
    
    clienteDao = Mockito.mock(ClienteDAO.class);
    Assertions.assertDoesNotThrow(
        ()-> Mockito.when(clienteDao.buscarPorCPF(clienteDTO.getCPF())).thenReturn(null)); 
        // Qdo coloquei cliente, deu que cliente ja existe

    clienteNegocio = Assertions.assertDoesNotThrow(()-> new ClienteNegocio(clienteDao, pedidoDAO));
    Assertions.assertDoesNotThrow(()-> clienteNegocio.inserir(clienteDTO));
    Assertions.assertDoesNotThrow(
        ()-> Mockito.verify(clienteDao).incluir(new Cliente()));     

    }
    
}
