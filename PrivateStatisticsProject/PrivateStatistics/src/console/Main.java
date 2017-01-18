package console;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import queriesModule.java.Paillier;
import databaseModule.java.ConnectionDb;
import databaseModule.tests.TestConnectionDB;

public class Main {
	public static void main(String[]args){
		
		ConnectionDb c = new ConnectionDb();
		List<String> patientNameList;
		List<BigInteger> patientAgeList;
		TestConnectionDB t= new TestConnectionDB();
		t.testGetMysqlConnection_Is_Connection_class();
		
		
		/* instantiating an object of Paillier cryptosystem */
		Paillier paillier = new Paillier();
		
		List<BigInteger> d= GenerateData(c,paillier);
		BigInteger z = Sum(d, paillier);
		System.out.println(z);
		System.out.println(paillier.Decryption(z).toString());
		try {
			patientNameList =c.getMySqlConnectionDB().getSecurePatientName();
			patientAgeList =c.getMySqlConnectionDB().getSecurePatientAge();
			for (int i = 0; i < patientAgeList.size(); i++) {
				System.out.println(paillier.Decryption(patientAgeList.get(i)));
			}
			System.out.println(patientAgeList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public static BigInteger Sum(List<BigInteger> list, Paillier paillier){
		BigInteger sum = paillier.Encryption(new BigInteger("0")) ;
		for (int i = 0; i < list.size(); i++) {
			sum = list.get(i).multiply(sum).mod(paillier.nsquare);
			
//			sum = sum.multiply(a).mod(paillier.nsquare);
		}
		return sum;
	}
	//we generate 10 rows each time we test the application
	public static List<BigInteger> GenerateData(ConnectionDb conn,Paillier paillier){
		Random r = new Random();
		List<BigInteger> list = new ArrayList<BigInteger>();
		for (int i = 0; i < 10; i++) {
			int age = r.nextInt(1000);
			BigInteger nr = new BigInteger(String.valueOf(age));
			System.out.println(nr);
			BigInteger enr = paillier.Encryption(nr);
			list.add(enr);
			conn.getMySqlConnectionDB().insertSecurePatient("Test", enr);
			//conn.getMySqlConnectionDB().insertInsecurePatient("Test", nr);

		}
		return list;
	}
}
