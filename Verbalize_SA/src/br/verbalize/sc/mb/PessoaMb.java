package br.verbalize.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;

import br.verbalize.sc.model.PessoaRN;
import br.verbalize.sc.model.entity.Pessoa;

@ManagedBean
public class PessoaMb {
	private Pessoa pessoa;
	private PessoaRN pessoaRN;
	private Long editarId;
	private List<Pessoa> listaPessoas;

	@PostConstruct
	public void depoisDeConstruir() {
		pessoa = new Pessoa();
		pessoaRN = new PessoaRN();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Long getEditarId() {
		return editarId;
	}
	
	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
	
	public List<Pessoa> getListaPessoas() {
		if(listaPessoas == null) {
			listaPessoas = pessoaRN.listarPessoas();
		}
		return listaPessoas;
	}
	
	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
	public void carregarPessoa(ComponentSystemEvent event) {
		if(editarId == null) {
			return ;
		}
		pessoa = pessoaRN.buscarPorId(editarId);
	}
	
	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		pessoaRN.excluir(idExcluir);
		listaPessoas = null;
		return "";
	}
	
	public String salvar() {
		pessoaRN.salvar(pessoa);
		listaPessoas = null;
		return "";
	}
	
}
