package br.verbalize.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.verbalize.sc.model.entity.Turma;
import br.verbalize.sc.model.rn.TurmaRN;

@ManagedBean
public class TurmaMb {
	private List<Turma> listaTurma;
	private TurmaRN turmaRN;
	private Turma turma;
	private Long editarId;
	
	@PostConstruct
	public void init() {
		turmaRN = new TurmaRN();
		turma = new Turma();
	}
	
	public List<Turma> getListaTurma() {
		if (listaTurma == null) {
			listaTurma = turmaRN.listar();
		}
		return listaTurma;
	}
	
	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public String salvar() throws Throwable {
		try {
			turmaRN.salvar(turma);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
							"Salvo com sucesso."));
			return "/turmaList";
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
	
	public void carregarTurma(ComponentSystemEvent event) {
		if(editarId == null) {
			return ;
		}
		turma = turmaRN.buscaPorId(editarId);
	}
	
	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		turmaRN.excluir(idExcluir);
		listaTurma = null;
		return "";
	}
	
}
