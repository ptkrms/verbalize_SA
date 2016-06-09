package br.verbalize.sc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
//import javax.faces.event.ComponentSystemEvent;




import br.verbalize.sc.commons.UploadUtil;
import br.verbalize.sc.model.entity.Arquivo;
import br.verbalize.sc.model.rn.ArquivoRN;
import br.verbalize.sc.model.entity.Pessoa;
import br.verbalize.sc.model.entity.Turma;
import br.verbalize.sc.model.rn.TurmaRN;

@ViewScoped
@ManagedBean(name="turmaMb")
public class TurmaMb {
	private List<Turma> listaTurma;
	private TurmaRN turmaRN;
	private Turma turma;
	private Long editarId;
	private Pessoa alunoSelecionado;
	private ArquivoRN arquivoRN;
	private Arquivo arquivoDaTurma;
	private List<Arquivo> arquivos;

	@PostConstruct
	public void init() {
		turmaRN = new TurmaRN();
		turma = new Turma();
		arquivoRN = new ArquivoRN();
		arquivoDaTurma = new Arquivo();
		turma.setAlunosParaMatricular(new ArrayList<Pessoa>());
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

	public Pessoa getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Pessoa alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
	
	public TurmaRN getTurmaRN() {
		return turmaRN;
	}

	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}

	public Arquivo getArquivoDaTurma() {
		return arquivoDaTurma;
	}

	public void setArquivoDaTurma(Arquivo arquivoDaTurma) {
		this.arquivoDaTurma = arquivoDaTurma;
	}
	

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}
	
	public List<Arquivo> getArquivos() {
		if(arquivos == null && turma != null){
			arquivos = arquivoRN.listarArquivosPorTurma(turma.getId());
		}
		
		return arquivos;
	}


	public String salvar() throws Throwable {
		try {
			turmaRN.salvar(turma);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
							"Salvo com sucesso."));
			return "/admin/turmaList";
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
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e
							.getMessage()));
		}
		return "";
	}

	/*public void carregarTurma(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}
		turma = turmaRN.buscaPorId(editarId);
	}*/

	public String excluir(String idParam) {
		Long id = Long.parseLong(idParam);
		turmaRN.excluir(id);
		listaTurma = null;
		return "";
	}

	public void carregarEdicao() {
		if (editarId != null &&  
				!FacesContext.getCurrentInstance()
				.getPartialViewContext().isAjaxRequest()) {
			turma = turmaRN.buscaPorId(editarId);
		}
	}

	public void matricularAluno(AjaxBehaviorEvent event) {
		if (turma.getAlunosParaMatricular().contains(alunoSelecionado)) {
			return;
		}
		turma.getAlunosParaMatricular().add(alunoSelecionado);
		alunoSelecionado = null;
	}

	public void excluirMatricula(AjaxBehaviorEvent event) {
		Pessoa aluno = (Pessoa) event.getComponent().getAttributes()
				.get("idAluno");
		turma.getAlunosParaMatricular().remove(aluno);
	}
	
	
	
	public void excluirArquivo(AjaxBehaviorEvent event) {
		
		Long idArquivo = (Long) event.getComponent().getAttributes().get("idArquivo");
		
		Arquivo arq = arquivoRN.buscarArquivoPorId(idArquivo);
		
		UploadUtil.removerArquivo(arq.getNome());
		arquivoRN.excluir(arq);
		
		arquivos = null;
		
	}
	

}
