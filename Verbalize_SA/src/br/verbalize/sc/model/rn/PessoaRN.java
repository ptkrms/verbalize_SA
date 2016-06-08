package br.verbalize.sc.model.rn;

import java.util.List;

import br.verbalize.sc.dao.PessoaDAO;
import br.verbalize.sc.model.entity.Pessoa;

public class PessoaRN {
	
	private PessoaDAO dao;
	
	public PessoaRN() {
		dao = new PessoaDAO();
	}
	
	public void salvar(Pessoa pessoa) {
		dao.salvar(pessoa);
	}
	
	public Pessoa buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}
	
	public List<Pessoa> listarPessoas() {
		return dao.listarPessoas();
	}
	
	public List<Pessoa> ListarProfessores() {
		return dao.listarProfessores();
	}
	
	public void excluir(Long id) {
		dao.excluir(id);
	}
	
	public Pessoa buscarPorEmail(String email) {
		return dao.buscaPorEmail(email);
	}
	
}
