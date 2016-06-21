package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.verbalize.sc.model.entity.Resposta;


public class RespostaDAO extends DAO {
	
	public void salvar(Resposta resposta) {
		getEM().merge(resposta);
	}
	
	public Resposta buscarPorid(Long id) {
		return getEM().find(Resposta.class, id);
	}
	
	public List<Resposta> listarRespostas() {
		Query query = getEM().createQuery("From Resposta", Resposta.class);
		return query.getResultList();
	}
	
	public void excluir(Long id) {
		Resposta resposta = getEM().getReference(Resposta.class, id);
		getEM().remove(resposta);
	}

}
