package br.verbalize.sc.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teste")
public class Teste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;

	@ManyToMany
	private List<Pergunta> perguntasParaTeste;
	@ManyToOne
	private Turma turma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Pergunta> getPerguntasParaTeste() {
		return perguntasParaTeste;
	}

	public void setPerguntasParaTeste(List<Pergunta> perguntasParaTeste) {
		this.perguntasParaTeste = perguntasParaTeste;
	}

}
