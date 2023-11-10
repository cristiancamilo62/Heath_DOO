package co.health.service.mapper.entity.concrete;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.PacienteEntity;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.mapper.entity.EntityMapper;
import co.health.service.mapper.entity.concrete.support.ContactoPacienteEntityMapper;
import co.health.service.mapper.entity.concrete.support.InformacionAfiliacionPacienteEntityMapper;
import co.health.service.mapper.entity.concrete.support.NombreCompletoEntityMapper;

public final class PacienteEntityMapper implements EntityMapper<PacienteEntity, PacienteDomain>{

	private static final EntityMapper<PacienteEntity, PacienteDomain> instancia = new PacienteEntityMapper();
	
	private PacienteEntityMapper() {
		super();
	}
	
	@Override
	public final PacienteDomain toDomain(final PacienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000235);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return PacienteDomain.crear(entity.getId(),entity.getNumeroIdentificacion(), NombreCompletoEntityMapper.convertToDomain(entity.getNombreCompletoPaciente()),
				ContactoPacienteEntityMapper.convertToDomain(entity.getContactoPaciente()), entity.getFechaNacimiento(), TipoIdentificacionEntityMapper.convertToDomain(entity.getTipoIdentificacion()), InformacionAfiliacionPacienteEntityMapper.convertToDomain(entity.getInformacionAfiliacionPaciente()));
	}

	@Override
	public final PacienteEntity toEntity(final PacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000236);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return PacienteEntity.crear(domain.getId(),domain.getNumeroIdentificacion(), NombreCompletoEntityMapper.convertToEntity(domain.getNombreCompletoPaciente()),
				ContactoPacienteEntityMapper.convertToEntity(domain.getContactoPaciente()), domain.getFechaNacimiento(), TipoIdentificacionEntityMapper.convertToEntity(domain.getTipoIdentificacion()), InformacionAfiliacionPacienteEntityMapper.convertToEntity(domain.getInformacionAfiliacionPaciente()));
	}
	
	public static final PacienteDomain convertToDomain(final PacienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final PacienteEntity convertToEntity(final PacienteDomain domain) {
		return instancia.toEntity(domain);
	}

}
