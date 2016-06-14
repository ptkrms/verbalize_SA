package br.verbalize.sc.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.verbalize.sc.model.entity.Perfil;
import br.verbalize.sc.model.entity.Pessoa;
import br.verbalize.sc.model.rn.PessoaRN;

@SessionScoped
@ManagedBean
public class SessaoMb {

	private String emailForm;
	private String senhaForm;
	private Pessoa usuarioLogado;

	public String getEmailForm() {
		return emailForm;
	}

	public void setEmailForm(String emailForm) {
		this.emailForm = emailForm;
	}

	public String getSenhaForm() {
		return senhaForm;
	}

	public void setSenhaForm(String senhaForm) {
		this.senhaForm = senhaForm;
	}

	public boolean estaLogado() {
		return usuarioLogado != null;
	}

	public boolean ehAdmin() {
		return usuarioLogado != null
				&& usuarioLogado.getPerfil().equals(Perfil.ADMIN);
	}
	
	public boolean ehProfessor() {
		return usuarioLogado != null
				&& usuarioLogado.getPerfil().equals(Perfil.PROFESSOR);
	}
	
	public boolean ehAluno() {
		return usuarioLogado != null
				&& usuarioLogado.getPerfil().equals(Perfil.ALUNO);
	}

	public String getNomeUsuarioLogado() {
		return usuarioLogado == null ? "" : usuarioLogado.getNmPessoa();
	}

	public String sair() {
		usuarioLogado = null;
		return "/index?faces-redirect=true";
	}

	public String entrar() {
		PessoaRN pessoaRN = new PessoaRN();
		Pessoa pessoa = pessoaRN.buscarPorEmail(emailForm);

		if (pessoa == null || !pessoa.getEmail().equalsIgnoreCase(emailForm)
				|| !pessoa.getSenha().equals(senhaForm)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("E-mail ou senha não confere."));
			return "";
		}

		usuarioLogado = pessoa;

		if (ehAdmin()) {
			return "/admin/admin?faces-redirect=true";
		}
		
		if (ehProfessor()) {
			return "/professor/portalProfessor?faces-redirect=true";
		}
		
		if (ehAluno()) {
			return "/aluno/portalAluno?faces-redirect=true";
		}
			return"";

	}

}