package br.com.adspi.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.adspi.model.Profissional;
import br.com.adspi.repository.Profissionais;
import br.com.adspi.util.Transacional;

public class ProfissionalService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Profissionais profissionais;
	
	@Transacional
	public void salvar(Profissional profissional) {
		profissionais.salvar(profissional);
	}
	
	@Transacional
	public void excluir(Profissional profissional) {
		profissionais.excluir(profissional);
	}

}
