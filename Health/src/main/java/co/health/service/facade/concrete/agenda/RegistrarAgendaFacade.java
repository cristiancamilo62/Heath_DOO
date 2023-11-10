package co.health.service.facade.concrete.agenda;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.dao.daofactory.TipoDAOFactory;
import co.health.service.businesslogic.concrete.agenda.RegistrarAgendaUSeCase;
import co.health.service.domain.agenda.AgendaDomain;
import co.health.service.domain.agenda.rules.AgendaValidationRule;
import co.health.service.dto.AgendaDTO;
import co.health.service.facade.Facade;
import co.health.service.mapper.dto.concrete.AgendaDTOMapper;

public final class RegistrarAgendaFacade implements Facade<AgendaDTO>{

	@Override
	public final void execute(final AgendaDTO dto) {
		

		final AgendaDomain domain = AgendaDTOMapper.convertToDomain(dto);
		AgendaValidationRule.ejecutarValidacion(domain);
		
		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarAgendaUSeCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final HealthException exception) {
			daoFactory.cancelarTransacion();
			throw exception;
		}catch (final Exception exception) {
			daoFactory.cancelarTransacion();
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000209),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000210),exception);
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}
}
