package br.univille.proj_fso_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.proj_fso_2024.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
}
