package co.health.service.dto.support;

import co.health.crosscutting.util.UtilLong;
import co.health.crosscutting.util.UtilTexto;

public class DatosServicioCitaDTO {
	
	private String codigo;
	private String consultorio;
	private String nombreServicio;
	private long precio;
	
	
	public DatosServicioCitaDTO() {
		setCodigo(UtilTexto.VACIO);
		setConsultorio(UtilTexto.VACIO);
		setNombreServicio(UtilTexto.VACIO);
		setPrecio(UtilLong.DEFAULT_LONG);
	}
	public DatosServicioCitaDTO(final String codigo,final String consultorio, final String nombreServicio, 
			final long precio) {
		setCodigo(codigo);
		setConsultorio(consultorio);
		setNombreServicio(nombreServicio);
		setPrecio(precio);
	}
	
	public static final DatosServicioCitaDTO crear(final String codigo,final String consultorio, final String nombreServicio, 
			final long precio) {
		return new DatosServicioCitaDTO();
	}

	public final String getConsultorio() {
		return consultorio;
	}

	public final String getNombreServicio() {
		return nombreServicio;
	}

	public final long getPrecio() {
		return precio;
	}
	
	public final String getCodigo() {
		return codigo;
	}

	private final void setConsultorio(final String consultorio) {
		this.consultorio = consultorio;
	}

	private final void setNombreServicio(final String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	private final void setPrecio(final long precio) {
		this.precio = precio;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

}

