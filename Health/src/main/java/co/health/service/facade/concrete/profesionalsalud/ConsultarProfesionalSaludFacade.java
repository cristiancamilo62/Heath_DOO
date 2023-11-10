package co.health.service.facade.concrete.profesionalsalud;

import java.util.ArrayList;
import java.util.List;

import co.health.crosscutting.exception.HealthException;
import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.dao.daofactory.TipoDAOFactory;
import co.health.data.entity.ProfesionalSaludEntity;
import co.health.service.businesslogic.concrete.profesionalsalud.ConsultarProfesionalSaludUseCase;
import co.health.service.domain.profesionalsalud.ProfesionalSaludDomain;
import co.health.service.domain.profesionalsalud.rules.ProfesionalSaludValidationRule;
import co.health.service.dto.ProfesionalSaludDTO;
import co.health.service.facade.FacadeRetorno;
import co.health.service.mapper.dto.concrete.ProfesionalSaludDTOMapper;

public final class ConsultarProfesionalSaludFacade implements FacadeRetorno<ProfesionalSaludDTO, List<ProfesionalSaludEntity>>{

	
	
	@Override
	public List<ProfesionalSaludEntity> executeRetorno(ProfesionalSaludDTO dto) {
		List<ProfesionalSaludEntity> resultados = new ArrayList<>();

        final ProfesionalSaludDomain domain = ProfesionalSaludDTOMapper.convertToDomain(dto);
        ProfesionalSaludValidationRule.ejecutarValidacion(domain);

        final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);

        try {
            daoFactory.iniciarTransaccion();

            var useCase = new ConsultarProfesionalSaludUseCase(daoFactory);
            resultados = useCase.executeRetorno(domain);

            daoFactory.confirmarTransaccion();
        } catch (final HealthException exception) {
            daoFactory.cancelarTransacion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelarTransacion();
            throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000097),
            		CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000098), exception);
        } finally {
            daoFactory.cerrarConexion();
        }
        return resultados;
    }

}
