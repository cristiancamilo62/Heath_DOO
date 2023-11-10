package co.health.service.mapper.entity.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.CitaEntity;
import co.health.service.domain.cita.CitaDomain;
import co.health.service.mapper.entity.EntityMapper;
import co.health.service.mapper.entity.concrete.support.DatosServicioCitaEntityMapper;
import co.health.service.mapper.entity.concrete.support.FechaCitaEntityMapper;
import co.health.service.mapper.entity.concrete.support.NombreCompletoEntityMapper;

public final class CitaEntityMapper implements EntityMapper<CitaEntity, CitaDomain>{

private static final EntityMapper<CitaEntity, CitaDomain> instancia = new CitaEntityMapper();
	
	private CitaEntityMapper() {
		super();
	}
	
	@Override
	public final CitaDomain toDomain(final CitaEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el CitaEntity es nulo en toDomain de la clase PacienteEntityMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return CitaDomain.crear(entity.getId(),DatosServicioCitaEntityMapper.convertToDomain(entity.getDatosServicioCita()),
				FechaCitaEntityMapper.convertToDomain(entity.getFecha()),EstadoCitaEntityMapper.convertToDomain(entity.getEstadoCita())
				,NombreCompletoEntityMapper.convertToDomain(entity.getNombreProfesional()));
	}

	@Override
	public final CitaEntity toEntity(final CitaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el CitaEntity es nulo en toEntity de la clase PacienteEntityMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return CitaEntity.crear(domain.getId(),DatosServicioCitaEntityMapper.convertToEntity(domain.getDatosServicioCita()),
				FechaCitaEntityMapper.convertToEntity(domain.getFecha()),EstadoCitaEntityMapper.convertToEntity(domain.getEstadoCita()),
				NombreCompletoEntityMapper.convertToEntity(domain.getNombreProfesional()));
	}
	
	public static final CitaDomain convertToDomain(final CitaEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final CitaEntity convertToEntity(final CitaDomain domain) {
		return instancia.toEntity(domain);
	}

}	