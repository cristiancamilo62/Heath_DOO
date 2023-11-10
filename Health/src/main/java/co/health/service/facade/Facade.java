package co.health.service.facade;


public interface Facade<T> {
	
	void execute(T dto);

}
