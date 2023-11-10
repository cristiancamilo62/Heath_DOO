package co.health.service.mapper.entity.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.EstadoCitaEntity;
import co.health.data.entity.support.DatosServicioCitaEntity;
import co.health.service.domain.cita.support.DatosServicioCitaDomain;
import co.health.service.domain.estadocita.EstadoCitaDomain;
import co.health.service.mapper.entity.EntityMapper;

public final class DatosServicioCitaEntityMapper implements EntityMapper<DatosServicioCitaEntity, DatosServicioCitaDomain>{

private static final EntityMapper<DatosServicioCitaEntity, DatosServicioCitaDomain> instancia = new DatosServicioCitaEntityMapper();
	
	private DatosServicioCitaEntityMapper() {
		super();
	}
	
	@Override
	public final DatosServicioCitaDomain toDomain(final DatosServicioCitaEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el DatosServicioCitaEntity es nulo en toDomain de la clase PacienteEntityMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return DatosServicioCitaDomain.crear(entity.getCodigo(),entity.getConsultorio(),entity.getNombreServicio(),
				entity.getPrecio());
	}

	@Override
	public final DatosServicioCitaEntity toEntity(final DatosServicioCitaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el DatosServicioCitaEntity es nulo en toEntity de la clase PacienteEntityMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return DatosServicioCitaEntity.crear(domain.getCodigo(),domain.getConsultorio(),domain.getNombreServicio(),
				domain.getPrecio());
	}
	
	public static final DatosServicioCitaDomain convertToDomain(final DatosServicioCitaEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final DatosServicioCitaEntity convertToEntity(final DatosServicioCitaDomain domain) {
		return instancia.toEntity(domain);
	}
}
