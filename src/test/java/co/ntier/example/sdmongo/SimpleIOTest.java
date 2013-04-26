package co.ntier.example.sdmongo;

import static org.junit.Assert.fail;

import java.util.Scanner;

import org.junit.Test;

import co.ntier.examples.sdmongo.util.SimpleIO;

public class SimpleIOTest {

	@Test(expected=IllegalArgumentException.class)
	public void testScannerParam() {
		new SimpleIO(null, System.out);
		fail("Should not accept null scanner");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPrintStreamParam() {
		new SimpleIO(new Scanner(System.in), null);
		fail("Should not accept null PrintStream");
	}

}
