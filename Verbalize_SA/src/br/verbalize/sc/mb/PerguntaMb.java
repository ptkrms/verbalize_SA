package br.verbalize.sc.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.verbalize.sc.model.entity.Pergunta;
import br.verbalize.sc.model.rn.PerguntaRN;

@ViewScoped
@ManagedBean
public class PerguntaMb {
	private List<Pergunta> listaPergunta;
	private PerguntaRN perguntaRN;
	private Pergunta pergunta;
	private Long editarId;
	

}
