package co.health.service.businesslogic;

public interface UseCaseRetorno<D,R> {
	
	R executeRetorno(D domain);

}
