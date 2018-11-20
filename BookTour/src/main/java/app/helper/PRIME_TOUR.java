package app.helper;

public enum PRIME_TOUR {
	TYPE1, TYPE2, TYPE3;
	public static String selectPrime(PRIME_TOUR v){
		String prime = null;
		switch (v) {
		case TYPE1:
			prime = "1.200.000";
			break;
		case TYPE2:
			prime = "3.200.000";
			break;
		case TYPE3:
			prime = "5.200.000";
			break;
		default:
			break;
		}
		return prime;
	}
}
