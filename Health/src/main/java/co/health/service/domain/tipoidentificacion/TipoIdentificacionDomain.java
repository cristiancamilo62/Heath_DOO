package co.health.service.domain.tipoidentificacion;

import java.util.UUID;

import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;

public class TipoIdentificacionDomain {

	private UUID id;
	private String codigo;
	private String nombre;
	
	public TipoIdentificacionDomain() {
		setId(UtilUuid.generarNuevoUuid());
		setCodigo(UtilTexto.VACIO);
		setNombre(UtilTexto.VACIO);
	}
	
	private TipoIdentificacionDomain(final UUID id, final String codigo, final String nombre) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static final TipoIdentificacionDomain crear(final UUID id, final String codigo, final String nombre) {
		return new TipoIdentificacionDomain(id, codigo, nombre);
	}
	
	public static final TipoIdentificacionDomain crear() {
		return new TipoIdentificacionDomain();
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public final UUID getId() {
		return id;
	}

	public final String getCodigo() {
		return codigo;
	}

	public final String getNombre() {
		return nombre;
	}

}
