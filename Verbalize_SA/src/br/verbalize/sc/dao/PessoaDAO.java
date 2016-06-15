package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.verbalize.sc.model.entity.Perfil;
import br.verbalize.sc.model.entity.Pessoa;

public class PessoaDAO extends DAO {

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

	public List<Pessoa> listarProfessores() {
		Query query = getEM().createQuery(
				"From Pessoa u Where u.perfil = :perfil", Pessoa.class);
		query.setParameter("perfil", Perfil.PROFESSOR);

		return query.getResultList();
	}

	public void excluir(Long id) {
		Pessoa pessoa = getEM().getReference(Pessoa.class, id);
		getEM().remove(pessoa);
	}
	
	public Pessoa buscaPorEmail(String email) {
		Query query = getEM().createQuery(
				"From Pessoa u Where u.email = :email", Pessoa.class);
		query.setParameter("email", email);
		
		try {
			return (Pessoa) query.getSingleResult();
			
		} catch (NoResultException exception) {
			return null;
		}
	}
	
}
