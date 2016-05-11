package br.verbalize.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.verbalize.sc.model.entity.Turma;
import br.verbalize.sc.model.rn.TurmaRN;

@ManagedBean
public class TurmaMb {
	
	private List<Turma> listaTurmas;
	private TurmaRN turmaRN;
	private Turma turma;
	
	@PostConstruct
	public void init() {
		turmaRN = new TurmaRN();
		turma = new Turma();
	}
	
	public List<Turma> getListaTurma() {
		if (listaTurmas == null) {
			listaTurmas = turmaRN.listar();
		}
		return listaTurmas;
	}
	
	public void setListaTurma(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public String salvar() throws Throwable {
		try {
			turmaRN.salvar(turma);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
							"Salvo com sucesso."));
			return "/turmas";
		} catch (IllegalArgumentException exception) {
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
							exception.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
							e.getMessage()));
		}
		return "";
	}
	
}
