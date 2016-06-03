package br.verbalize.sc.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String nmTurma;
	private Date dataDeInicio;
	private Date dataDeConclusao;
	private Float mensalidade;
	@ManyToOne
	private Pessoa professor;
	@ManyToMany
	private List<Pessoa> alunosParaMatricular;
	@OneToMany
	private List<Arquivo> arquivosDaTurma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmTurma() {
		return nmTurma;
	}

	public void setNmTurma(String nmTurma) {
		this.nmTurma = nmTurma;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Date getDataDeConclusao() {
		return dataDeConclusao;
	}

	public void setDataDeConclusao(Date dataDeConclusao) {
		this.dataDeConclusao = dataDeConclusao;
	}

	public Float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Float mensalidade) {
		this.mensalidade = mensalidade;
	}

	public Pessoa getProfessor() {
		return professor;
	}

	public void setProfessor(Pessoa professor) {
		this.professor = professor;
	}

	public List<Pessoa> getAlunosParaMatricular() {
		return alunosParaMatricular;
	}

	public void setAlunosParaMatricular(List<Pessoa> alunosParaMatricular) {
		this.alunosParaMatricular = alunosParaMatricular;
	}

	public List<Arquivo> getArquivosDaTurma() {
		return arquivosDaTurma;
	}

	public void setArquivosDaTurma(List<Arquivo> arquivosDaTurma) {
		this.arquivosDaTurma = arquivosDaTurma;
	}
	
}
