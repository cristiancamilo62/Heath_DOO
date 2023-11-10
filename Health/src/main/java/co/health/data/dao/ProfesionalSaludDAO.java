package co.health.data.dao;

import java.util.List;

import co.health.data.entity.ProfesionalSaludEntity;

public interface ProfesionalSaludDAO {
	
	List<ProfesionalSaludEntity> consultar(ProfesionalSaludEntity profesional);


}
