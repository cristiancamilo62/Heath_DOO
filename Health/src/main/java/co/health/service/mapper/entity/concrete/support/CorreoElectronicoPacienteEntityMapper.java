package co.health.service.mapper.entity.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.support.CorreoElectronicoPacienteEntity;
import co.health.service.domain.paciente.support.CorreoElectronicoPacienteDomain;
import co.health.service.mapper.entity.EntityMapper;

public final class CorreoElectronicoPacienteEntityMapper implements EntityMapper<CorreoElectronicoPacienteEntity, CorreoElectronicoPacienteDomain>{

	private static final EntityMapper<CorreoElectronicoPacienteEntity, CorreoElectronicoPacienteDomain> instancia = new CorreoElectronicoPacienteEntityMapper();
	
	private CorreoElectronicoPacienteEntityMapper() {
		super();
	}
	
	@Override
	public final CorreoElectronicoPacienteDomain toDomain(final CorreoElectronicoPacienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000223);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return CorreoElectronicoPacienteDomain.crear(entity.getCorreoElectronico(), false);
	}

	@Override
	public final CorreoElectronicoPacienteEntity toEntity(final CorreoElectronicoPacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000224);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return CorreoElectronicoPacienteEntity.crear(domain.getCorreoElectronico(), false);
	}

	public static final CorreoElectronicoPacienteDomain convertToDomain(final CorreoElectronicoPacienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final CorreoElectronicoPacienteEntity convertToEntity(final CorreoElectronicoPacienteDomain domain) {
		return instancia.toEntity(domain);
	}
}
