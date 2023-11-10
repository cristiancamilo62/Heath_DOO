package co.health.service.mapper.entity.concrete.support;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.support.NumeroTelefonoPacienteEntity;
import co.health.service.domain.paciente.support.NumeroTelefonoPacienteDomain;
import co.health.service.mapper.entity.EntityMapper;

public final class NumeroTelefonoPacienteEntityMapper  implements EntityMapper<NumeroTelefonoPacienteEntity, NumeroTelefonoPacienteDomain>{

	private static final EntityMapper<NumeroTelefonoPacienteEntity, NumeroTelefonoPacienteDomain> instancia = new NumeroTelefonoPacienteEntityMapper();
	
	private NumeroTelefonoPacienteEntityMapper() {
		super();
	}
	@Override
	public final NumeroTelefonoPacienteDomain toDomain(final NumeroTelefonoPacienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000229);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NumeroTelefonoPacienteDomain.crear(entity.getNumeroTelefono(), false);
	}

	@Override
	public final NumeroTelefonoPacienteEntity toEntity(final NumeroTelefonoPacienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000230);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NumeroTelefonoPacienteEntity.crear(domain.getNumeroTelefono(), false);
	}
	public static final NumeroTelefonoPacienteDomain convertToDomain(final NumeroTelefonoPacienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NumeroTelefonoPacienteEntity convertToEntity(final NumeroTelefonoPacienteDomain domain) {
		return instancia.toEntity(domain);
	}
	
}
