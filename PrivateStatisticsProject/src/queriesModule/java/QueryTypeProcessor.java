package queriesModule.java;
/**
 * 
 * @author Carmen Cojocaru 
 * Class that manages the handlers.
 * - class used in Chain of Responsibility Pattern
 */
public class QueryTypeProcessor {
	QueryTypeHandler prevHandler;
	
	public void addHandler(QueryTypeHandler handler) {
		if (prevHandler != null)
			prevHandler.setNext(handler);
		else 
			prevHandler = handler;
	}

	public QueryTypeHandler getPrevHandler() {
		return prevHandler;
	}

	public void setPrevHandler(QueryTypeHandler prevHandler) {
		this.prevHandler = prevHandler;
	}
}
