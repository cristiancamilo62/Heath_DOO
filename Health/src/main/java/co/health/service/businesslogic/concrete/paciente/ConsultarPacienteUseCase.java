package co.health.service.businesslogic.concrete.paciente;


import java.util.List;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.messages.CatalogoMensajes;
import co.health.crosscutting.messages.enumerator.CodigoMensaje;
import co.health.crosscutting.util.UtilObjeto;
import co.health.data.dao.PacienteDAO;
import co.health.data.dao.daofactory.DAOFactory;
import co.health.data.entity.PacienteEntity;
import co.health.service.businesslogic.UseCaseRetorno;
import co.health.service.domain.paciente.PacienteDomain;
import co.health.service.mapper.entity.concrete.PacienteEntityMapper;

public final class ConsultarPacienteUseCase implements UseCaseRetorno<PacienteDomain,List<PacienteEntity>>{

	private DAOFactory factoria;

	public ConsultarPacienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	
	@Override
	public final List<PacienteEntity> executeRetorno(final PacienteDomain domain) {
		var entity = crearPacienteEntityIdAConsultar(domain);
	    var resultados = getPacienteDAO().consultar(entity);
	    if (resultados.isEmpty()) {
	        throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000125));
	    }
	    return resultados;
	}
	private PacienteEntity crearPacienteEntityIdAConsultar(final PacienteDomain domain) {
	    return PacienteEntityMapper.convertToEntity(domain);
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final PacienteDAO getPacienteDAO() {
		return getFactoria().obtenerPacienteDAO();
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			throw ServiceHealthException.crear(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000126),
					CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000127));
		}
		this.factoria = factoria;
	}



}
