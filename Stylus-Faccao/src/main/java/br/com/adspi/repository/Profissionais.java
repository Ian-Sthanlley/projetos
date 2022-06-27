package br.com.adspi.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.adspi.model.Profissional;

public class Profissionais implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Profissional porId (Long id) {
		return manager.find(Profissional.class, id);
	}
	
	public List<Profissional> todos() {
		return manager.createQuery("from Profissional", Profissional.class).getResultList();
	}
	
	public Profissional salvar(Profissional profissional) {
		return manager.merge(profissional);
	}
	
	public void excluir(Profissional profissional) {
		profissional = porId(profissional.getId());
		manager.remove(profissional);
	}
}
