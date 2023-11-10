package co.health.data.entity;

import java.util.UUID;

public class RegimenAfiliacionEntity {

	private UUID id;
	private String tipo;
	private String coberturaServicios;
	
	private RegimenAfiliacionEntity(final UUID id, final String tipo, final String coberturaServicios) {
		setId(id);
		setTipo(tipo);
		setCoberturaServicios(coberturaServicios);
	}
	
	public static final RegimenAfiliacionEntity crear(final UUID id, final String tipo, final String coberturaServicios) {
		return new RegimenAfiliacionEntity(id, tipo, coberturaServicios);
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
