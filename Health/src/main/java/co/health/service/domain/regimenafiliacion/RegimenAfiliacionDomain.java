package co.health.service.domain.regimenafiliacion;

import java.util.UUID;

import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;



public final class RegimenAfiliacionDomain {

	private UUID id;
	private String tipo;
	private String coberturaServicios;
	
	public RegimenAfiliacionDomain() {
		setId(UtilUuid.DEFAULT_UUID);
		setTipo(UtilTexto.VACIO);
		setCoberturaServicios(UtilTexto.VACIO);

	}
	
	private RegimenAfiliacionDomain(final UUID id, final String tipo, final String coberturaServicios) {
		setId(id);
		setTipo(tipo);
		setCoberturaServicios(coberturaServicios);
	}
	
	public static final RegimenAfiliacionDomain crear(final UUID id, final String tipo, final String coberturaServicios) {
		return new RegimenAfiliacionDomain(id, tipo, coberturaServicios);
	}
	
	public static final RegimenAfiliacionDomain crear() {
		return new RegimenAfiliacionDomain();
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	private final void setCoberturaServicios(final String coberturaServicios) {
		this.coberturaServicios = coberturaServicios;
	}

	public final UUID getId() {
		return id;
	}

	public final String getTipo() {
		return tipo;
	}

	public final String getCoberturaServicios() {
		return coberturaServicios;
	}
	
}
