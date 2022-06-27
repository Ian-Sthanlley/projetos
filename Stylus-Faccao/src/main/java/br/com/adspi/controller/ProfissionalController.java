package br.com.adspi.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.adspi.model.Profissional;
import br.com.adspi.model.TipoTecido;
import br.com.adspi.repository.Profissionais;
import br.com.adspi.service.ProfissionalService;
import br.com.adspi.util.FacesMessages;

@Named
@ViewScoped
public class ProfissionalController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Profissionais profissionais;
	
	@Inject
	private ProfissionalService profissionalService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Profissional> listProfissional;
	private Profissional profissionalEdicao = new Profissional();
	private Profissional profissionalSelecionado;
	
	public void carregaProfissionais() {
		listProfissional = profissionais.todos();
	}
	
	public void novoProfissional() {
		profissionalEdicao = new Profissional();
	}
	
	public void salvar() {
		profissionalService.salvar(profissionalEdicao);
		carregaProfissionais();
		messages.info("Profissional salvo com sucesso!");
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:profissionais-table"));
	}
	
	public void excluir() {
		profissionalService.excluir(profissionalSelecionado);
		profissionalSelecionado = null;
		carregaProfissionais();
		messages.info("Profissional excluido com sucesso!");
	}
	public List<Profissional> getTodosProfissionais() {
		return listProfissional;
	}
	
	public TipoTecido[] getTiposTecido() {
		return TipoTecido.values();
	}

	public Profissional getProfissionalEdicao() {
		return profissionalEdicao;
	}

	public void setProfissionalEdicao(Profissional profissionalEdicao) {
		this.profissionalEdicao = profissionalEdicao;
	}

	public Profissional getProfissionalSelecionado() {
		return profissionalSelecionado;
	}

	public void setProfissionalSelecionado(Profissional profissionalSelecionado) {
		this.profissionalSelecionado = profissionalSelecionado;
	}
}
