package queriesModule.java;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import utilitiesModule.java.Paillier;
import utilitiesModule.java.User;
import databaseModule.java.ConnectionDb;

/**
 * 
 * @author Carmen Cojocaru Class that manages the user needs. - class used in
 *         Facade pattern
 */
public class Query {

	QueryType queryType;

	/**
	 * Method that processes the input from the Interface module.
	 * 
	 * @param input
	 * @return
	 */
	QueryType processInput(String input) {
		return queryType;
	}

	// server
	/**
	 * Returns all the values for the current user
	 * 
	 * @param userName
	 *            The username
	 * @return List<BigInteger>
	 * @throws SQLException
	 */
	public static List<BigInteger> GetUserList(String userName) throws SQLException {
		ConnectionDb conn = new ConnectionDb();
		return conn.getMySqlConnectionDB().getSecurePatientAge(userName);
	}

	public static boolean InsertValues(User user){
		ConnectionDb conn = new ConnectionDb();
		return conn.getMySqlConnectionDB().insertSecurePatient(user.Name, user.Age, user.level.toString(), user.UserName);
	}
	
	
	/**
	 * Creates a new username and inserts the encrypted value 0 in the database
	 * @param username
	 * @param level
	 * 		The level of the user
	 * @return
	 */
	public static ClientUser CreateUser(String username, UserLevelKeyLength level) {

		ConnectionDb connection = new ConnectionDb();

		BigInteger userName2 = connection.getMySqlConnectionDB().getUserName(username);
		ClientUser clientuser = new ClientUser();
		if (userName2 != null) {
			clientuser.setUsername(username);
			return clientuser;
		}

		Paillier paillier;

		switch (level) {
		case SYSTEM:
			paillier = new Paillier(UserLevelKeyLength.SYSTEM.getUserLevel(),
					UserLevelKeyCertainty.SYSTEM.getUserKeyCertainty());
			break;
		case USERLEVEL1:
			paillier = new Paillier(UserLevelKeyLength.USERLEVEL1.getUserLevel(),
					UserLevelKeyCertainty.USERLEVEL1.getUserKeyCertainty());
			break;
		case USERLEVEL2:
			paillier = new Paillier(UserLevelKeyLength.USERLEVEL2.getUserLevel(),
					UserLevelKeyCertainty.USERLEVEL2.getUserKeyCertainty());
			break;
		default:
			paillier = new Paillier(UserLevelKeyLength.SYSTEM.getUserLevel(),
					UserLevelKeyCertainty.SYSTEM.getUserKeyCertainty());
			break;
		}
		// server
		BigInteger zeroIntEnc = paillier.Encryption(BigInteger.ZERO);
		// server
		connection.getMySqlConnectionDB().insertSecurePatient("SYSTEM", zeroIntEnc,
				level.toString(), username);

		int certainty;
		switch (level) {
		case SYSTEM:
			certainty = 64;
			break;
		case USERLEVEL1:
			certainty = 128;
			break;
		case USERLEVEL2:
			certainty = 512;
			break;
		default:
			certainty = 64;
			break;
		}
		connection.getMySqlConnectionDB().insertUserKeys(username, paillier.getP(),
				paillier.getQ(), level.getUserLevel(), certainty);
		clientuser.setUsername(username);
		clientuser.setP(paillier.getP());
		clientuser.setQ(paillier.getQ());
		clientuser.setKeyLength(level.getUserLevel());
		clientuser.setUserType(level);
		
		return clientuser;
	}

	/**
	 * Calculates the sum of the encrypted list
	 * 
	 * @param list
	 *            The list of BigIntegers
	 * @param paillier
	 *            The Paillier encryption scheme
	 * @return BigInteger The sum of the list as a BigInteger
	 */
	public static BigInteger Sum(List<BigInteger> list, Paillier paillier) {
		BigInteger sum = paillier.Encryption(BigInteger.ZERO);
		for (int i = 0; i < list.size(); i++) {
			sum = list.get(i).multiply(sum).mod(paillier.nsquare);
		}
		return sum;
	}
}
