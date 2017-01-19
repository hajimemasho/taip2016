package console;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import queriesModule.java.Paillier;
import databaseModule.java.ConnectionDb;
import databaseModule.tests.TestConnectionDB;

public class Main {
	public static void main(String[]args){
		

		ConnectionDb c = new ConnectionDb();
		
		long tSystemStart = System.nanoTime();
		
		TestSystemUser();
		

		long tSystemEnd = System.nanoTime();
		System.out.println("System time: "+(tSystemEnd - tSystemStart)+" nanoseconds");
		long  tUserStart = System.nanoTime();
		TestLoggedUser();

		long tUserEnd = System.nanoTime();

		System.out.println("System time: "+(tUserEnd - tUserStart)+" nanoseconds");
		
//		ConnectionDb c = new ConnectionDb();
//		List<String> patientNameList;
//		List<BigInteger> patientAgeList;
////		TestConnectionDB t= new TestConnectionDB();
////		t.testGetMysqlConnection_Is_Connection_class();
//		
//		
//		BigInteger p = new BigInteger("92250842239383935966460454796463127248021803261441077775431438424667619019597");
//		BigInteger q = new BigInteger("60402789000353836433491821747395216567925711915280511547643571203735404707597");
//		/* instantiating an object of Paillier cryptosystem */
//		Paillier paillier = new Paillier(p,q, 512);
//		
////		Paillier paillierUser = new Paillier(1024,128);
//
//		System.out.println("P: "+ paillier.getP());
//		System.out.println("Q: "+ paillier.getQ());
//		
////		System.out.println("P: "+ paillierUser.getP());
////		System.out.println("Q: "+ paillierUser.getQ());
//		
//		String userType;
//		if(paillier.getP().toString().length()<=100){
//			userType ="System";
//		}else{
//			userType = "U1";
//		}
////		Thread t= new Thread();
//		List<BigInteger> d= GenerateData(c,paillier, userType);
//		try {
//			patientNameList =c.getMySqlConnectionDB().getSecurePatientName();
////			patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge();
//			patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge(userType);
//			BigInteger z = Sum(patientAgeList, paillier);
//			System.out.println(z);
//			System.out.println(paillier.Decryption(z).toString());
//			for (int i = 0; i < patientAgeList.size(); i++) {
//				System.out.println(paillier.Decryption(patientAgeList.get(i)));
//			}
//			System.out.println(patientAgeList);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		/* instantiating two plaintext msgs */
//		BigInteger m1 = new BigInteger("30");
//		BigInteger m2 = new BigInteger("60");
		/* encryption */
//		BigInteger em1 = paillier.Encryption(m1);
//		BigInteger em2 = paillier.Encryption(m2);
//		/* printout encrypted text */
//		System.out.println("encrypted text m1: "+em1);
//		System.out.println("encrypted text m2: "+em2);
//		/* printout decrypted text */
//		System.out.println(paillier.Decryption(em1).toString());
//		System.out.println(paillier.Decryption(em2).toString());
//
//		/*
//		 * test homomorphic properties -> D(E(m1)*E(m2) mod n^2) = (m1 + m2) mod
//		 * n
//		 */
//		BigInteger product_em1em2 = em1.multiply(em2).mod(paillier.nsquare);
//		BigInteger sum_m1m2 = m1.add(m2).mod(paillier.n);
//		System.out.println("original sum: " + sum_m1m2.toString());
//		System.out.println("decrypted sum: "
//				+ paillier.Decryption(product_em1em2).toString());
//
//		/* test homomorphic properties -> D(E(m1)^m2 mod n^2) = (m1*m2) mod n */
//		BigInteger expo_em1m2 = em1.modPow(m2, paillier.nsquare);
//		BigInteger prod_m1m2 = m1.multiply(m2).mod(paillier.n);
//		System.out.println("original product: " + prod_m1m2.toString());
//		System.out.println("decrypted product: "
//				+ paillier.Decryption(expo_em1m2).toString());

	}
	
	public static void TestLoggedUser(){

		ConnectionDb c = new ConnectionDb();
		List<String> patientNameList;
		List<BigInteger> patientAgeList;
//		TestConnectionDB t= new TestConnectionDB();
//		t.testGetMysqlConnection_Is_Connection_class();
		
		
		BigInteger p = new BigInteger("8221402702548272830308353826272884305585665723761169259463041292332529721431254393076581862166813404530300159578790067496464807560591529003599073397549273");
		BigInteger q = new BigInteger("9583204913178807923068962039027666551846037770399803623348456205666959228784781552502941843675128339722106786582259811263350768582927536220253464695532361");
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier(p,q, 1024);
		
//		Paillier paillierUser = new Paillier(1024,128);

//		System.out.println("P: "+ paillier.getP());
//		System.out.println("Q: "+ paillier.getQ());
		
//		System.out.println("P: "+ paillierUser.getP());
//		System.out.println("Q: "+ paillierUser.getQ());
		
		String userType;
		if(paillier.getP().toString().length()<=100){
			userType ="System";
		}else{
			userType = "U1";
		}
//		Thread t= new Thread();
		List<BigInteger> d= GenerateData(c,paillier, userType);
		try {
//			patientNameList =c.getMySqlConnectionDB().getSecurePatientName();
//			patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge();
			patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge(userType);
			BigInteger z = Sum(patientAgeList, paillier);
//			System.out.println(z);
//			System.out.println(paillier.Decryption(z).toString());
//			for (int i = 0; i < patientAgeList.size(); i++) {
//				System.out.println(paillier.Decryption(patientAgeList.get(i)));
//			}
//			System.out.println(patientAgeList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void TestSystemUser(){

		ConnectionDb c = new ConnectionDb();
		List<String> patientNameList;
		List<BigInteger> patientAgeList;
//		TestConnectionDB t= new TestConnectionDB();
//		t.testGetMysqlConnection_Is_Connection_class();
		
		
		BigInteger p = new BigInteger("92250842239383935966460454796463127248021803261441077775431438424667619019597");
		BigInteger q = new BigInteger("60402789000353836433491821747395216567925711915280511547643571203735404707597");
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier(p,q, 512);
		
//		Paillier paillierUser = new Paillier(1024,128);

//		System.out.println("P: "+ paillier.getP());
//		System.out.println("Q: "+ paillier.getQ());
		
//		System.out.println("P: "+ paillierUser.getP());
//		System.out.println("Q: "+ paillierUser.getQ());
		
		String userType;
		if(paillier.getP().toString().length()<=100){
			userType ="System";
		}else{
			userType = "U1";
		}
//		Thread t= new Thread();
		List<BigInteger> d= GenerateData(c,paillier, userType);
		try {
//			patientNameList =c.getMySqlConnectionDB().getSecurePatientName();
//			patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge();
			patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge(userType);
			BigInteger z = Sum(patientAgeList, paillier);
//			System.out.println(z);
//			System.out.println(paillier.Decryption(z).toString());
//			for (int i = 0; i < patientAgeList.size(); i++) {
//				System.out.println(paillier.Decryption(patientAgeList.get(i)));
//			}
//			System.out.println(patientAgeList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BigInteger Sum(List<BigInteger> list, Paillier paillier){
		BigInteger sum = paillier.Encryption(new BigInteger("0")) ;
		for (int i = 0; i < list.size(); i++) {
			sum = list.get(i).multiply(sum).mod(paillier.nsquare);
			
//			sum = sum.multiply(a).mod(paillier.nsquare);
		}
		return sum;
	}
	//we generate 10 rows each time we test the application
	public static List<BigInteger> GenerateData(ConnectionDb conn,Paillier paillier, String userType){
		Random r = new Random();
		List<BigInteger> list = new ArrayList<BigInteger>();

		for (int i = 0; i < 1000; i++) {
			int age = r.nextInt(1000);
			BigInteger nr = new BigInteger(String.valueOf(age));
//			System.out.println(nr);
			BigInteger enr = paillier.Encryption(nr);
			list.add(enr);
			conn.getMySqlConnectionDB().insertSecurePatient("Test", enr, userType);
			//conn.getMySqlConnectionDB().insertInsecurePatient("Test", nr);

		}
		return list;
	}
}
