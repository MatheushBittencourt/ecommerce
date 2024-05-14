package br.univille.proj_fso_2024.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 1000, nullable = false)
	@NotBlank(message = "O nome é obrigatório")
    private String nome;
	@Column(length = 1000, nullable = false)
    private String endereco;
	@Column(length = 11, nullable = false, unique = true)
    private String cpf;
    private String email;
	private Date dataNascimento;

	public String getNome() {
		return nome;
    }
    
    public void setNome(String nome) {
		this.nome = nome;
    }
    
    public String getEndereco() {
		return endereco;
    }
    
    public void setEndereco(String endereco) {
		this.endereco = endereco;
    }
    
    public String getCpf() {
		return cpf;
    }
    
    public void setCpf(String cpf) {
		this.cpf = cpf;
    }
    
    public Long getId() {
		return id;
    }
    
    public void setId(Long id) {
		this.id = id;
    }
    
    public String getEmail() {
		return email;
    }
    
    public void setEmail(String email) {
		this.email = email;
    }
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
