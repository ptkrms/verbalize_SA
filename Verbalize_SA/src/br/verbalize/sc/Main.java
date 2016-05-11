package br.verbalize.sc;

//import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PessimisticLockScope;

import br.verbalize.sc.model.entity.Pessoa;
import br.verbalize.sc.model.entity.Perfil;


public class Main {
	
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("Verbalize_SA");
		
		adicionarAdministrador();
		adicionarAluno();
		adicionarProfessor();
//		alterarAluno();
//		buscarAlunoPorId();
//		removerAlunoPorId();
		
		emf.close();

	}
	
	private static void adicionarAluno() {
		Pessoa aluno = new Pessoa();
		aluno.setNmPessoa("Moacir");
		aluno.setEmail("moacir@xvideos.com");
		aluno.setNuCpf("12121212121212");
		aluno.setTelefone("999999999");
//		aluno.setDtNascimento(Calendar.getInstance().getTime());
		aluno.setSenha("1234");
//		aluno.setPerfil();
//		aluno.setTpPermissao(3);
//		aluno.setDtCadastro(Calendar.getInstance().getTime());
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(aluno);
		
		em.getTransaction().commit();
		em.close();
	}
	
	private static void adicionarProfessor() {
		Pessoa professor = new Pessoa();
		professor.setNmPessoa("Tânia");
		professor.setEmail("tania@abtn.com");
		professor.setNuCpf("81818181818181");
		professor.setTelefone("5656565656");
//		professor.setDtNascimento(Calendar.getInstance().getTime());
		professor.setSenha("9999");
//		professor.setPerfil();
//		professor.setTpPermissao(2);
//		professor.setDtCadastro(Calendar.getInstance().getTime());
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(professor);
		
		em.getTransaction().commit();
		em.close();
	}
	
	private static void adicionarAdministrador() {
		Pessoa administrador = new Pessoa();
		administrador.setNmPessoa("Jefferson");
		administrador.setEmail("jlima004@gmail.com");
		administrador.setNuCpf("69696969696969");
		administrador.setTelefone("4545454545");
//		administrador.setDtNascimento(Calendar.getInstance().getTime());
		administrador.setSenha("1234");
//		administrador.setPerfil();
//		administrador.setTpPermissao(1);
//		administrador.setDtCadastro(Calendar.getInstance().getTime());
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(administrador);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	private static void alterarAluno() {
		Pessoa aluno = new Pessoa();
		aluno.setId(2L);
		aluno.setNmPessoa("Moacir");
		aluno.setEmail("moacir@senai.com");
		aluno.setNuCpf("12121212121212");
//		aluno.setDtNascimento(Calendar.getInstance().getTime());
		aluno.setSenha("1234");
//		aluno.setPerfil();
//		aluno.setTpPermissao(3);
//		aluno.setDtCadastro(Calendar.getInstance().getTime());
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(aluno);
		
		em.getTransaction().commit();
		em.close();
	}
	
	private static void buscarAlunoPorId() {
		Long id = 2L;
		
		EntityManager em = emf.createEntityManager();
		
		Pessoa aluno = em.find(Pessoa.class, id);
		
		em.close();
		
		System.out.println("Nome: " + aluno.getNmPessoa());
		System.out.println("Email: " + aluno.getEmail());
		System.out.println("--------------------------------------");
	}
	
	private static void removerAlunoPorId() {
		Long id = 1L;
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Pessoa aluno = em.getReference(Pessoa.class, id);
		em.remove(aluno);
		
		em.getTransaction().commit();
		em.close();
	}

}
