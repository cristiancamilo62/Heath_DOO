/*package co.health.service.facade.concrete.cita;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.dao.daofactory.TipoDAOFactory;
import co.health.service.businesslogic.concrete.cita.AgendarCitaUseCase;
import co.health.service.businesslogic.concrete.paciente.RegistrarPacienteUseCase;
import co.health.service.domain.cita.CitaDomain;
import co.health.service.domain.cita.rules.CitaValidationRule;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.domain.paciente.rules.PacienteValidationRule;
import co.health.service.dto.CitaDTO;
import co.health.service.dto.PacienteDTO;
import co.health.service.facade.Facade;
import co.health.service.mapper.dto.concrete.CitaDTOMapper;
import co.health.service.mapper.dto.concrete.PacienteDTOMapper;

public final class AgendarCitaFacade implements Facade<CitaDTO>{
	@Override
	public void execute(CitaDTO dto) {

		final CitaDomain domain = CitaDTOMapper.convertToDomain(dto);
		CitaValidationRule.ejecutarValidacion(domain);
		
		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new AgendarCitaUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final HealthException exception) {
			daoFactory.cancelarTransacion();
			throw exception;
		}catch (final Exception exception) {
			daoFactory.cancelarTransacion();
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de registrar una nuevo cliente";
			var mensajeTecnico = "se ha presentado un problema tratando de tipo excepcion tratando de registrar un nuevo cliente";
			throw ServiceHealthException.crear(mensajeUsuario,mensajeTecnico,exception);
		}
		finally {
			daoFactory.cerrarConexion();
		}
		
	}
	
}*/
