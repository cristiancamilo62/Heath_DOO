package co.health.service.domain;

public interface ValidationRule<T> {
	
	void validar(T dato);

}
