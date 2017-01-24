package queriesModule.java;

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