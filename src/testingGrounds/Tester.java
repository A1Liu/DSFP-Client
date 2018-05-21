package testingGrounds;

import misc.SimpleTester;

//import org.apache.commons.lang.ArrayUtils;


public class Tester extends SimpleTester {

	public static void main(String[] args) {
		Tester test = new Tester();
		test.run();
	}

	@Override
	public Object execute(String input) {
		return !(!input.split("[^\\-A-Za-z ]|(?<![a-zA-Z])[-]|[-](?![A-Za-z])")[0].equals(input) || input.endsWith("-") || input.trim().length() == 0);
	}

}
