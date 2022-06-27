package br.com.adspi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Column
	private String modelo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoTecido tipo;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoTecido getTipo() {
		return tipo;
	}

	public void setTipo(TipoTecido tipo) {
		this.tipo = tipo;
	}
	
}
