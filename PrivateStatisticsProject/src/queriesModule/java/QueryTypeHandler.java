package queriesModule.java;
/**
 * 
 * @author Carmen Cojocaru
 * Handler interface used for the Chain of Responsibility Pattern
 */
public interface QueryTypeHandler {
	
	/**
	 * Sets the next handler
	 * @param handler
	 */
	void setNext(QueryTypeHandler handler);
	
	/**
	 * Handles the request or it delegates to the next handler available. 
	 * @param queryType
	 * @return
	 */
	String handleRequest(QueryType queryType);
}
