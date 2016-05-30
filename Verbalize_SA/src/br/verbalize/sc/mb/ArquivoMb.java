package br.verbalize.sc.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.Part;

import br.verbalize.sc.commons.UploadUtil;
import br.verbalize.sc.model.entity.Arquivo;
import br.verbalize.sc.model.entity.Turma;
import br.verbalize.sc.model.rn.ArquivoRN;
import br.verbalize.sc.model.rn.TurmaRN;

@ManagedBean(name="arquivoMb")
public class ArquivoMb {
	
	private Long turmaId;
	private Turma turma;
	private Part arquivoUploaded;
	private Arquivo arquivo;
	private List<Arquivo> arquivos;
	private ArquivoRN arquivoRN;
	private TurmaRN turmaRN;
	
	@PostConstruct
	public void init(){
		turmaRN = new TurmaRN();
		arquivoRN = new ArquivoRN();
		arquivo = new Arquivo();
	}

	public Long getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Part getArquivoUploaded() {
		return arquivoUploaded;
	}

	public void setArquivoUploaded(Part arquivoUploaded) {
		this.arquivoUploaded = arquivoUploaded;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}
	
	public void carregarTurma() {
		turma = turmaRN.buscaPorId(turmaId);
	}
	
	public void excluir(AjaxBehaviorEvent event) {
		
		Long idArquivo = (Long) event.getComponent().getAttributes().get("idArquivo");
		
		Arquivo arq = arquivoRN.buscarArquivoPorId(idArquivo);
		
		UploadUtil.removerArquivo(arq.getNome());
		arquivoRN.excluir(arq);
		
		arquivos = null;
		
	}
	
	public String salvar() {
		
		try {
			String nome = UploadUtil.moverArquivo(arquivoUploaded, arquivo.getNome());
			
			arquivo.setNome(nome);
			arquivo.setTurma(turma);
			
			arquivoRN.adicionar(arquivo);
			
			return "/ava?idturma=" + turma.getId().toString() + "&faces-redirect=true";
			
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
}
