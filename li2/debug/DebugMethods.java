package debug;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * This class holds static utility methods for debugging. All dependencies are public api
 * @author aliu
 *
 */
public class DebugMethods {

	private static String filePath = null;
	
	private DebugMethods() {}
	
	/**
	 * Sets the file path of the file to store information in
	 *@param file file path of file to store stuff in
	 */
	public static void setFilePath(String file) {
		filePath = file;
	}
	
	/**
	 * writes the tostring form of an object to the file specified by {@link DebugMethods#setFilePath(String)}
	 * @param o object to write
	 */
	public static void writeString(Object o) {
		if (o == null)
			write(null);
		else
			write(o.toString());
	}
	
	/**
	 * Writes information of an object to a file specified by {@link DebugMethods#setFilePath(String)}
	 * @param obj object to store
	 */
	public static <T extends Serializable> void write(T obj) {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File(filePath) ) );
			stream.writeObject(obj);
			stream.flush();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads information of an object from a file specified by {@link DebugMethods#setFilePath(String)}
	 * @return object from file
	 */
	public static Object read() {
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File(filePath) ) );
			Object o = stream.readObject();
			stream.close();
			return o;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Catches all exceptions for a function
	 * @param function function to catch exceptions for
	 * @param input input to give to function
	 * @return function's output, or null if an exception was thrown
	 */
	public static <I,O> O catchAll(Function<I,O> function, I input) {
		try {
			return function.apply(input);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Gets input from System.in and returns it
	 * @return String that was typed into command line, or null if there was an IOException
	 */
	public static String getSystemInput() {
		try {
			return new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Thread sleeps for a certain amount of time
	 * @param seconds seconds to sleep
	 */
	public static void sleep(int seconds) {
		try {Thread.sleep(seconds*1000);} catch (InterruptedException i) {i.printStackTrace();}
	}
	
	/**
	 * Prints an array object using {@link DebugMethods#print}
	 * @param array array to print
	 */
	public static <T> void printArray(T[] array) {
		print(arrayToList(array).toString());
	}

	/**
	 * Prints the toString of the object, or 'null' if the object is a null
	 * @param o object to print
	 */
	public static void systemPrint(Object o) {
		if (o == null)
			System.out.println("null");
		else
			System.out.println(o.toString());
	}
	
	/**
	 * Prints a marker statement to the system output
	 */
	public static void print() {
		System.out.printf("Print Statement called at %s", Thread.currentThread().getStackTrace()[2].toString());
	}
	
	/**
	 * Prints an object, the object's class, and the location of the print statement
	 * @param o object to print
	 */
	public static void print(Object o) {
		String output;
		String outputClass;
		if (o == null) {
			output = null;
			
			outputClass = "unknown class: object is null";
		} else {
			output = o.toString();
			outputClass = output.getClass().toString();
		}
		System.out.printf("Object class: <%s>%nObject value: [%s]%nPrint Called at: %s",outputClass,output,Thread.currentThread().getStackTrace()[2].toString());//prints out the location of where this statement was called
	}
	
	/**
	 * turns an array to a list
	 * @param array array to return
	 * @return array as a list
	 */
	private static <T> List<T> arrayToList(T[] array) {
		List<T> list = new ArrayList<T>();
		for (T item : array) {
			list.add(item);
		}return list;
	}
}
