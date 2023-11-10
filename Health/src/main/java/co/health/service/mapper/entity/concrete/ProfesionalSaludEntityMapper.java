package co.health.service.mapper.entity.concrete;


import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.ProfesionalSaludEntity;
import co.health.service.domain.profesionalsalud.ProfesionalSaludDomain;
import co.health.service.mapper.entity.EntityMapper;
import co.health.service.mapper.entity.concrete.support.NombreCompletoEntityMapper;
import co.health.service.mapper.entity.concrete.support.TipoServicioEntityMapper;

public final class ProfesionalSaludEntityMapper implements EntityMapper<ProfesionalSaludEntity, ProfesionalSaludDomain>{

	private static final EntityMapper<ProfesionalSaludEntity, ProfesionalSaludDomain> instancia = new ProfesionalSaludEntityMapper();
	
	private ProfesionalSaludEntityMapper() {
		super();
	}
	
	@Override
	public final ProfesionalSaludDomain toDomain(final ProfesionalSaludEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico =CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000237);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ProfesionalSaludDomain.crear(entity.getId(), entity.getNumeroIdentificacion(), NombreCompletoEntityMapper.convertToDomain(entity.getNombreCompletoProfesionalSalud()),
				TipoServicioEntityMapper.convertToDomain(entity.getServicio()),TipoIdentificacionEntityMapper.convertToDomain(entity.getTipoIdentificacion()));
	}

	@Override
	public final ProfesionalSaludEntity toEntity(final ProfesionalSaludDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000238);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ProfesionalSaludEntity.crear(domain.getId(), domain.getNumeroIdentificacion(), NombreCompletoEntityMapper.convertToEntity(domain.getNombreCompletoProfesionalSalud()),
				TipoServicioEntityMapper.convertToEntity(domain.getServicio()),TipoIdentificacionEntityMapper.convertToEntity(domain.getTipoIdentificacion()));
	}
	
	public static final ProfesionalSaludDomain convertToDomain(final ProfesionalSaludEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final ProfesionalSaludEntity convertToEntity(final ProfesionalSaludDomain domain) {
		return instancia.toEntity(domain);
	}

}
