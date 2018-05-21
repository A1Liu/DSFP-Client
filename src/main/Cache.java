package main;

import util.ArrayQueue;

public class Cache {
	
	private static String username;
	private static String password;
	private static ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
	
	private Cache() {
		
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Cache.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Cache.password = password;
	}
	
	public static void addRequest(Integer i) {
		queue.enqueue(i);
	}
	
	public static Integer getNext() {
		return queue.dequeue();
	}
	
	public static boolean isEmpty() {
		return queue.isEmpty();
	}
}


