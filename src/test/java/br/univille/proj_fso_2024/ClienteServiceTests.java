package br.univille.proj_fso_2024;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import br.univille.proj_fso_2024.entity.Cliente;
import br.univille.proj_fso_2024.service.ClienteService;

@SpringBootTest
@ContextConfiguration
@ActiveProfiles(profiles = "test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ClienteServiceTests {

	@Autowired
	private ClienteService service;

	@Test
	void getAllClientesEmptyList() {
		var listaClientes = service.getAll();
		assertEquals(listaClientes.size(), 0);
	}

	@Test
	void saveNewClienteFindAll(){
		var newCliente = new Cliente();
		newCliente.setNome("Cliente 1");
		newCliente.setCpf("123.456.789-00");
		service.save(newCliente);

		var listaClientes = service.getAll();
		assertEquals(listaClientes.get(0).getNome(), "Cliente 1");
	}
}
