package co.health.service.businesslogic.concrete.cita;

import java.util.Optional;
import java.util.UUID;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.dao.CitaDAO;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.entity.CitaEntity;
import co.health.service.businesslogic.UseCase;
import co.health.service.businesslogic.validator.concrete.cita.RegistrarCitaValidator;
import co.health.service.domain.cita.CitaDomain;
import co.health.service.domain.cita.support.DatosServicioCitaDomain;
import co.health.service.domain.cita.support.FechaCitaDomain;
import co.health.service.mapper.entity.concrete.CitaEntityMapper;

public class RegistrarCitaUseCase implements UseCase<CitaDomain>{

	private DAOFactory factoria;

	public RegistrarCitaUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(CitaDomain domain) {
		
		RegistrarCitaValidator.ejecutarValidacion(domain);
		
		//validarNoExistenciaCitaMismaFechaYConsultorio(domain.getFecha(),domain.getDatosServicioCita());

		domain = obtenerIdentificadorCita(domain);

		registrarNuevaCita(domain);
		
	}
	
	private void registrarNuevaCita(final CitaDomain domain ) {
		var entity = CitaEntityMapper.convertToEntity(domain);
		getCitaDAO().registrar(entity);
		
	}
	
	
	private final void validarNoExistenciaCitaMismaFechaYConsultorio(final FechaCitaDomain fechaCita,DatosServicioCitaDomain datosServicioCita) {
		 var entity = crearCitaEntityFechaCitaODatosServicioCita( fechaCita, datosServicioCita);
		    var resultados = getCitaDAO().consultar(entity);
		    if (!resultados.isEmpty()) {
		        throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000124));
		    }
	}
	private CitaEntity crearCitaEntityFechaCitaODatosServicioCita(final FechaCitaDomain fechaCita,DatosServicioCitaDomain datosServicioCita) {
	    var domain = CitaDomain.crear(null,datosServicioCita,fechaCita,null,null);
	    return CitaEntityMapper.convertToEntity(domain);
	}
	
	private final CitaDomain obtenerIdentificadorCita(final CitaDomain domain) {
		
		Optional<CitaEntity> optional;
		UUID uuid;
		do {
			uuid = UUID.randomUUID();
			//optional = getCitaDAO().consultarPorId(uuid);
		}while(uuid==null);
		
		return CitaDomain.crear(uuid,domain.getDatosServicioCita(
				),domain.getFecha(),domain.getEstadoCita(),domain.getNombreProfesional());
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final CitaDAO getCitaDAO() {
		return getFactoria().obtenerCitaDAO();
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000122),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000123));
		}
		this.factoria = factoria;
	}


}
