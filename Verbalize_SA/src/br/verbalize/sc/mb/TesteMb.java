package br.verbalize.sc.mb;

import java.util.List;

import br.verbalize.sc.model.entity.Pergunta;
import br.verbalize.sc.model.entity.Teste;


public class TesteMb {
	private List<Pergunta> ListaPerguntas;
	//private TesteRN testeRN;
	private Teste teste;
	private Long editarId;
	
	
	public void depoisDeConstruir() {
		teste = new Teste();
		//testeRN = new TesteRN;
	}

	public Teste getTeste() {
		return teste;
	}

	public void setTeste(Teste teste) {
		this.teste = teste;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public List<Pergunta> getListaPerguntas() {
		if (ListaPerguntas == null) {
			
		}
		return ListaPerguntas;
	}

	public void setListaPerguntas(List<Pergunta> listaPerguntas) {
		ListaPerguntas = listaPerguntas;
	}
	
	

}
