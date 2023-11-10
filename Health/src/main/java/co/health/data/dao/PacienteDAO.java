package co.health.data.dao;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.health.data.entity.CitaEntity;
import co.health.data.entity.PacienteEntity;


public interface PacienteDAO {
	
	void registar(PacienteEntity paciente);
	void modificar(PacienteEntity paciente);
	//void cambiarEstadoCuenta(PacienteEntity paciente);
	//void confirmarCita(CitaEntity cita);
	void eliminar(UUID id);
	Optional<PacienteEntity> consultarPorId(UUID id);
	List<PacienteEntity> consultar(PacienteEntity paciente);
	
	
}