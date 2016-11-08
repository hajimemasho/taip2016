package queriesModule.java;
/**
 * 
 * @author Carmen Cojocaru
 * Class that implements the Facade design pattern. The pattern provides access to 
 * Query and DatabaseAccess classes which are hidden from the caller by this facade.
 */
public class QueryFacade implements IQueryFacade{
	
	private DatabaseAccess dbAccess;
	private Query query;
	
	public String query(String input) {
		QueryType queryType = query.processInput(input);

		// needed for operating on it using max, min, average etc
		@SuppressWarnings("unused")
		String encryptedData = dbAccess.getEncryptedData();
		
		QueryTypeClient client = new QueryTypeClient();
		String output = client.queryReceived(queryType);
		return output;
	}
}
