package co.health.service.dto;

import java.util.UUID;

import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;

public final class RegimenAfiliacionDTO {
	
	private UUID id;
	private String tipo;
	private String coberturaServicios;
	
	public RegimenAfiliacionDTO() {
		setId(UtilUuid.DEFAULT_UUID);
		setTipo(UtilTexto.VACIO);
		setCoberturaServicios(UtilTexto.VACIO);
	}
	
	public RegimenAfiliacionDTO(final UUID id, final String tipo, final String coberturaServicios) {
		setId(id);
		setTipo(tipo);
		setCoberturaServicios(coberturaServicios);
	}
	
	public static final RegimenAfiliacionDTO crear(final UUID id, final String tipo, final String coberturaServicios) {
		return new RegimenAfiliacionDTO(id, tipo, coberturaServicios);
	}
	
	public static final RegimenAfiliacionDTO crear() {
		return new RegimenAfiliacionDTO();
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = id;
	}

	public final String getTipo() {
		return tipo;
	}

	public final void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public final String getCoberturaServicios() {
		return coberturaServicios;
	}

	public final void setCoberturaServicios(String coberturaServicios) {
		this.coberturaServicios = coberturaServicios;
	}
	
	
	

}
