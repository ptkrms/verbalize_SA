package br.verbalize.sc.model.rn;

import java.util.List;

import br.verbalize.sc.dao.ArquivoDAO;
import br.verbalize.sc.model.entity.Arquivo;

public class ArquivoRN {
	
	private ArquivoDAO dao;
	
	public ArquivoRN() {
		dao = new ArquivoDAO();
	}
	
	public void adicionar(Arquivo arquivo) {
		dao.salvar(arquivo);
	}
	
	public List<Arquivo> listarArquivosPorTurma(Long idTurma) {
		return dao.listarArquivoPorTurma(idTurma);
	}
	
	public Arquivo buscarArquivoPorId(Long idArquivo) {
		return dao.buscarArquivoPorId(idArquivo);
	}
	
	public void excluir(Arquivo arquivo) {
		dao.excluir(arquivo);
	}

}
