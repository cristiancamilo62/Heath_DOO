package co.health.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.data.dao.RegimenAfiliacionDAO;
import co.health.data.dao.base.SQLDAO;
import co.health.data.entity.RegimenAfiliacionEntity;

public final class RegimenAfiliacionSQLServerDAO extends SQLDAO implements RegimenAfiliacionDAO{

	public RegimenAfiliacionSQLServerDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void registrar(final RegimenAfiliacionEntity regimenAfiliacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void modificar(final RegimenAfiliacionEntity regimenAfiliacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<RegimenAfiliacionEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<RegimenAfiliacionEntity> consultar(final RegimenAfiliacionEntity regimenAfiliacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
