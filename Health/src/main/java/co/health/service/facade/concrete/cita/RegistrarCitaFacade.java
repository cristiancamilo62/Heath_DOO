package co.health.service.facade.concrete.cita;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.dao.daofactory.TipoDAOFactory;
import co.health.service.businesslogic.concrete.cita.RegistrarCitaUseCase;
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

public class RegistrarCitaFacade implements Facade<CitaDTO>{

	@Override
	public void execute(CitaDTO dto) {

		final CitaDomain domain = CitaDTOMapper.convertToDomain(dto);
		CitaValidationRule.ejecutarValidacion(domain);
		
		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarCitaUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final HealthException exception) {
			daoFactory.cancelarTransacion();
			throw exception;
		}catch (final Exception exception) {
			daoFactory.cancelarTransacion();throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000095),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000096),exception);
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}
}
