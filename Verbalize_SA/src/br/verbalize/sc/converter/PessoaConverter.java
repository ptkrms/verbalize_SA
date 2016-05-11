package br.verbalize.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.verbalize.sc.model.entity.Pessoa;
import br.verbalize.sc.model.rn.PessoaRN;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		PessoaRN pessoaRN = new PessoaRN();
		Long id = Long.parseLong(value);
		return pessoaRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		Pessoa pessoa = (Pessoa) value;
		return pessoa.getId().toString();
	}
}
