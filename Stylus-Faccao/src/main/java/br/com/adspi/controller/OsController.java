package br.com.adspi.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.adspi.model.Os;
import br.com.adspi.model.TipoTecido;
import br.com.adspi.repository.Oss;
import br.com.adspi.service.OsService;
import br.com.adspi.util.FacesMessages;

@Named
@ViewScoped
public class OsController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Oss oss;
	
	@Inject
	private OsService osService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Os> listOs;
	private Os osEdicao = new Os();
	private Os osSelecionada;
	
	public void carregaOss() {
		listOs = oss.todos();
	}
	
	public void novaOs() {
		osEdicao = new Os();
	}
	
	public void salvar() {
		osService.salvar(osEdicao);
		carregaOss();
		messages.info("Ordem de serviço salva com sucesso!");
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:oss-table"));
	}
	
	public void excluir() {
		osService.excluir(osSelecionada);
		osSelecionada = null;
		carregaOss();
		messages.info("Ordem de serviço excluida com sucesso!");
	}
	
	public List<Os> getTodasOss() {
		return listOs;
	}
	
	public TipoTecido[] getTiposTecido() {
		return TipoTecido.values();
	}
	
	public Os getOsEdicao() {
		return osEdicao;
	}

	public void setOsEdicao(Os osEdicao) {
		this.osEdicao = osEdicao;
	}

	public Os getOsSelecionada() {
		return osSelecionada;
	}

	public void setOsSelecionada(Os osSelecionada) {
		this.osSelecionada = osSelecionada;
	}
}
