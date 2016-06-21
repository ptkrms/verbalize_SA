package br.verbalize.sc.model.rn;

import java.util.List;

import br.verbalize.sc.dao.RespostaDAO;
import br.verbalize.sc.model.entity.Resposta;

public class RespostaRN {
	
	private RespostaDAO dao;
	
	public RespostaRN() {
		dao = new RespostaDAO();
	}
	
	public void salvar(Resposta resposta) {
		dao.salvar(resposta);
	}
	
	public Resposta buscarPorId(Long id) {
		return dao.buscarPorid(id);
	}
	
	public List<Resposta> listarRespostas() {
		return dao.listarRespostas();
	}
	
	public void excluir(Long id) {
		dao.excluir(id);
	}

}
