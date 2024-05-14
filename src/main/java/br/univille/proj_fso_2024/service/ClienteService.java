package br.univille.proj_fso_2024.service;

import java.util.List;
import br.univille.proj_fso_2024.entity.Cliente;

public interface ClienteService {
	void save(Cliente cliente);
	Cliente getById(long id);
	List<Cliente> getAll();
}
