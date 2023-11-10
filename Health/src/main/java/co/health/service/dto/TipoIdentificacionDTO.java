package co.health.service.dto;

import java.util.UUID;

import co.health.crosscutting.util.UtilObjeto;
import co.health.crosscutting.util.UtilTexto;
import co.health.crosscutting.util.UtilUuid;

public class TipoIdentificacionDTO {

	private UUID id;
	private String codigo;
	private String nombre;
	
	public TipoIdentificacionDTO() {
		setId(UtilUuid.DEFAULT_UUID);
		setCodigo(UtilTexto.VACIO);
		setNombre(UtilTexto.VACIO);
	}
	
	public TipoIdentificacionDTO(final UUID id, final String codigo, final String nombre) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static final TipoIdentificacionDTO crear(final UUID id, final String codigo, final String nombre) {
		return new TipoIdentificacionDTO(id, codigo, nombre);
	}
	
	public static final TipoIdentificacionDTO crear() {
		return new TipoIdentificacionDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDTO setId(final UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
		return this;
	}
	public final String getCodigo() {
		return codigo;
	}
	public final TipoIdentificacionDTO setCodigo(final String codigo) {
		this.codigo = UtilTexto.aplicarTrim(codigo);
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final TipoIdentificacionDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
	
	
}
