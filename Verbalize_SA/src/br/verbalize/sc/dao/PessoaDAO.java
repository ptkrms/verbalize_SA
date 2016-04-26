package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.verbalize.sc.commons.JpaUtil;
import br.verbalize.sc.model.entity.Pessoa;

public class PessoaDAO {
	
	public void salvar(Pessoa pessoa) {
		getEM().merge(pessoa);
	}
	
	public Pessoa buscarPorId(Long id) {
		return getEM().find(Pessoa.class, id);
	}
	
	public List<Pessoa> listarPessoas() {
		Query query = getEM().createQuery("From Pessoa", Pessoa.class);
		return query.getResultList();
	}
	
	public void excluir(Long id) {
		Pessoa pessoa = getEM().getReference(Pessoa.class, id);
		getEM().remove(pessoa);
	}
	
	private EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}
	
}
