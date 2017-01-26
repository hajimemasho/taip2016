package queriesModule.java;

import java.math.BigInteger;

public class ClientUser{
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
	public UserLevelKeyLength getUserType() {
		return userType;
	}

	public void setUserType(UserLevelKeyLength userType) {
		this.userType = userType;
	}
	private String username;
	private BigInteger p;
	private BigInteger q;
	private int Certainty;
	private int KeyLength;
	private UserLevelKeyLength userType;
}