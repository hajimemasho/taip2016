package queriesModule.java;
/**
 * 
 * @author Carmen Cojocaru
 * Type of handler - class used in Chain of Responsibility Pattern
 */
public class MaxHandler implements QueryTypeHandler{

	QueryTypeHandler next;
	
	@Override
	public void setNext(QueryTypeHandler handler) {
		next = handler;
	}

	@Override
	public String handleRequest(QueryType queryType) {
		if (queryType.getType().equals("max")) {
			// process input
		} else {
			next.handleRequest(queryType);
		}
		
		return null;
	}

}
