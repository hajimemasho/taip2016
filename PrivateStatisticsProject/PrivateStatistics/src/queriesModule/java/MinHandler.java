package queriesModule.java;
/**
 * 
 * @author Carmen Cojocaru
 * Type of handler - class used in Chain of Responsibility Pattern
 */
public class MinHandler implements QueryTypeHandler{
	
	QueryTypeHandler next;
	
	@Override
	public void setNext(QueryTypeHandler handler) {
		next = handler;
	}

	@Override
	public String handleRequest(QueryType queryType) {
		if (queryType.getType().equals("min")) {
			// process request
		} else {
			next.handleRequest(queryType);
		}
		
		return null;
	}

}
