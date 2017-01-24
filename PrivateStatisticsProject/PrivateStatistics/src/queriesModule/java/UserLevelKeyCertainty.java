package queriesModule.java;

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