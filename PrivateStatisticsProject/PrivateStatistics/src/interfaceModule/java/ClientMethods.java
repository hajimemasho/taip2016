package interfaceModule.java;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import queriesModule.java.Query;
import queriesModule.java.UserLevelKeyLength;
import utilitiesModule.java.Paillier;

public class ClientMethods {

	/**
	 * Checks if a username is present in the database 
	 * and verifies if the keys used by it are valid.
	 * 
	 * @param username
	 * 		The username to be checked
	 * @param paillier
	 * 		The paillier object with the user keys
	 * @return boolean
	 * 		If the user is valid or not.
	 * @throws SQLException
	 */
	public static boolean ValidateUsername(String username, Paillier paillier)
			throws SQLException {
		List<BigInteger> list = Query.GetUserList(username);
		if(list.isEmpty()){
			return false;
		}
		if (paillier.Decryption(list.get(0)).equals(BigInteger.ZERO)) {
			return true;
		}
		return false;
	}
	
	public static BigInteger Encrypt(BigInteger data, Paillier paillier){
		return paillier.Encryption(data);		
	}

	public static BigInteger Decrypt(BigInteger data, Paillier paillier){
		return paillier.Decryption(data);		
	}

	public static BigInteger Sum(List<BigInteger> list, Paillier paillier){
		return Query.Sum(list, paillier);		
	}
	
	public static Paillier CreatePaillier(BigInteger p, BigInteger q, UserLevelKeyLength keyLength){
		Paillier paillier = new Paillier(p,q,keyLength.getUserLevel());
		return paillier;
	}
	
	public static UserLevelKeyLength GetUserLevel(String userLevel){
		if(UserLevelKeyLength.SYSTEM.toString().equals(userLevel))
			return UserLevelKeyLength.SYSTEM;
		if(UserLevelKeyLength.USERLEVEL1.toString().equals(userLevel))
			return UserLevelKeyLength.USERLEVEL1;
		if(UserLevelKeyLength.USERLEVEL2.toString().equals(userLevel))
			return UserLevelKeyLength.USERLEVEL2;
		
		return UserLevelKeyLength.SYSTEM;
	}
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	public static List<BigInteger> GetUserList(String userName) {
		try {
			return Query.GetUserList(userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<BigInteger>();
		}
	}
}
