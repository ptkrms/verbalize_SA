package br.verbalize.sc.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.verbalize.sc.model.entity.Arquivo;
import br.verbalize.sc.model.rn.ArquivoRN;

@FacesConverter(forClass=Arquivo.class)
public class ArquivoConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String valor) {
		
		if( valor == null || valor.isEmpty()) {
			
		return new Arquivo();
		}
		
		Long id = Long.parseLong(valor);
		ArquivoRN arquivoRN = new ArquivoRN();
		Arquivo arquivo = arquivoRN.buscarArquivoPorId(id);
		return arquivo;
	}
	
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object valor) {
		Arquivo arquivo = (Arquivo) valor;
		return arquivo.getId() == null ? "" : arquivo.getId().toString();
	}

}
