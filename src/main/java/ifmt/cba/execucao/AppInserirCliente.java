package ifmt.cba.execucao;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import ifmt.cba.dto.ClienteDTO;
import ifmt.cba.negocio.ClienteNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.ClienteDAO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PedidoDAO;
import ifmt.cba.persistencia.PersistenciaException;

public class AppInserirCliente {
    public static void main(String[] args) {
        Faker faker = new Faker(Locale.forLanguageTag("pt-br"));
        FakeValuesService fakevalues = new  FakeValuesService(Locale.getDefault(), new RandomService()); 

        try {
            ClienteDAO clienteDAO = new ClienteDAO(
                    FabricaEntityManager.getEntityManagerProducao());
            PedidoDAO pedidoDAO = new PedidoDAO(FabricaEntityManager.getEntityManagerProducao());
            ClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO, pedidoDAO);
            
            for (int i = 0; i<=320000; i++)
        {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNome(faker.name().fullName());
            clienteDTO.setCPF(fakevalues.bothify("###.###.###-##"));
            clienteDTO.setRG(fakevalues.bothify("#######-#"));
            clienteDTO.setLogradouro(faker.address().streetName());
            clienteDTO.setNumero(faker.number().digits(3));
            clienteDTO.setBairro("Bairro do(a) " +faker.name().firstName());
            clienteDTO.setTelefone(fakevalues.bothify("(##)9####-####"));
            clienteDTO.setPontoReferencia("Próximo ao Bar da(a) " + faker.name().fullName());
            clienteNegocio.inserir(clienteDTO);

        }

          /*  ClienteDTO clienteDTO2 = new ClienteDTO();
            clienteDTO2.setNome("Java da Silva");
            clienteDTO2.setCPF("874.698.659-89");
            clienteDTO2.setRG("28559-7");
            clienteDTO2.setTelefone("65 98899-1070");
            clienteDTO2.setLogradouro("Rua do Mock");
            clienteDTO2.setNumero("17");
            clienteDTO2.setPontoReferencia("Proximo ao Bar do Python");
            clienteDTO2.setBairro("Mockito");
            clienteNegocio.inserir(clienteDTO2);
*/
        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    }
}
