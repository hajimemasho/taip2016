package utilitiesModule.java;

public class KeyGenerator {

	private static KeyGenerator instanceKey = new KeyGenerator();
	
	private KeyGenerator(){
		String[] params = new String[2];
		setKey(params);
	}
	
	private void setKey(String[] params){
	}
	
	public static KeyGenerator getInstance(){
		 if(instanceKey == null) {
			 instanceKey = new KeyGenerator();
	      }
		return instanceKey;
	}
}
