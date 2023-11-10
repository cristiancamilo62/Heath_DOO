package co.health.service.businesslogic.concrete.tipoidentificacion;

import java.util.Optional;
import java.util.UUID;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.dao.TipoIdentificacionDAO;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.entity.TipoIdentificacionEntity;
import co.health.service.businesslogic.UseCase;
import co.health.service.businesslogic.validator.concrete.tipoidentificacion.RegistrarTipoIdentificacionValidator;
import co.health.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.health.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class RegistrarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain>{
	
	private DAOFactory factoria;

	public RegistrarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	public final void execute(TipoIdentificacionDomain domain) {

		RegistrarTipoIdentificacionValidator.ejecutarValidacion(domain);
		
		validarNoexistenciaTipoIdentificacionConMismoCodigo(domain.getCodigo());
		
		validarNoexistenciaTipoIdentificacionConMismoNombre(domain.getNombre());
		
		domain = obtenerIdentificadorTipoIdentificacion(domain);
		
		registrarNuevoTipoIdentificacion(domain);
		
	}
	
	
	private void registrarNuevoTipoIdentificacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().registrar(entity);
	}

	private final void validarNoexistenciaTipoIdentificacionConMismoNombre(final String nombre) {
	    var entity = crearTipoIdentificacionEntityNombre(nombre);
	    var resultados = getTipoIdentificacionDAO().consultar(entity);
	    
	    if (!resultados.isEmpty()) {
	        String mensajeUsuario = "Ya existe un Tipo de identificación con el nombre: " + nombre;
	        throw ServiceHealthException.crear(mensajeUsuario);
	    }
	}

	private TipoIdentificacionEntity crearTipoIdentificacionEntityNombre(final String nombre) {
	    var domain = TipoIdentificacionDomain.crear(null, null, nombre);
	    return TipoIdentificacionEntityMapper.convertToEntity(domain);
	}
	
	private final void validarNoexistenciaTipoIdentificacionConMismoCodigo(final String codigo) {
		TipoIdentificacionEntity entity = crearTipoIdentificacionEntityCodigo(codigo);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "ya existe un Tipo de identificación con el codigo: " + codigo;
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	private final TipoIdentificacionEntity crearTipoIdentificacionEntityCodigo(final String codigo) {
	    var domain = TipoIdentificacionDomain.crear(null, codigo, null);
	    return TipoIdentificacionEntityMapper.convertToEntity(domain);
	}
	
	private final TipoIdentificacionDomain obtenerIdentificadorTipoIdentificacion(final TipoIdentificacionDomain domain) {
		
		Optional<TipoIdentificacionEntity> optional;
		UUID uuid;
		do {
			uuid = UUID.randomUUID();
			optional = getTipoIdentificacionDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return TipoIdentificacionDomain.crear(uuid, domain.getCodigo(), domain.getNombre());
	}


	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000029);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			throw ServiceHealthException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}




}
