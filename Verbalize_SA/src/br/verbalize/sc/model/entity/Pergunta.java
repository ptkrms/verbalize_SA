package br.verbalize.sc.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pergunta")
public class Pergunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String enunciado;
	private String tipoPergunta;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Resposta> respostasParaPergunta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getTipoPergunta() {
		return tipoPergunta;
	}

	public void setTipoPergunta(String tipoPergunta) {
		this.tipoPergunta = tipoPergunta;
	}

	public List<Resposta> getRespostasParaPergunta() {
		return respostasParaPergunta;
	}

	public void setRespostasParaPergunta(List<Resposta> respostasParaPergunta) {
		this.respostasParaPergunta = respostasParaPergunta;
	}

	

}
