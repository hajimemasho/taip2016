package console;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import utilitiesModule.java.Paillier;
import databaseModule.java.ConnectionDb;
import databaseModule.tests.TestConnectionDB;

public class Main {

	public static Paillier paillier;

	public static void main(String[] args) throws SQLException {

		ConnectionDb c = new ConnectionDb();
		String username = "Dragos4";
		BigInteger p = new BigInteger(
				"103005585128399149929083238265072077690527500738485439868895731445431569236251");
		BigInteger q = new BigInteger(
				"82676777364178431381393175642019783686295269529644687924437468821808674638247");
		paillier = new Paillier(p, q, 64);

		//we check if the user exists
		if(!ValidateUsername(username, paillier)){
			ClientUser cl = CreateUser(username, UserLevelKeyLength.USERLEVEL1);
			//must be sent to the client
			System.out.println("P: "+cl.getP());
			System.out.println("Q: "+cl.getQ());
		}

		List<BigInteger> list = new ArrayList<BigInteger>();
		try {
			list = GetUserList(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BigInteger encSum = Sum(list, paillier);

		System.out.println(encSum);
		System.out.println(paillier.Decryption(encSum));

		// long tSystemStart = System.nanoTime();
		//
		// TestSystemUser();
		//
		//
		// long tSystemEnd = System.nanoTime();
		// System.out.println("System time: "+(tSystemEnd -
		// tSystemStart)+" nanoseconds");
		// long tUserStart = System.nanoTime();
		// TestLoggedUser();
		//
		// long tUserEnd = System.nanoTime();
		//
		// System.out.println("System time: "+(tUserEnd -
		// tUserStart)+" nanoseconds");

		// ConnectionDb c = new ConnectionDb();
		// List<String> patientNameList;
		// List<BigInteger> patientAgeList;
		// // TestConnectionDB t= new TestConnectionDB();
		// // t.testGetMysqlConnection_Is_Connection_class();
		//
		//
		// BigInteger p = new
		// BigInteger("92250842239383935966460454796463127248021803261441077775431438424667619019597");
		// BigInteger q = new
		// BigInteger("60402789000353836433491821747395216567925711915280511547643571203735404707597");
		// /* instantiating an object of Paillier cryptosystem */
		// Paillier paillier = new Paillier(p,q, 512);
		//
		// // Paillier paillierUser = new Paillier(1024,128);
		//
		// System.out.println("P: "+ paillier.getP());
		// System.out.println("Q: "+ paillier.getQ());
		//
		// // System.out.println("P: "+ paillierUser.getP());
		// // System.out.println("Q: "+ paillierUser.getQ());
		//
		// String userType;
		// if(paillier.getP().toString().length()<=100){
		// userType ="System";
		// }else{
		// userType = "U1";
		// }
		// // Thread t= new Thread();
		// List<BigInteger> d= GenerateData(c,paillier, userType);
		// try {
		// patientNameList =c.getMySqlConnectionDB().getSecurePatientName();
		// // patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge();
		// patientAgeList
		// =c.getMySqlConnectionDB().getSecurePatientAge(userType);
		// BigInteger z = Sum(patientAgeList, paillier);
		// System.out.println(z);
		// System.out.println(paillier.Decryption(z).toString());
		// for (int i = 0; i < patientAgeList.size(); i++) {
		// System.out.println(paillier.Decryption(patientAgeList.get(i)));
		// }
		// System.out.println(patientAgeList);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		/* instantiating two plaintext msgs */
		// BigInteger m1 = new BigInteger("30");
		// BigInteger m2 = new BigInteger("60");
		/* encryption */
		// BigInteger em1 = paillier.Encryption(m1);
		// BigInteger em2 = paillier.Encryption(m2);
		// /* printout encrypted text */
		// System.out.println("encrypted text m1: "+em1);
		// System.out.println("encrypted text m2: "+em2);
		// /* printout decrypted text */
		// System.out.println(paillier.Decryption(em1).toString());
		// System.out.println(paillier.Decryption(em2).toString());
		//
		// /*
		// * test homomorphic properties -> D(E(m1)*E(m2) mod n^2) = (m1 + m2)
		// mod
		// * n
		// */
		// BigInteger product_em1em2 = em1.multiply(em2).mod(paillier.nsquare);
		// BigInteger sum_m1m2 = m1.add(m2).mod(paillier.n);
		// System.out.println("original sum: " + sum_m1m2.toString());
		// System.out.println("decrypted sum: "
		// + paillier.Decryption(product_em1em2).toString());
		//
		// /* test homomorphic properties -> D(E(m1)^m2 mod n^2) = (m1*m2) mod n
		// */
		// BigInteger expo_em1m2 = em1.modPow(m2, paillier.nsquare);
		// BigInteger prod_m1m2 = m1.multiply(m2).mod(paillier.n);
		// System.out.println("original product: " + prod_m1m2.toString());
		// System.out.println("decrypted product: "
		// + paillier.Decryption(expo_em1m2).toString());

	}

	// server
	private static List<BigInteger> GetUserList(String userName)
			throws SQLException {
		ConnectionDb conn = new ConnectionDb();
		return conn.getMySqlConnectionDB().getSecurePatientAge(userName);

	}

	public static void TestLoggedUser() {

		ConnectionDb c = new ConnectionDb();
		List<String> patientNameList;
		List<BigInteger> patientAgeList;
		// TestConnectionDB t= new TestConnectionDB();
		// t.testGetMysqlConnection_Is_Connection_class();

		BigInteger p = new BigInteger(
				"8221402702548272830308353826272884305585665723761169259463041292332529721431254393076581862166813404530300159578790067496464807560591529003599073397549273");
		BigInteger q = new BigInteger(
				"9583204913178807923068962039027666551846037770399803623348456205666959228784781552502941843675128339722106786582259811263350768582927536220253464695532361");
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier(p, q, 1024);

		// Paillier paillierUser = new Paillier(1024,128);

		// System.out.println("P: "+ paillier.getP());
		// System.out.println("Q: "+ paillier.getQ());

		// System.out.println("P: "+ paillierUser.getP());
		// System.out.println("Q: "+ paillierUser.getQ());

		String userType;
		if (paillier.getP().toString().length() <= 100) {
			userType = "System";
		} else {
			userType = "U1";
		}
		// Thread t= new Thread();
		List<BigInteger> d = GenerateData(c, paillier, userType);
		try {
			// patientNameList =c.getMySqlConnectionDB().getSecurePatientName();
			// patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge();
			patientAgeList = c.getMySqlConnectionDB().getSecurePatientAge(
					userType);
			BigInteger z = Sum(patientAgeList, paillier);
			// System.out.println(z);
			// System.out.println(paillier.Decryption(z).toString());
			// for (int i = 0; i < patientAgeList.size(); i++) {
			// System.out.println(paillier.Decryption(patientAgeList.get(i)));
			// }
			// System.out.println(patientAgeList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public enum UserLevelKeyLength {
		SYSTEM(512), USERLEVEL1(1024), USERLEVEL2(4096);

		private final int levelCode;

		private UserLevelKeyLength(int levelCode) {
			this.levelCode = levelCode;
		}

		public int getUserLevel() {
			return this.levelCode;
		}
	}

	public enum UserLevelKeyCertainty {
		SYSTEM(64), USERLEVEL1(128), USERLEVEL2(526);

		private final int level;

		private UserLevelKeyCertainty(int level) {
			this.level = level;
		}

		public int getUserKeyCertainty() {
			return this.level;
		}
	}

	public static void TestSystemUser() {

		ConnectionDb c = new ConnectionDb();
		List<String> patientNameList;
		List<BigInteger> patientAgeList;
		// TestConnectionDB t= new TestConnectionDB();
		// t.testGetMysqlConnection_Is_Connection_class();

		BigInteger p = new BigInteger(
				"92250842239383935966460454796463127248021803261441077775431438424667619019597");
		BigInteger q = new BigInteger(
				"60402789000353836433491821747395216567925711915280511547643571203735404707597");
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier(p, q, 512);

		// Paillier paillierUser = new Paillier(1024,128);

		// System.out.println("P: "+ paillier.getP());
		// System.out.println("Q: "+ paillier.getQ());

		// System.out.println("P: "+ paillierUser.getP());
		// System.out.println("Q: "+ paillierUser.getQ());

		String userType;
		if (paillier.getP().toString().length() <= 100) {
			userType = "System";
		} else {
			userType = "U1";
		}
		// Thread t= new Thread();
		List<BigInteger> d = GenerateData(c, paillier, userType);
		try {
			// patientNameList =c.getMySqlConnectionDB().getSecurePatientName();
			// patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge();
			patientAgeList = c.getMySqlConnectionDB().getSecurePatientAge(
					userType);
			BigInteger z = Sum(patientAgeList, paillier);
			// System.out.println(z);
			// System.out.println(paillier.Decryption(z).toString());
			// for (int i = 0; i < patientAgeList.size(); i++) {
			// System.out.println(paillier.Decryption(patientAgeList.get(i)));
			// }
			// System.out.println(patientAgeList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public class User {
		String Name;
		BigInteger Age;
		String UserName;
		UserLevelKeyLength level;
	}

	
	public static class ClientUser{
		public ClientUser() {}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public BigInteger getP() {
			return p;
		}
		public void setP(BigInteger p) {
			this.p = p;
		}
		public BigInteger getQ() {
			return q;
		}
		public void setQ(BigInteger q) {
			this.q = q;
		}
		public int getCertainty() {
			return Certainty;
		}
		public void setCertainty(int certainty) {
			Certainty = certainty;
		}
		public int getKeyLength() {
			return KeyLength;
		}
		public void setKeyLength(int keyLength) {
			KeyLength = keyLength;
		}
		private String username;
		private BigInteger p;
		private BigInteger q;
		private int Certainty;
		private int KeyLength;
	}
	
	// mostly server
	public static ClientUser CreateUser(String username, UserLevelKeyLength level) {
		
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
		// toClient
		System.out.println(p.getP());
		System.out.println(p.getQ());

		
		paillier = p;
		// server
		conn.getMySqlConnectionDB().insertSecurePatient("SYSTEM", zeroIntEnc,
				level.toString(), username);
		
		int certainty;
		switch (level) {
		case SYSTEM:
			certainty=64;
			break;
		case USERLEVEL1:
			certainty=128;
			break;
		case USERLEVEL2:
			certainty=512;
			break;
		default:
			certainty=64;
			break;
		}
		conn.getMySqlConnectionDB().insertUserKeys(username, p.getP(), p.getQ(), level.getUserLevel(), certainty);
		cl.setUsername(username);
		cl.setP(p.getP());
		cl.setQ(p.getQ());
		cl.setKeyLength(level.getUserLevel());
		
		return cl;
	}

	// client
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
	private static boolean ValidateUsername(String username, Paillier paillier)
			throws SQLException {
		List<BigInteger> list = GetUserList(username);
		if(list.isEmpty()){
			return false;
		}
		if (paillier.Decryption(list.get(0)).equals(BigInteger.ZERO)) {
			return true;
		}
		return false;

	}

	// server
	/**
	 * Calculates the sum of the encrypted list
	 * @param list
	 * 		The list of BigIntegers
	 * @param paillier
	 * 		The Paillier encryption scheme
	 * @return BigInteger
	 * 		The sum of the list as a BigInteger
	 */
	public static BigInteger Sum(List<BigInteger> list, Paillier paillier) {
		BigInteger sum = paillier.Encryption(BigInteger.ZERO);
		for (int i = 0; i < list.size(); i++) {
			sum = list.get(i).multiply(sum).mod(paillier.nsquare);

			// sum = sum.multiply(a).mod(paillier.nsquare);
		}
		return sum;
	}

	// we generate 10 rows each time we test the application
	public static List<BigInteger> GenerateData(ConnectionDb conn,
			Paillier paillier, String userType) {
		Random r = new Random();
		List<BigInteger> list = new ArrayList<BigInteger>();

		for (int i = 0; i < 1; i++) {
			int age = r.nextInt(1000);
			BigInteger nr = new BigInteger(String.valueOf(age));
			// System.out.println(nr);
			BigInteger enr = paillier.Encryption(nr);
			list.add(enr);
			conn.getMySqlConnectionDB().insertSecurePatient("Test", enr,
					userType, "aa");
			// conn.getMySqlConnectionDB().insertInsecurePatient("Test", nr);

		}
		return list;
	}
}
