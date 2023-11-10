package co.health.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.data.dao.EstadoCitaDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.EstadoCitaEntity;

public final class EstadoCitaSQLServerDAO extends SQLDAO implements EstadoCitaDAO{

	public EstadoCitaSQLServerDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void registrar(final EstadoCitaEntity estadoCita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<EstadoCitaEntity>  consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<EstadoCitaEntity> consultar(final EstadoCitaEntity estadoCita) {
		// TODO Auto-generated method stub
		return null;
	}

}
