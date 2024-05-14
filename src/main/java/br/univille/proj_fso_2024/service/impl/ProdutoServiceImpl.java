package br.univille.proj_fso_2024.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.proj_fso_2024.entity.Produto;
import br.univille.proj_fso_2024.repository.ProdutoRepository;
import br.univille.proj_fso_2024.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Override
	public void save(Produto produto) {
		repository.save(produto);
	}

	@Override
	public Produto getById(long id) {
		return repository.getById(id);
	}

	@Override
	public List<Produto> getAll() {
		return repository.findAll();
	}

	@Override
	public Produto delete(long id) {
		Produto produto = getById(id);
		repository.delete(produto);
		return produto;
	}
	
}
