package queriesModule.java;
/**
 * 
 * @author Carmen Cojocaru
 * Class that looks after the incoming queries. The class allows to be 
 * added new handlers.
 * - class used in Chain of Responsibility Pattern
 */
public class QueryTypeClient {
	private QueryTypeProcessor processor;
	
	public QueryTypeClient() {
		createProcessor();
	}
	
	public void createProcessor() {
		processor = new QueryTypeProcessor();
		processor.addHandler(new MaxHandler());
		processor.addHandler(new MinHandler());
	}
	
	/**
	 * Method that gives us the possibility to add new handlers.
	 * @param handler
	 */
	public void addNewHandler(QueryTypeHandler handler) {
		processor.addHandler(handler);
	}
	
	/**
	 * MEthod that processes the new query received from the user.
	 * @param queryType
	 * @return
	 */
	public String queryReceived(QueryType queryType) {
		return processor.prevHandler.handleRequest(queryType);
	}
}
