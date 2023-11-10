package co.health.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.data.entity.EstadoCitaEntity;


public interface EstadoCitaDAO {
	void registrar(EstadoCitaEntity estadoCita);
	void eliminar(UUID id);
	Optional<EstadoCitaEntity> consultarPorId(UUID id);
	List<EstadoCitaEntity> consultar(EstadoCitaEntity estadoCita);
	
}
