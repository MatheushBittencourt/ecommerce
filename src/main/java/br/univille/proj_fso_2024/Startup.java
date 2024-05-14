package br.univille.proj_fso_2024;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.univille.proj_fso_2024.entity.Cliente;
import br.univille.proj_fso_2024.service.ClienteService;

@Component
public class Startup {
	@Autowired
	private ClienteService service;

	@EventListener
	public void onApplicationInit(ContextRefreshedEvent event) {
		
		var cliente1 = new Cliente();
		cliente1.setNome("Cliente 1");
		cliente1.setCpf("12345678900");
		cliente1.setEndereco("Rua 1");
		cliente1.setDataNascimento(new Date(2024,04,21));
		service.save(cliente1);
	}
}
