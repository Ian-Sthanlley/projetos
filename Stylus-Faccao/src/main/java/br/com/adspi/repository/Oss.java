package br.com.adspi.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.adspi.model.Os;

public class Oss implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Os porId (Long id) {
		return manager.find(Os.class, id);
	}
	
	public List<Os> todos() {
		return manager.createQuery("from Os", Os.class).getResultList();
	}
	
	public Os salvar(Os os) {
		return manager.merge(os);
	}
	
	public void excluir(Os os) {
		os = porId(os.getId());
		manager.remove(os);
	}
}
