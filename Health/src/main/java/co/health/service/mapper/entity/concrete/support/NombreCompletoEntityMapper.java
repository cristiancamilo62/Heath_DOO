package co.health.service.mapper.entity.concrete.support;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.entity.support.NombreCompletoEntity;
import co.health.service.domain.paciente.support.NombreCompletoDomain;
import co.health.service.mapper.entity.EntityMapper;

public final class NombreCompletoEntityMapper implements EntityMapper<NombreCompletoEntity, NombreCompletoDomain> {


	private static final EntityMapper<NombreCompletoEntity, NombreCompletoDomain> instancia = new NombreCompletoEntityMapper();
	
	private NombreCompletoEntityMapper() {
		super();
	}
	
	@Override
	public final NombreCompletoDomain toDomain(final NombreCompletoEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000227);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoDomain.crear(entity.getPrimerNombre(), entity.getSegundoNombre(), entity.getPrimerApellido(), entity.getSegundoApellido());
	}

	@Override
	public final NombreCompletoEntity toEntity(final NombreCompletoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000228);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoEntity.crear(domain.getPrimerNombre(), domain.getSegundoNombre(), domain.getPrimerApellido(), domain.getSegundoApellido());
	}
	
	public static final NombreCompletoDomain convertToDomain(final NombreCompletoEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NombreCompletoEntity convertToEntity(final NombreCompletoDomain domain) {
		return instancia.toEntity(domain);
	}

}
