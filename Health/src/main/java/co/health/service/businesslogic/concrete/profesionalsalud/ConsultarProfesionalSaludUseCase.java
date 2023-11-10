package co.health.service.businesslogic.concrete.profesionalsalud;

import java.util.List;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.dao.ProfesionalSaludDAO;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.entity.ProfesionalSaludEntity;
import co.health.service.businesslogic.UseCaseRetorno;
import co.health.service.domain.profesionalsalud.ProfesionalSaludDomain;
import co.health.service.mapper.entity.concrete.ProfesionalSaludEntityMapper;

public class ConsultarProfesionalSaludUseCase implements UseCaseRetorno<ProfesionalSaludDomain, List<ProfesionalSaludEntity>>{
	
	private DAOFactory factoria;

	public ConsultarProfesionalSaludUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	
	@Override
	public final List<ProfesionalSaludEntity> executeRetorno(final ProfesionalSaludDomain domain) {
		var entity = crearProfesionalSaludEntityIdAConsultar(domain);
	    var resultados = getProfesionalSaludDAO().consultar(entity);
	    if (resultados.isEmpty()) {
	        throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000125));
	    }
	    return resultados;
	}
	private ProfesionalSaludEntity crearProfesionalSaludEntityIdAConsultar(final ProfesionalSaludDomain domain) {
	    return ProfesionalSaludEntityMapper.convertToEntity(domain);
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final ProfesionalSaludDAO getProfesionalSaludDAO() {
		return getFactoria().obtenerProfesionalSaludDAO();
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000196);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000197);
			throw ServiceHealthException.crear(mensajeUsuario,mensajeTecnico);
		}
		this.factoria = factoria;
	}


}
