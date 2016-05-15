package br.verbalize.sc.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

}
