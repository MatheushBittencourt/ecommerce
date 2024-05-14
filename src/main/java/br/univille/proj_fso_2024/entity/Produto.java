package br.univille.proj_fso_2024.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 1000, nullable = false)
	@NotBlank(message = "O nome é obrigatório")
    private String nome;
	@Column(length = 6, nullable = false)
    private Float preco;
	@Column(nullable = true)
    private String imagem;
	@Column(nullable = true)
	private Boolean promocao;
	@Column(nullable = true)
	private Float precoAnterior;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Boolean getPromocao() {
		return promocao;
	}
	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}
	public Float getPrecoAnterior() {
		return precoAnterior;
	}
	public void setPrecoAnterior(Float precoAnterior) {
		this.precoAnterior = precoAnterior;
	}
	
}
