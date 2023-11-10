package co.health.service.businesslogic;


public interface UseCase<D> {

	void execute(D domain);
	
}
