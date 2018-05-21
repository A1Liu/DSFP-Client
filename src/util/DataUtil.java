package util;

import java.util.Enumeration;
import sun.misc.Queue;

public class DataUtil {

	private DataUtil() {
		
	}
	
	public static <T> boolean queueContains(Queue<T> q,T o) {
		Enumeration<T> e = q.elements();
		
		while(e.hasMoreElements()) {
			if (e.nextElement() == o)
				return true;
		}
		return false;
	}
	
}
