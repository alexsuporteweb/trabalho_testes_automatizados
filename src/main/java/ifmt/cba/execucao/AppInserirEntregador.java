package ifmt.cba.execucao;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import ifmt.cba.dto.EntregadorDTO;
import ifmt.cba.negocio.EntregadorNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.EntregadorDAO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PersistenciaException;

public class AppInserirEntregador {
    public static void main(String[] args) {

        Faker faker = new Faker(Locale.forLanguageTag("pt-br"));
        FakeValuesService fakevalues = new  FakeValuesService(Locale.getDefault(), new RandomService()); 
        for (int i = 0; i<=100000; i++)
        {
        try {
            EntregadorDAO entregadorDAO = new EntregadorDAO(
                    FabricaEntityManager.getEntityManagerProducao());
            EntregadorNegocio entregadorNegocio = new EntregadorNegocio(entregadorDAO);
    
            EntregadorDTO entregadorDTO = new EntregadorDTO();
            entregadorDTO.setNome(faker.name().fullName());
            entregadorDTO.setTelefone(fakevalues.bothify("(##)9####-####"));
            entregadorDTO.setRG(fakevalues.bothify("#######-#"));
            entregadorDTO.setCPF(fakevalues.bothify("###.###.###-##"));

            entregadorNegocio.inserir(entregadorDTO);

        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    }
}
}
