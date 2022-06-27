package br.com.adspi.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.adspi.model.Os;
import br.com.adspi.repository.Oss;
import br.com.adspi.util.Transacional;

public class OsService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Oss oss;

	@Transacional
	public void salvar(Os os) {
		oss.salvar(os);
	}
	
	@Transacional
	public void excluir(Os os) {
		oss.excluir(os);
	}

}
