package br.verbalize.sc.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="resposta")
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String tipoPergunta;
	private Boolean correta;
	@ManyToOne(cascade=CascadeType.ALL)
	private Pergunta pergunta;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTipoPergunta() {
		return tipoPergunta;
	}
	public void setTipoPergunta(String tipoPergunta) {
		this.tipoPergunta = tipoPergunta;
	}
	public Boolean getCorreta() {
		return correta;
	}
	public void setCorreta(Boolean correta) {
		this.correta = correta;
	}
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
