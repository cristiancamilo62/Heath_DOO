package co.health.service.mapper.entity.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.support.ContactoPacienteEntity;
import co.health.service.domain.paciente.support.ContactoPacienteDomain;
import co.health.service.mapper.entity.EntityMapper;

public final class ContactoPacienteEntityMapper implements EntityMapper<ContactoPacienteEntity, ContactoPacienteDomain>{

	private static final EntityMapper<ContactoPacienteEntity, ContactoPacienteDomain> instancia = new ContactoPacienteEntityMapper();
	
	private ContactoPacienteEntityMapper() {
		super();
	}
	
	@Override
	public final ContactoPacienteDomain toDomain(final ContactoPacienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000221);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ContactoPacienteDomain.crear(CorreoElectronicoPacienteEntityMapper.convertToDomain(entity.getCorreoElectronicoPaciente()),
				NumeroTelefonoPacienteEntityMapper.convertToDomain(entity.getNumeroTelefonoPaciente()),entity.getContrasenia());
	}

	@Override
	public final ContactoPacienteEntity toEntity(final ContactoPacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000222);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ContactoPacienteEntity.crear(CorreoElectronicoPacienteEntityMapper.convertToEntity(domain.getCorreoElectronicoPaciente()),
				NumeroTelefonoPacienteEntityMapper.convertToEntity(domain.getNumeroTelefonoPaciente()),domain.getContrasenia());
	}
	
	public static final ContactoPacienteDomain convertToDomain(final ContactoPacienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final ContactoPacienteEntity convertToEntity(final ContactoPacienteDomain domain) {
		return instancia.toEntity(domain);
	}

}
