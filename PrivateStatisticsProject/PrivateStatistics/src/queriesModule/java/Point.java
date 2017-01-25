package queriesModule.java;

import java.math.BigInteger;

/**
 * 
 * @author Carmen Cojocaru
 *
 */
public class Point {
	private BigInteger x;
	private BigInteger y;
	
	public Point(BigInteger x, BigInteger y) {
		this.x = x;
		this.y = y;
	}
	
	public BigInteger getX() {
		return x;
	}
	public void setX(BigInteger x) {
		this.x = x;
	}
	public BigInteger getY() {
		return y;
	}
	public void setY(BigInteger y) {
		this.y = y;
	}
}
