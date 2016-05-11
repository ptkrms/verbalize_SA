package br.verbalize.sc.model.rn;

import java.sql.SQLException;
import java.util.List;

import br.verbalize.sc.dao.TurmaDAO;
import br.verbalize.sc.model.entity.Turma;
import br.verbalize.sc.model.entity.Perfil;

public class TurmaRN {

	private TurmaDAO dao;
	
	public TurmaRN() {
		dao = new TurmaDAO();
	}
	
	public List<Turma> listar() {
		return dao.Listar();
	}
	 
	public void salvar(Turma turma) throws IllegalArgumentException,Exception {
		if(turma.getProfessor() == null) {
			throw new IllegalArgumentException("É preciso selecionar um Professor");
		}
		if(!turma.getProfessor().getPerfil().equals(Perfil.PROFESSOR)){
			throw new IllegalArgumentException("É preciso selecionar um Professor");
		}
		
		try {
			dao.salvar(turma);
		} catch (SQLException e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
	}
	
}
