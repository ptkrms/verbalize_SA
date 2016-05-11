package br.verbalize.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.verbalize.sc.model.entity.Turma;

public class TurmaDAO extends DAO {
	
	public List<Turma> Listar() {
		Query query = getEM().createQuery("From Turma", Turma.class);
		return (query).getResultList();
	}
	
	public void salvar(Turma turma)throws SQLException {
		getEM().merge(turma);
	}

}
