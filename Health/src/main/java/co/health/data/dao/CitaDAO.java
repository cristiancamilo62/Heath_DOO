package co.health.data.dao;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import co.health.data.entity.CitaEntity;

public interface CitaDAO {
	void registrar(CitaEntity cita); 
	void agendar(CitaEntity cita);
	void enviarConfirmacion(CitaEntity cita);
	void cancelar(CitaEntity cita);
	void reprogramar(CitaEntity cita);
	void cambiarEstado(CitaEntity cita);
	Optional<CitaEntity> consultarPorId(UUID id);
	List<CitaEntity> consultar(CitaEntity cita);
	

}
