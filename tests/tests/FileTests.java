package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import fs.*;

public class FileTests {
	
	@Test
	public void testUnixRename() {
		FileSystem fs = new Unix();
		String root = "/opt/c2";
		String path = "/opt/c2/something/else/test.txt";
		String expected = "/opt/c2/something-else-test.txt";
		String actual = fs.newFileDestination(root, path).getAbsolutePath();
		
		assertEquals(expected, actual);
		
		root = "/opt/c2";
		path = "/opt/c2/something/else/test-1.txt";
		expected = "/opt/c2/something-else-test-1.txt";
		actual = fs.newFileDestination(root, path).getAbsolutePath();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWindowsRename() throws IOException {
		FileSystem fs = new Windows();
	}
	@Test
	public void testCopy() {
		//System.out.println(new File("moveTest").listFiles()[0].toString());
	}
}
