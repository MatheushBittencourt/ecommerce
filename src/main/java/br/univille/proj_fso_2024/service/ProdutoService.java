package br.univille.proj_fso_2024.service;

import java.util.List;
import br.univille.proj_fso_2024.entity.Produto;

public interface ProdutoService {
	void save(Produto produto);
	Produto getById(long id);
	List<Produto> getAll();
	Produto delete(long id);
}
