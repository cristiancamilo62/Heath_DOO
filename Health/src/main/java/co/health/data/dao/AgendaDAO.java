package co.health.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.data.entity.AgendaEntity;

public interface AgendaDAO {
	
	void registrarCita (AgendaEntity agenda); 
	void eliminarCita (AgendaEntity agenda);
	Optional<AgendaEntity> consultarPorId(UUID id);
	List<AgendaEntity> consultar(AgendaEntity agenda);

}
