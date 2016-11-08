package queriesModule.java;
/**
 * 
 * @author Carmen Cojocaru
 * Class that identifies the type of query: max, min, average etc
 * - class used in Chain of Responsibility Pattern
 */
public class QueryType {
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
