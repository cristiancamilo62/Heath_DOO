package co.health.service.mapper.entity.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.support.InformacionAfiliacionPacienteEntity;
import co.health.service.domain.paciente.support.InformacionAfiliacionPacienteDomain;
import co.health.service.mapper.entity.EntityMapper;

public final class InformacionAfiliacionPacienteEntityMapper implements EntityMapper<InformacionAfiliacionPacienteEntity, InformacionAfiliacionPacienteDomain> {

	private static final EntityMapper<InformacionAfiliacionPacienteEntity, InformacionAfiliacionPacienteDomain> instancia = new InformacionAfiliacionPacienteEntityMapper();
	
	private InformacionAfiliacionPacienteEntityMapper() {
		super();
	}
	
	@Override
	public final InformacionAfiliacionPacienteDomain toDomain(final InformacionAfiliacionPacienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el InformacionAfliacionPaciente es nulo en toDomain de la clase InformacionAfiliacionPacienteEntityMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return InformacionAfiliacionPacienteDomain.crear(false, null, null);
	}

	@Override
	public final InformacionAfiliacionPacienteEntity toEntity(final InformacionAfiliacionPacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "el InformacionAfliacionPaciente es nulo en toEntity de la clase InformacionAfiliacionPacienteEntityMapper";//CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return InformacionAfiliacionPacienteEntity.crear(false, null, null);
	}
	
	public static final InformacionAfiliacionPacienteDomain convertToDomain(final InformacionAfiliacionPacienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final InformacionAfiliacionPacienteEntity convertToEntity(final InformacionAfiliacionPacienteDomain domain) {
		return instancia.toEntity(domain);
	}

}
