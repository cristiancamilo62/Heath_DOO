package co.health.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.data.entity.RegimenAfiliacionEntity;

public interface RegimenAfiliacionDAO {
	
	void registrar(RegimenAfiliacionEntity regimenAfiliacion);
	void modificar(RegimenAfiliacionEntity regimenAfiliacion);
	void eliminar(UUID id);
	Optional<RegimenAfiliacionEntity> consultarPorId(UUID id);
	List<RegimenAfiliacionEntity> consultar(RegimenAfiliacionEntity regimenAfiliacion);

}
