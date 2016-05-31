package br.verbalize.sc.dao;

import java.util.List;

import javax.persistence.Query;

import br.verbalize.sc.model.entity.Arquivo;

public class ArquivoDAO extends DAO {

	public void salvar(Arquivo arquivo) {
		getEM().merge(arquivo);
	}

	public List<Arquivo> listarArquivosPorTurma(Long turmaId) {
		Query query = getEM().createQuery(
				"From Arquivo i Where i.turma.id = :turmaId ", Arquivo.class);
		query.setParameter("turmaId", turmaId);
		return query.getResultList();
	}
	
	public Arquivo buscarArquivoPorId(Long idArquivo) {
		return getEM().find(Arquivo.class, idArquivo);
	}
	
	public void excluir(Arquivo arquivo) {
		getEM().remove(arquivo);
	}
	
	
}
