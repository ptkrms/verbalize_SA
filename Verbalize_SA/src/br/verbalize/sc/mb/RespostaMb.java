package br.verbalize.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;

import br.verbalize.sc.model.entity.Resposta;
import br.verbalize.sc.model.rn.RespostaRN;

@ManagedBean
public class RespostaMb {

	private Resposta resposta;
	private RespostaRN respostaRN;
	private Long editarId;
	private List<Resposta> listaRespostas;
	
	@PostConstruct
	public void depoisDeConstruir() {
		resposta = new Resposta();
		respostaRN = new RespostaRN();
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public List<Resposta> getListaRespostas() {
		if(listaRespostas == null) {
			listaRespostas = respostaRN.listarRespostas();
		}
		return listaRespostas;
	}

	public void setListaRespostas(List<Resposta> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}
	
	public void carregarResposta(ComponentSystemEvent event) {
		if(editarId == null) {
			return ;
		}
		resposta = respostaRN.buscarPorId(editarId);
	}
	
	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		respostaRN.excluir(idExcluir);
		listaRespostas = null;
		return "";
	}
	
	public String salvar() {
		respostaRN.salvar(resposta);
		listaRespostas = null;
		return "";
	}
	
	
	
	
	
}
