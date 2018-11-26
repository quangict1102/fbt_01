package app.helper;

public enum ROLES {
	ADMIN,USER;
	@Override
	  public String toString() {
	      if (this == ADMIN) {
	          return "admin";
	      } else {
	          return "user";
	      }
	     
	  }
	
}
