package com.farmaciaBiqueiraDoBem.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "O campo Nome é obrigatório!")
	@Size (min = 10, max = 100, message = "Digite no mínimo 10 e no máximo 100 caracteres.")
	private String nome;
	
	@Schema(example = "email@email.com.br")
	@NotNull (message = "O atributo email é obrigatório!")
	@Email (message = "O atributo Login deve ser um email válido!")
	private String email;
	
	@Size (max = 500, message = "O link da foto não pode ser maior do que 255 caracteres.")
	private String foto;
	
	@NotNull(message = "A Data de nascimento é obrigatório!")
	@Column
	private LocalDate data;
	
	@NotBlank (message = "O campo Senha é obrigatório!")
	@Size (min = 8, message = "O campo Senha deve ter no mínimo 8 caracteres.")
	private String senha;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ("usuario")
	private List<Produto> produtos;

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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produto> getProduto() {
		return this.produtos;
	}

	public void setProduto(List<Produto> produto) {
		this.produtos = produto;
	}

	
}
