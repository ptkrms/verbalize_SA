package br.verbalize.sc.model.entity;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	
	@Column(nullable=false, length=100)
	private String nmPessoa;

	@Column(length=100)
	private String email;
	
	@Column(nullable=false, length=14)
	private String nuCpf;
	
	@Column(length=13)
	private String telefone;
	
	/*@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dtNascimento;*/

	@Column(nullable=false, length=14)
	private String senha;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=20)
	private String nmPerfil;
	
	/*@Column(nullable=false, length=1)
	private int tpPermissao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dtCadastro;*/
	
	public Pessoa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNuCpf() {
		return nuCpf;
	}

	public void setNuCpf(String nuCpf) {
		this.nuCpf = nuCpf;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/*public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}*/

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNmPerfil() {
		return nmPerfil;
	}

	public void setNmPerfil(String nmPerfil) {
		this.nmPerfil = nmPerfil;
	}

	/*public int getTpPermissao() {
		return tpPermissao;
	}

	public void setTpPermissao(int tpPermissao) {
		this.tpPermissao = tpPermissao;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}*/
	

}
