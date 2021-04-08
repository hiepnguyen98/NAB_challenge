package com.challenge.eCommerce.util;

public class CommonUtil {
	
	public static boolean isNullEmpty(String str) {
		if (str == null) {
	      return true;
	    }

	    // check if string is empty
	    else if(str.isEmpty()){
	      return true;
	    }

	    else {
	      return false;
	    }
	}
	
}
