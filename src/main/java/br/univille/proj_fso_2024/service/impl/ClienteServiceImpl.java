package br.univille.proj_fso_2024.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.proj_fso_2024.entity.Cliente;
import br.univille.proj_fso_2024.repository.ClienteRepository;
import br.univille.proj_fso_2024.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public void save(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	public Cliente getById(long id) {
		return repository.getById(id);
	}

	@Override
	public List<Cliente> getAll() {
		return repository.findAll();
	}
	
}
