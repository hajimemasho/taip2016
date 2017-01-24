package queriesModule.java;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import utilitiesModule.java.Paillier;
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

	// mostly server
	public static ClientUser CreateUser(String username,
			UserLevelKeyLength level) {

		ConnectionDb conn = new ConnectionDb();

		// server
		BigInteger userName2 = conn.getMySqlConnectionDB()
				.getUserName(username);
		ClientUser cl = new ClientUser();
		if (userName2 != null) {
			cl.setUsername(username);

			return cl;
		}

		Paillier p;

		// server
		switch (level) {
		case SYSTEM:
			p = new Paillier(UserLevelKeyLength.SYSTEM.getUserLevel(),
					UserLevelKeyCertainty.SYSTEM.getUserKeyCertainty());
			break;
		case USERLEVEL1:
			p = new Paillier(UserLevelKeyLength.USERLEVEL1.getUserLevel(),
					UserLevelKeyCertainty.USERLEVEL1.getUserKeyCertainty());
			break;
		case USERLEVEL2:
			p = new Paillier(UserLevelKeyLength.USERLEVEL2.getUserLevel(),
					UserLevelKeyCertainty.USERLEVEL2.getUserKeyCertainty());
			break;
		default:
			p = new Paillier(UserLevelKeyLength.SYSTEM.getUserLevel(),
					UserLevelKeyCertainty.SYSTEM.getUserKeyCertainty());
			break;
		}
		// server
		BigInteger zeroIntEnc = p.Encryption(BigInteger.ZERO);
		// server
		conn.getMySqlConnectionDB().insertSecurePatient("SYSTEM", zeroIntEnc,
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
		conn.getMySqlConnectionDB().insertUserKeys(username, p.getP(),
				p.getQ(), level.getUserLevel(), certainty);
		cl.setUsername(username);
		cl.setP(p.getP());
		cl.setQ(p.getQ());
		cl.setKeyLength(level.getUserLevel());

		return cl;
	}

	// server
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
