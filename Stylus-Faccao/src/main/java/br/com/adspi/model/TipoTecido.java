package br.com.adspi.model;

public enum TipoTecido {
	MALHA("Malha"), 
	JEANS("Jeans"),
	BRIM("Brim"),
	PLANO("Plano");
	
	private String descricao;

	TipoTecido(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
