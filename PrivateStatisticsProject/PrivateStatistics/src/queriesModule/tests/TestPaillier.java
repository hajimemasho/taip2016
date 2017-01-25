package queriesModule.tests;

import java.math.BigInteger;

import org.junit.Test;

import junit.framework.Assert;
import queriesModule.java.Paillier;

public class TestPaillier {
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		
		Paillier paillier = new Paillier();
		
//		BigInteger p = new BigInteger("7");
//		BigInteger q = new BigInteger("11");
		
		BigInteger m = new BigInteger("42");
//		BigInteger r = new BigInteger("23");
//		BigInteger g = new BigInteger("5652");
		
		
//		BigInteger c = g.modPow(m, nSquare).multiply(r.modPow(n, nSquare)).mod(nSquare);
		BigInteger c = paillier.Encryption(m);//, r);
		System.out.println("c = " + c);
		
		BigInteger decrypt = paillier.Decryption(c);
		System.out.println("decrypt: " + paillier.Decryption(c));
		
		
		Assert.assertEquals(decrypt.intValue(), 42);
	}
}
