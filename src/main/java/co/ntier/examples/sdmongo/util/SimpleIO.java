package co.ntier.examples.sdmongo.util;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * A simple utility class for interacting with a user via the command line. 
 */
public class SimpleIO {

	private Scanner input;
	private PrintStream output;
	
	public SimpleIO(Scanner input, PrintStream output) {
		super();
		this.input = input;
		this.output = output;
	}
	
	public String prompt(String msg){
		output.print(msg);
		return input.nextLine();
	}
	
	public void clearLines() {
		output.println("\n\n");
	}
	
	public void banner(String msg){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < msg.length(); i++){
			sb.append("=");
		}
		output.println(msg + " \n" + sb.toString());
	}
	
	public void println(String msg){
		output.println(msg);
	}
	
	
	
}
