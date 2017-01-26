package console;

import interfaceModule.java.ClientMethods;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import queriesModule.java.ClientUser;
import queriesModule.java.Query;
import queriesModule.java.UserLevelKeyCertainty;
import queriesModule.java.UserLevelKeyLength;
import utilitiesModule.java.Paillier;
import utilitiesModule.java.User;
import databaseModule.java.ConnectionDb;
import databaseModule.tests.TestConnectionDB;

public class Main {

	public static Paillier paillier;

	public static void main(String[] args) throws SQLException {

		ConnectionDb c = new ConnectionDb();
		c.getMySqlConnectionDB();
//		String username = "Dragos4";
//		BigInteger p = new BigInteger(
//				"7272197131313937324683405753084789041784615870549826643877959038842990989523762517877587821946968102257061155695353929443425751900902260709450306654681239");
//		BigInteger q = new BigInteger(
//				"12508361454584909926083340598363283788196138278030823856985264164586906176866559301033190136763519786830753740519479224447980809514152698291904625617627503");
//		paillier = new Paillier(p, q, 64);
//
//		//we check if the user exists
//		if(!ValidateUsername(username, paillier)){
//			ClientUser cl = Query.CreateUser(username, UserLevelKeyLength.USERLEVEL1);
//			//must be sent to the client
//			System.out.println("P: "+cl.getP());
//			System.out.println("Q: "+cl.getQ());
//		}
//
//		List<BigInteger> list = new ArrayList<BigInteger>();
//		try {
//			list = Query.GetUserList(username);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		BigInteger encSum = Query.Sum(list, paillier);
//
//		System.out.println(encSum);
//		System.out.println(paillier.Decryption(encSum));

		 long tSystemStart = System.nanoTime();
		 TestUserTypeSystem();
		 long tSystemEnd = System.nanoTime();
		 System.out.println("System time: "+(tSystemEnd - tSystemStart)+" nanoseconds");
		 
		 long tUserStart = System.nanoTime();
		 TestUserType1();		
		 long tUserEnd = System.nanoTime();		
		 System.out.println("System time: "+(tUserEnd -	 tUserStart)+" nanoseconds");

		 long tUserStart2 = System.nanoTime();
		 TestUserType2();		
		 long tUserEnd2 = System.nanoTime();		
		 System.out.println("System time: "+(tUserEnd2 - tUserStart2)+" nanoseconds");
		 
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

	public static void TestUserType() {

		ConnectionDb c = new ConnectionDb();

		String username = "UserNameTypeU1";
		BigInteger p = new BigInteger(
				"11372246589286721500663273476590384678742881599569415755011668687121982801811623191979769062820951854382241410645278330131368557653626093568993175115950091");
		BigInteger q = new BigInteger(
				"7208129525775466902608074038664359383615874782384084176652821773379811598927382061008304480062890184682664791807241204401511806187317023590829253832614669");
		
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier(p, q, UserLevelKeyLength.USERLEVEL1.getUserLevel());

		List<BigInteger> d = GenerateData(paillier, username, UserLevelKeyLength.USERLEVEL1);
//		try {
//			patientAgeList = c.getMySqlConnectionDB().getSecurePatientAge(username);
//			BigInteger z = Query.Sum(patientAgeList, paillier);
//			 System.out.println(z);
//			 System.out.println(paillier.Decryption(z).toString());
//			 for (int i = 0; i < patientAgeList.size(); i++) {
//			 System.out.println(paillier.Decryption(patientAgeList.get(i)));
//			 }
//			 System.out.println(patientAgeList);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static void TestUserType1() {

		ConnectionDb c = new ConnectionDb();

		String username = "UserNameTypeU1";
		BigInteger p = new BigInteger(
				"6939860194733233402990509061773308143710647770508263581557627498610828641385527602986223425660011228212350024381787024057701988912870030596080994165372419");
		BigInteger q = new BigInteger(
				"7147011285300665066221720494225976900770839758919081872864198036521872980177299486944793469713666475402019536342085590817243882780495820759096378244376077");
		
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier(p, q, UserLevelKeyLength.USERLEVEL1.getUserLevel());

		List<BigInteger> d = GenerateData(paillier, username, UserLevelKeyLength.USERLEVEL1);
//		try {
//			patientAgeList = c.getMySqlConnectionDB().getSecurePatientAge(username);
//			BigInteger z = Query.Sum(patientAgeList, paillier);
//			 System.out.println(z);
//			 System.out.println(paillier.Decryption(z).toString());
//			 for (int i = 0; i < patientAgeList.size(); i++) {
//			 System.out.println(paillier.Decryption(patientAgeList.get(i)));
//			 }
//			 System.out.println(patientAgeList);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static void TestUserType2() {

		ConnectionDb c = new ConnectionDb();

		String username = "UserNameTypeU2";
		BigInteger p = new BigInteger(
				"30374325276599562285112560043437952983310814797107043536283737838018604946538137236038676033412122694494297903670766140502573448106379801049145866888201498227019340056997273564850858747658346741768406481837672712898405868722265991524909094511426265501760148951549864218124305852036527413070724319257039864013660480083269506179209437097528314753712546084823793107019633240975409298869669977177471742799676248928609418910705521963709892474485416366797282443819166990828586683355811086804237924753293759804919915144216692066827287345649640732568269186010877295931138993815129521222065477028509772301923966837396109193111");
		BigInteger q = new BigInteger(
				"28232012108596215159062232702022369787175468135519868430688837232833835772727221010694936981654301461814024162118615449613873661882592620477341491310244188159356919005805044381956179460680305035843478883185587622939077659973858605495209930860486890423748743477142853684959612975481429774059788678197881893065778297654068791794275596289712378254914268169292281622678519341606639706823159042305571237229292767260173699848685128127389921302962611754558144788956066187871984355747106073987315131125719574115093475041272050093385781521504761218326958181301489065109255391233444030372249336397092585360436845666458139267563");
		
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier(p, q, UserLevelKeyLength.USERLEVEL2.getUserLevel());

		List<BigInteger> d = GenerateData(paillier, username, UserLevelKeyLength.USERLEVEL2);
//		try {
//			patientAgeList = c.getMySqlConnectionDB().getSecurePatientAge(username);
//			BigInteger z = Query.Sum(patientAgeList, paillier);
//			 System.out.println(z);
//			 System.out.println(paillier.Decryption(z).toString());
//			 for (int i = 0; i < patientAgeList.size(); i++) {
//			 System.out.println(paillier.Decryption(patientAgeList.get(i)));
//			 }
//			 System.out.println(patientAgeList);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static void TestUserTypeSystem() {

		ConnectionDb c = new ConnectionDb();

		String username = "UserNameTypeSystem";
		BigInteger p = new BigInteger(
				"107264089776812724153624602517371144577805414013542611465011154548706479829611");
		BigInteger q = new BigInteger(
				"100569554720091866208548233703835921556525655486850864030124177825822329813893");
		
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier(p, q, UserLevelKeyLength.SYSTEM.getUserLevel());

		List<BigInteger> d = GenerateData(paillier, username, UserLevelKeyLength.SYSTEM);
//		try {
//			patientAgeList = c.getMySqlConnectionDB().getSecurePatientAge(username);
//			BigInteger z = Query.Sum(patientAgeList, paillier);
//			 System.out.println(z);
//			 System.out.println(paillier.Decryption(z).toString());
//			 for (int i = 0; i < patientAgeList.size(); i++) {
//			 System.out.println(paillier.Decryption(patientAgeList.get(i)));
//			 }
//			 System.out.println(patientAgeList);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static void TestSystemUser() {

		ConnectionDb c = new ConnectionDb();
		List<String> patientNameList;
		List<BigInteger> patientAgeList;

		BigInteger p = new BigInteger(
				"92250842239383935966460454796463127248021803261441077775431438424667619019597");
		BigInteger q = new BigInteger(
				"60402789000353836433491821747395216567925711915280511547643571203735404707597");
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier(p, q, 512);

		String userType;
		if (paillier.getP().toString().length() <= 100) {
			userType = "System";
		} else {
			userType = "U1";
		}
		try {
			patientAgeList = c.getMySqlConnectionDB().getSecurePatientAge(userType);
			BigInteger z = Query.Sum(patientAgeList, paillier);
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

	// we generate 10 rows each time we test the application
	public static List<BigInteger> GenerateData(Paillier paillier, String userName, UserLevelKeyLength keyLength) {
		
		List<BigInteger> list = new ArrayList<BigInteger>();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {

			int randAge = r.nextInt(1000);
			BigInteger age = new BigInteger(String.valueOf(randAge));
			String name = "username_" + randAge;
			int randCost = r.nextInt(10000);
			BigInteger cost = new BigInteger(String.valueOf(randCost));	
			boolean result = ClientMethods.InsertData(paillier, userName,keyLength, name, age, cost);
		}
		return list;
	}
}
